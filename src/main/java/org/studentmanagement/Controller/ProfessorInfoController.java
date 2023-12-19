package org.studentmanagement.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.studentmanagement.Entity.Professor;

import java.net.URL;
import java.util.ResourceBundle;

public class ProfessorInfoController implements Initializable {

    @FXML
    private Label professorAddress;

    @FXML
    private Label professorDOB;

    @FXML
    private Label professorEmail;

    @FXML
    private Label professorFirstName;

    @FXML
    private Label professorGender;

    @FXML
    private Label professorID;

    @FXML
    private Label professorLastName;

    @FXML
    private Label professorMajor;

    @FXML
    private Label professorPhone;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadProfessors();
    }

    private void loadProfessors()
    {
        Professor professor = Professor.getInstance();
        professorID.setText(professor.getProfessorID());
        professorFirstName.setText(professor.getProfessorFirstName());
        professorLastName.setText(professor.getProfessorLastName());
        professorDOB.setText(professor.getProfessorDOB());
        professorGender.setText(professor.getProfessorGender());
        professorAddress.setText(professor.getProfessorAddress());
        professorPhone.setText(professor.getProfessorPhone());
        professorEmail.setText(professor.getProfessorEmail());
        professorMajor.setText(professor.getProfessorDepartment());
    }
}
