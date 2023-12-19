package org.studentmanagement.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.studentmanagement.Entity.Professor;
import org.studentmanagement.Model.CourseModel;
import org.studentmanagement.Utils.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProfessorCourseController implements Initializable {

    @FXML
    private TableColumn<CourseModel, String> courseCredit;

    @FXML
    private TableView<CourseModel> courseData;

    @FXML
    private TableColumn<CourseModel, String> courseDay;

    @FXML
    private TableColumn<CourseModel, String> courseDescription;

    @FXML
    private TableColumn<CourseModel, Integer> courseID;

    @FXML
    private TableColumn<CourseModel, String> courseName;

    @FXML
    private TableColumn<CourseModel, String> courseRoom;

    @FXML
    private TableColumn<CourseModel, String> courseTime;

    Connection con;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public ProfessorCourseController(){
        con = ConnectionUtil.conDB();
    }

    private List<Long> getClassId(){
        List<Long> classId = new ArrayList<>();
        Professor professor = Professor.getInstance();
        String sql = "SELECT classID FROM class WHERE professorID = ?";
        try{
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, professor.getProfessorID());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                classId.add(resultSet.getLong("classID"));
            }
        }
        catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
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
            throw new RuntimeException(sqlException);
        }

        return courseId;
    }

    private void getCourseData(List<Long> courseId) {
        String sql = "SELECT * FROM course WHERE courseID = ?";
        try{
            preparedStatement = con.prepareStatement(sql);
            for (Long id : courseId) {
                preparedStatement.setLong(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    assert false;
                    coursesModelObservableList.add(new CourseModel(
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
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Long> classId = getClassId();
        List<Long> courseId = getCourseId(classId);
        getCourseData(courseId);

        courseID.setCellValueFactory(cellData -> cellData.getValue().getCourseID().asObject());
        courseName.setCellValueFactory(cellData -> cellData.getValue().getCourseName());
        courseDescription.setCellValueFactory(cellData -> cellData.getValue().getCourseDescription());
        courseCredit.setCellValueFactory(cellData -> cellData.getValue().getCourseCredit());
        courseDay.setCellValueFactory(cellData -> cellData.getValue().getCourseDay());
        courseTime.setCellValueFactory(cellData -> cellData.getValue().getCourseTime());
        courseRoom.setCellValueFactory(cellData -> cellData.getValue().getCourseRoom());
        courseData.setItems(coursesModelObservableList);
    }

    private final ObservableList<CourseModel> coursesModelObservableList = FXCollections.observableArrayList();

}
