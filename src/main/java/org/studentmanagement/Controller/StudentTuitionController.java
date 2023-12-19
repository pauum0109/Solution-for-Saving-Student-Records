package org.studentmanagement.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.studentmanagement.Entity.Student;
import org.studentmanagement.Model.TuitionModel;
import org.studentmanagement.Utils.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StudentTuitionController implements Initializable{

    @FXML
    private TableColumn<TuitionModel, Integer> tuitionAmount;

    @FXML
    private TableColumn<TuitionModel, String> tuitionDeadline;

    @FXML
    private TableColumn<TuitionModel, Integer> tuitionID;

    @FXML
    private TableColumn<TuitionModel, Integer> tuitionSemester;

    @FXML
    private TableColumn<TuitionModel, String> tuitionStatus;

    @FXML
    private TableView<TuitionModel> tuitionData;

    Connection con;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public StudentTuitionController(){
        con = ConnectionUtil.conDB();
    }

    void getTuitionData() {

        Student student = Student.getInstance();

        String sql = "SELECT * FROM tuition where tuition.studentID = ?";
        try{
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, student.getStudentID());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                tuitionModels.add(new TuitionModel(
                        resultSet.getInt("tuitionID"),
                        resultSet.getInt("tuitionAmount"),
                        resultSet.getString("tuitionDeadline"),
                        resultSet.getString("tuitionStatus"),
                        resultSet.getInt("tuitionSemester")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getTuitionData();
        tuitionID.setCellValueFactory(cellData -> cellData.getValue().getTuitionID().asObject());
        tuitionAmount.setCellValueFactory(cellData -> cellData.getValue().getTuitionAmount().asObject());
        tuitionDeadline.setCellValueFactory(cellData -> cellData.getValue().getTuitionDeadline());
        tuitionStatus.setCellValueFactory(cellData -> cellData.getValue().getTuitionStatus());
        tuitionSemester.setCellValueFactory(cellData -> cellData.getValue().getTuitionSemester().asObject());
        tuitionData.setItems(tuitionModels);
    }

    private final ObservableList<TuitionModel> tuitionModels = FXCollections.observableArrayList();
}
