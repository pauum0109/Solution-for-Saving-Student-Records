package org.studentmanagement;

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

public class StudentController implements Initializable {

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

    //my bad - the freaking mouse event
    @FXML
    private void handleButtonClicks(javafx.event.ActionEvent mouseEvent) {
        System.out.println("Button Clicked");

        if (mouseEvent.getSource() == btn_info) {
            loadStage("StudentInfo.fxml");
        } else if (mouseEvent.getSource() == btn_Course) {
            loadStage("StudentsCourses.fxml");
        } else if (mouseEvent.getSource() == btn_Class) {
            loadStage("StudentsClass.fxml");
        }
        if(mouseEvent.getSource() == btn_Tuition){
            System.out.println("Tuition");
            loadStage("StudentTuition.fxml");
        }

        if(mouseEvent.getSource() == btn_scholarship){
            System.out.println("Scholarship");
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
            e.printStackTrace();
        }
    }
}
