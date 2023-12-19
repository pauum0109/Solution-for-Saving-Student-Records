package org.studentmanagement.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class StudentHomeController implements Initializable {

    @FXML
    private Button btn_info;

    @FXML
    private Button btn_Course;

    @FXML
    private Button btn_Class;

    @FXML
    private Button btn_Tuition;

    @FXML
    private Button btn_scholarship;

    @FXML
    private Button btnClasses;

    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        if (mouseEvent.getSource() == btn_info) {
            loadStage("StudentInfo.fxml");
        } else if (mouseEvent.getSource() == btn_Course) {
            loadStage("StudentCourse.fxml");
        } else if (mouseEvent.getSource() == btn_Class) {
            loadStage("StudentClass.fxml");
        } else if(mouseEvent.getSource() == btn_Tuition){
            loadStage("StudentTuition.fxml");
        } else if(mouseEvent.getSource() == btn_scholarship){
            loadStage("StudentScholarship.fxml");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
//            stage.getIcons().add(new Image("/icons/icon.png"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
