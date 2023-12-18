package org.studentmanagement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.studentmanagement.models.Student;
import org.studentmanagement.utils.ConnectionUtil;


import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class StudentCoursesController implements Initializable {

    @FXML
    private TableColumn<CoursesModel, String> courseCredit;

    @FXML
    private TableView<CoursesModel> courseData;

    @FXML
    private TableColumn<CoursesModel, String> courseDay;

    @FXML
    private TableColumn<CoursesModel, String> courseDescription;

    @FXML
    private TableColumn<CoursesModel, Integer> courseID;

    @FXML
    private TableColumn<CoursesModel, String> courseName;

    @FXML
    private TableColumn<CoursesModel, String> courseRoom;

    @FXML
    private TableColumn<CoursesModel, String> courseTime;

    Connection con;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public StudentCoursesController(){
        con = ConnectionUtil.conDB();
    }

    private List<Long> getClassId() {
        List<Long> classId = new ArrayList<>();
        Student student = Student.getInstance();

        String sql = "SELECT classID FROM enrollment WHERE studentID = ?";
        try{
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, student.getStudentID());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                assert false;
                classId.add(resultSet.getLong("classID"));
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return classId;
    }

    private List<Long> getCourseId(List<Long> classId) {
        List<Long> courseId = new ArrayList<>();

        String sql = "SELECT courseID FROM class WHERE classID = ?";
        try{
            preparedStatement = con.prepareStatement(sql);
            for (Long id : classId) {
                preparedStatement.setLong(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    assert false;
                    courseId.add(resultSet.getLong("courseID"));
                }
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }

        return courseId;
    }

    private void getCourse(List<Long> courseId) {
        String sql = "SELECT * FROM course WHERE courseID = ?";
        try{
            preparedStatement = con.prepareStatement(sql);
            for (Long id : courseId) {
                preparedStatement.setLong(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    assert false;
                    coursesModelObservableList.add(new CoursesModel(
                            resultSet.getInt("courseID"),
                            resultSet.getString("courseName"),
                            resultSet.getString("courseDescription"),
                            resultSet.getString("courseCredit"),
                            resultSet.getString("courseDay"),
                            resultSet.getString("courseTime"),
                            resultSet.getString("courseRoom")
                    ));
                }
            }
        }
        catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Long> classId = getClassId();
        List<Long> courseId = getCourseId(classId);
        getCourse(courseId);

        courseID.setCellValueFactory(new PropertyValueFactory<>("CourseID"));
        courseName.setCellValueFactory(new PropertyValueFactory<>("CourseName"));
        courseDescription.setCellValueFactory(new PropertyValueFactory<>("CourseDescription"));
        courseCredit.setCellValueFactory(new PropertyValueFactory<>("CourseCredit"));
        courseDay.setCellValueFactory(new PropertyValueFactory<>("CourseDay"));
        courseTime.setCellValueFactory(new PropertyValueFactory<>("CourseTime"));
        courseRoom.setCellValueFactory(new PropertyValueFactory<>("CourseRoom"));
        courseData.setItems(coursesModelObservableList);
    }

    private ObservableList<CoursesModel> coursesModelObservableList = FXCollections.observableArrayList();

}
