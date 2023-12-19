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

public class AdminProfessorController {

    @FXML
    private Button btn_ADD;

    @FXML
    private Button btn_REMOVE;

    @FXML
    void handleButtonClicks(ActionEvent event) {
        if(event.getSource() == btn_ADD) {
            loadStage("AdminAddProfessor.fxml");
        }
        else if(event.getSource() == btn_REMOVE) {
            loadStage("AdminRemoveProfessor.fxml");

        }
        else if(event.getSource() == btn_REMOVE) {

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
