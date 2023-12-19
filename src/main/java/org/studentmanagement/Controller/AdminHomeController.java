package org.studentmanagement.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminHomeController {

    @FXML
    private Button btn_Professor;

    @FXML
    private Button btn_Student;

    @FXML
    private Button btn_info;

    @FXML
    void handleButtonClicks(ActionEvent event) {
        if(event.getSource() == btn_Professor){
            System.out.println("Professor");
        }else if(event.getSource() == btn_Student){
            System.out.println("Student");
        }else if(event.getSource() == btn_info){
            System.out.println("Info");
        }
    }

}
