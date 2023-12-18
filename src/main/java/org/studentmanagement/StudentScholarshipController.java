package org.studentmanagement;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.studentmanagement.models.Student;
import org.studentmanagement.utils.ConnectionUtil;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentScholarshipController implements Initializable {

    @FXML
    private TableView<ScholarshipModel> scholarshipData;

    @FXML
    private TableColumn<ScholarshipModel, String> scholarshipDescription;

    @FXML
    private TableColumn<ScholarshipModel, Integer> scholarshipID;

    @FXML
    private TableColumn<ScholarshipModel, String> scholarshipName;

    Connection con;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public StudentScholarshipController() {
        con = ConnectionUtil.conDB();
    }

    private List<Long> getScholarshipIds() {
        List<Long> scholarshipIds = new ArrayList<>();
        Student student = Student.getInstance();
        String sql = "SELECT * FROM student_scholarship where student_scholarship.studentID = ?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, student.getStudentID());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                scholarshipIds.add(resultSet.getLong("scholarshipID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return scholarshipIds;
    }

    private void getScholarshipData(List<Long> scholarshipIds){
        String sql = "SELECT * FROM scholarship WHERE scholarshipID = ?";
        try{
            for (Long scholarshipId : scholarshipIds) {
                preparedStatement = con.prepareStatement(sql);
                preparedStatement.setLong(1, scholarshipId);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    scholarshipModels.add(new ScholarshipModel(
                            resultSet.getInt("scholarshipID"),
                            resultSet.getString("scholarshipName"),
                            resultSet.getString("scholarshipDescription")
                    ));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Long> scholarshipIds = getScholarshipIds();
        getScholarshipData(scholarshipIds);
        scholarshipID.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("scholarshipId"));
        scholarshipName.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("scholarshipName"));
        scholarshipDescription.setCellValueFactory(new javafx.scene.control.cell.PropertyValueFactory<>("scholarshipDescription"));
        scholarshipData.setItems(scholarshipModels);
    }

    private ObservableList<ScholarshipModel> scholarshipModels = javafx.collections.FXCollections.observableArrayList();
}
