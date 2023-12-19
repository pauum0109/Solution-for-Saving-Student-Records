package org.studentmanagement.Controller;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.studentmanagement.Entity.Professor;
import org.studentmanagement.Entity.Score;
import org.studentmanagement.Model.StudentScoreModel;
import org.studentmanagement.Utils.ConnectionUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class ProfessorStudentController implements Initializable {

    @FXML
    private ComboBox<String> CourseList;

    @FXML
    private TableColumn<StudentScoreModel, String> Edit;

    @FXML
    private TableView<StudentScoreModel> StudentData;

    @FXML
    private Button btn_CourseFind;

    @FXML
    private TableColumn<StudentScoreModel, Integer> studentID;

    @FXML
    private TableColumn<StudentScoreModel, String> studentName;

    @FXML
    private TableColumn<StudentScoreModel, Integer> studentScore;

    Connection con;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public ProfessorStudentController(){
        con = ConnectionUtil.conDB();
    }

    private List<Long> getClassIdByProfessor(){
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

    private void getCourseName(List<Long> courseId){
        String sql = "SELECT * FROM course WHERE courseID = ?";
        try{
            preparedStatement = con.prepareStatement(sql);
            for (Long id : courseId) {
                preparedStatement.setLong(1, id);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    assert false;
                    courseList.add(resultSet.getString("courseName"));
                }
            }
        }
        catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }


    private void editTable() {
        StudentData.getItems().clear();
        studentScoreModelObservableList.clear();
        String courseName = CourseList.getValue();
        String sql = "SELECT * FROM course WHERE courseName = ?";
        int classID = 0;
        try{
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, courseName);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                assert false;
                long courseID = resultSet.getLong("courseID");
                String sql2 = "SELECT * FROM class WHERE courseID = ?";
                preparedStatement = con.prepareStatement(sql2);
                preparedStatement.setLong(1, courseID);
                ResultSet resultSet2 = preparedStatement.executeQuery();
                while(resultSet2.next()){
                    classID = resultSet2.getInt("classID");
                    String sql3 = "SELECT * FROM enrollment WHERE classID = ?";
                    preparedStatement = con.prepareStatement(sql3);
                    preparedStatement.setLong(1, classID);
                    ResultSet resultSet3 = preparedStatement.executeQuery();
                    while(resultSet3.next()){
                        String studentID = resultSet3.getString("studentID");
                        String sql4 = "SELECT * FROM student WHERE studentID = ?";
                        preparedStatement = con.prepareStatement(sql4);
                        preparedStatement.setString(1, studentID);
                        ResultSet resultSet4 = preparedStatement.executeQuery();
                        while(resultSet4.next()){
                            String studentFirstName = resultSet4.getString("studentFirstName");
                            String studentLastName = resultSet4.getString("studentLastName");
                            String studentName = studentFirstName + " " + studentLastName;
                            int studentScore = resultSet3.getInt("score");
                            studentScoreModelObservableList.add(new StudentScoreModel(resultSet3.getInt("studentID"), studentName, studentScore));
                        }
                    }
                }
            }

            studentID.setCellValueFactory(cellData -> cellData.getValue().getStudentID().asObject());
            studentName.setCellValueFactory(cellData -> cellData.getValue().getStudentName());
            studentScore.setCellValueFactory(cellData -> cellData.getValue().getStudentScore().asObject());

            int finalClassID = classID;
            Callback<TableColumn<StudentScoreModel, String>, TableCell<StudentScoreModel, String>> cellCallback = (TableColumn<StudentScoreModel, String> param) -> new TableCell<>() {
                @Override
                public void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                        setText(null);
                    } else {
                        FontAwesomeIconView editIcon = new FontAwesomeIconView(FontAwesomeIcon.PENCIL_SQUARE);
                        editIcon.setStyle(
                                " -fx-cursor: hand ;"
                                        + "-glyph-size:28px;"
                                        + "-fx-fill:#00E676;"
                        );

                        editIcon.setOnMouseClicked((MouseEvent event1) -> {
                            StudentScoreModel studentScoreModel = StudentData.getSelectionModel().getSelectedItem();
                            Score score = Score.getInstance();
                            score.setStudentID(studentScoreModel.getStudentID().getValue());
                            score.setStudentName(studentScoreModel.getStudentName().getValue());
                            score.setStudentScore(studentScoreModel.getStudentScore().getValue());
                            score.setClassID(finalClassID);
                            loadStage();
                        });

                        HBox manageBtn = new HBox(editIcon);
                        manageBtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(editIcon, new Insets(2, 2, 0, 3));
                        setGraphic(manageBtn);
                        setText(null);

                    }
                }
            };
            Edit.setCellFactory(cellCallback);
            StudentData.setItems(studentScoreModelObservableList);
        }
        catch (SQLException sqlException){
            throw new RuntimeException(sqlException);
        }
    }

    @FXML
    void handleFindBtn(ActionEvent event) {
        if(event.getSource() == btn_CourseFind){
            editTable();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Long> classId = getClassIdByProfessor();
        List<Long> courseId = getCourseId(classId);
        getCourseName(courseId);
        CourseList.setItems(courseList);
    }

    private final ObservableList<String> courseList = FXCollections.observableArrayList();
    private final ObservableList<StudentScoreModel> studentScoreModelObservableList = FXCollections.observableArrayList();

    private void loadStage() {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("EditScore.fxml")));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
