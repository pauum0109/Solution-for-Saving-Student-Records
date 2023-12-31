package org.studentmanagement.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class AdminHomeController {

    @FXML
    private Button btn_Course;

    @FXML
    private Button btn_Professor;

    @FXML
    private Button btn_Student;

    @FXML
    private Button btn_info;

    @FXML
    void handleButtonClicks(ActionEvent event) {
        if(event.getSource() == btn_Professor){
            loadStage("AdminProfessor.fxml");
        }else if(event.getSource() == btn_Student){
            loadStage("AdminStudent.fxml");
        }else if(event.getSource() == btn_info){
            loadStage("AdminInfo.fxml");
        }else if(event.getSource() == btn_Course){
            loadStage("AdminCourse.fxml");
        }
    }

    private void loadStage(String fxml) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
