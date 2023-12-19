package org.studentmanagement.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.studentmanagement.Entity.Student;
import org.studentmanagement.Model.ScholarshipModel;
import org.studentmanagement.Utils.ConnectionUtil;


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
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Long> scholarshipIds = getScholarshipIds();
        getScholarshipData(scholarshipIds);
        scholarshipID.setCellValueFactory(cellData -> cellData.getValue().getScholarshipId().asObject());
        scholarshipName.setCellValueFactory(cellData -> cellData.getValue().getScholarshipName());
        scholarshipDescription.setCellValueFactory(cellData -> cellData.getValue().getScholarshipDescription());
        scholarshipData.setItems(scholarshipModels);
    }

    private final ObservableList<ScholarshipModel> scholarshipModels = javafx.collections.FXCollections.observableArrayList();
}
