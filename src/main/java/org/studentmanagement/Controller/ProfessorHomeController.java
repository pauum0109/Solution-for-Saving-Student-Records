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

public class ProfessorHomeController {



    @FXML
    private Button btn_Class;

    @FXML
    private Button btn_Course;


    @FXML
    private Button btn_info;

    @FXML
    private Button btn_Student;

    @FXML
    void handleButtonClicks(ActionEvent event) {
        if(event.getSource() == btn_info){
            loadStage("ProfessorInfo.fxml");
        }
        else if(event.getSource() == btn_Course){
            loadStage("ProfessorCourse.fxml");
        }
        else if(event.getSource() == btn_Class){
            loadStage("ProfessorClass.fxml");
        }
        else if(event.getSource() == btn_Student){
            loadStage("ProfessorStudent.fxml");
        }
//        else if(event.getSource() == btn_Tuition){
//            loadStage("ProfessorTuition.fxml");
//        }
//        else if(event.getSource() == btn_scholarship){
//            loadStage("ProfessorScholarship.fxml");
//        }
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
