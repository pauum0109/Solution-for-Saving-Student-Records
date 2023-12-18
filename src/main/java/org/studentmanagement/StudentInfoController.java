package org.studentmanagement;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.studentmanagement.models.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentInfoController implements Initializable {
    @FXML
    private Label studentAddress;

    @FXML
    private Label studentDOB;

    @FXML
    private Label studentEmail;

    @FXML
    private Label studentFirstName;

    @FXML
    private Label studentGender;

    @FXML
    private Label studentID;

    @FXML
    private Label studentLastName;

    @FXML
    private Label studentMajor;

    @FXML
    private Label studentPhone;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loadStudents();
    }


    private void loadStudents()
    {
        Student student = Student.getInstance();
        studentID.setText(student.getStudentID());
        studentFirstName.setText(student.getStudentFirstName());
        studentLastName.setText(student.getStudentLastName());
        studentDOB.setText(student.getStudentDOB());
        studentGender.setText(student.getStudentGender());
        studentAddress.setText(student.getStudentAddress());
        studentPhone.setText(student.getStudentPhone());
        studentEmail.setText(student.getStudentEmail());
        studentMajor.setText(student.getStudentMajor());
    }

}
