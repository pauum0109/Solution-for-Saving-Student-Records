package org.studentmanagement.Controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.studentmanagement.Entity.Student;
import org.studentmanagement.Utils.ConnectionUtil;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Label lblErrors;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnSignIn;

    Connection con;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private void changeScene(MouseEvent event, String fxml){
        try {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml))));
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @FXML
    public void handleButtonAction(MouseEvent event) {
        if (event.getSource() == btnSignIn) {
            if (logIn().equals("student")) {
                changeScene(event, "StudentHome.fxml");
            }
            else if(logIn().equals("professor")){
                changeScene(event, "ProfessorHome.fxml");
            }
            else if(logIn().equals("admin")){
                changeScene(event, "AdminHome.fxml");
            }
            
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (con == null) {
            lblErrors.setTextFill(Color.TOMATO);
            lblErrors.setText("Server Error : Check");
        } else {
            lblErrors.setTextFill(Color.GREEN);
            lblErrors.setText("Server is up : Good to go");
        }
    }

    public LoginController() {
        con = ConnectionUtil.conDB();
    }

    private String logIn() {
        String status = "Success";
        String email = txtUsername.getText();
        String password = txtPassword.getText();
        if(email.isEmpty() || password.isEmpty()) {
            setLblError(Color.TOMATO, "Empty credentials");
            status = "Error";
        } else {
            //query

            String sql1 = "SELECT * FROM user Where (user.userEmail = ? and user.userPassword = ?) or (user.username = ? and user.userPassword = ?);";
            try {
                preparedStatement = con.prepareStatement(sql1);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, email);
                preparedStatement.setString(4, password);
                resultSet = preparedStatement.executeQuery();
                if (!resultSet.next()) {
                    setLblError(Color.TOMATO, "Enter Correct Email/Password");
                    status = "Error";
                } else {
                    setLblError(Color.GREEN, "Login Successful..Redirecting..");
                    if(resultSet.getString("userRole").equals("student")){
                        String sql2 = "SELECT * FROM student Where student.userID = ?;";
                        try {
                            preparedStatement = con.prepareStatement(sql2);
                            preparedStatement.setString(1, resultSet.getString("userID"));
                            resultSet = preparedStatement.executeQuery();
                            if (!resultSet.next()) {
                                setLblError(Color.TOMATO, "Enter Correct Email/Password");
                                status = "Error";
                            } else {
                                status = "student";
                                Student student = Student.getInstance();
                                student.setStudentID(resultSet.getString("studentID"));
                                student.setStudentFirstName(resultSet.getString("studentFirstName"));
                                student.setStudentLastName(resultSet.getString("studentLastName"));
                                student.setStudentDOB(resultSet.getString("studentDOB"));
                                student.setStudentGender(resultSet.getString("studentGender"));
                                student.setStudentAddress(resultSet.getString("studentAddress"));
                                student.setStudentPhone(resultSet.getString("studentPhone"));
                                student.setStudentEmail(resultSet.getString("studentEmail"));
                                student.setStudentMajor(resultSet.getString("studentMajor"));
                            }
                        } catch (SQLException ex) {
                            System.err.println(ex.getMessage());
                            status = "Exception";
                        }
                    }
                    else if(resultSet.getString("userRole").equals("professor")){
                        String sql2 = "SELECT * FROM professor Where professor.userID = ?;";
                        try{
                            preparedStatement = con.prepareStatement(sql2);
                            preparedStatement.setString(1, resultSet.getString("userID"));
                            resultSet = preparedStatement.executeQuery();
                            if(!resultSet.next()){
                                setLblError(Color.TOMATO, "Enter Correct Email/Password");
                                status = "Error";
                            }
                            else{
                                status = "professor";
                                org.studentmanagement.Entity.Professor professor = org.studentmanagement.Entity.Professor.getInstance();
                                professor.setProfessorID(resultSet.getString("professorID"));
                                professor.setProfessorFirstName(resultSet.getString("professorFirstName"));
                                professor.setProfessorLastName(resultSet.getString("professorLastName"));
                                professor.setProfessorDOB(resultSet.getString("professorDOB"));
                                professor.setProfessorGender(resultSet.getString("professorGender"));
                                professor.setProfessorAddress(resultSet.getString("professorAddress"));
                                professor.setProfessorPhone(resultSet.getString("professorPhone"));
                                professor.setProfessorEmail(resultSet.getString("professorEmail"));
                                professor.setProfessorDepartment(resultSet.getString("professorDepartment"));
                            }
                        }
                        catch (SQLException ex) {
                            System.err.println(ex.getMessage());
                            status = "Exception";
                        }
                    }
                    else if(resultSet.getString("userRole").equals("admin")){
                        String sql2 = "SELECT * FROM admin Where admin.userID = ?;";
                        try{
                            preparedStatement = con.prepareStatement(sql2);
                            preparedStatement.setString(1, resultSet.getString("userID"));
                            resultSet = preparedStatement.executeQuery();
                            if(!resultSet.next()){
                                setLblError(Color.TOMATO, "Enter Correct Email/Password");
                                status = "Error";
                            }
                            else{
                                status = "admin";
                                org.studentmanagement.Entity.Admin admin = org.studentmanagement.Entity.Admin.getInstance();
                                admin.setAdminID(resultSet.getString("adminID"));
                                admin.setAdminFirstName(resultSet.getString("adminFirstName"));
                                admin.setAdminLastName(resultSet.getString("adminLastName"));
                                admin.setAdminDOB(resultSet.getString("adminDOB"));
                                admin.setAdminGender(resultSet.getString("adminGender"));
                                admin.setAdminAddress(resultSet.getString("adminAddress"));
                                admin.setAdminPhone(resultSet.getString("adminPhone"));
                                admin.setAdminEmail(resultSet.getString("adminEmail"));
                            }
                        }
                        catch (SQLException ex) {
                            System.err.println(ex.getMessage());
                            status = "Exception";
                        }
                    }
                    else{
                        setLblError(Color.TOMATO, "Enter Correct Email/Password");
                        status = "Error";
                    }

                }
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
                status = "Exception";
            }
        }
        
        return status;
    }
    
    private void setLblError(Color color, String text) {
        lblErrors.setTextFill(color);
        lblErrors.setText(text);
        System.out.println(text);
    }
}
