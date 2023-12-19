package org.studentmanagement.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.studentmanagement.Entity.Student;
import org.studentmanagement.Model.ClassModel;
import org.studentmanagement.Utils.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentClassController implements Initializable {

    @FXML
    private TableColumn<ClassModel, Integer> availableSlots;

    @FXML
    private TableColumn<ClassModel, Integer> classID;

    @FXML
    private TableView<ClassModel> classData;

    @FXML
    private TableColumn<ClassModel, String> courseName;

    @FXML
    private TableColumn<ClassModel, String> endDate;

    @FXML
    private TableColumn<ClassModel, String> professorName;

    @FXML
    private TableColumn<ClassModel, Integer> slots;

    @FXML
    private TableColumn<ClassModel, String> startDate;

    Connection con;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public StudentClassController() {
        con = ConnectionUtil.conDB();
    }

    private List<Long> getClassId() {
        List<Long> classId = new ArrayList<>();
        Student student = Student.getInstance();

        String sql = "SELECT classID FROM enrollment WHERE studentID = ?";
        try {
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, student.getStudentID());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                assert false;
                classId.add(resultSet.getLong("classID"));
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }

        return classId;
    }

    private void getClassInfo(List<Long> classId) {
        String sql = "SELECT * FROM class WHERE classID = ?";
        try {
            preparedStatement = con.prepareStatement(sql);
            for (Long id : classId) {
                preparedStatement.setLong(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    Integer classID = resultSet.getInt("classID");
                    int courseID = resultSet.getInt("courseID");
                    int professorID = resultSet.getInt("professorID");
                    String startDate = resultSet.getString("startDate");
                    String endDate = resultSet.getString("endDate");
                    Integer slots = resultSet.getInt("slots");
                    Integer availableSlots = resultSet.getInt("availableSlots");

                    String sql2 = "SELECT * FROM course WHERE course.courseID = ?";
                    preparedStatement = con.prepareStatement(sql2);
                    preparedStatement.setInt(1, courseID);
                    ResultSet resultSet2 = preparedStatement.executeQuery();
                    resultSet2.next();
                    String courseName = resultSet2.getString("courseName");

                    String sql3 = "SELECT * FROM professor WHERE professorID = ?";
                    preparedStatement = con.prepareStatement(sql3);
                    preparedStatement.setInt(1, professorID);
                    ResultSet resultSet3 = preparedStatement.executeQuery();
                    resultSet3.next();
                    String professorName = resultSet3.getString("professorFirstName") + " " + resultSet3.getString("professorLastName");

                    classModelObservableList.add(new ClassModel(classID, courseName, professorName, startDate, endDate, slots, availableSlots));
                }
            }
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Long> classId = getClassId();
        getClassInfo(classId);

        classID.setCellValueFactory(cellData -> cellData.getValue().getClassID().asObject());
        courseName.setCellValueFactory(cellData -> cellData.getValue().getCourseName());
        professorName.setCellValueFactory(cellData -> cellData.getValue().getProfessorName());
        startDate.setCellValueFactory(cellData -> cellData.getValue().getStartDate());
        endDate.setCellValueFactory(cellData -> cellData.getValue().getEndDate());
        slots.setCellValueFactory(cellData -> cellData.getValue().getSlots().asObject());
        availableSlots.setCellValueFactory(cellData -> cellData.getValue().getAvailableSlots().asObject());
        classData.setItems(classModelObservableList);
    }

    private final ObservableList<ClassModel> classModelObservableList = FXCollections.observableArrayList();
}
