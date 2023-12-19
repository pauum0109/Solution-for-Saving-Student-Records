package org.studentmanagement.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import org.studentmanagement.Entity.Admin;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminInfoController implements Initializable {

    @FXML
    private Label adminAddress;

    @FXML
    private Label adminDOB;

    @FXML
    private Label adminEmail;

    @FXML
    private Label adminFirstName;

    @FXML
    private Label adminGender;

    @FXML
    private Label adminID;

    @FXML
    private Label adminLastName;

    @FXML
    private Label adminPhone;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Admin admin = Admin.getInstance();
        adminID.setText(admin.getAdminID());
        adminFirstName.setText(admin.getAdminFirstName());
        adminLastName.setText(admin.getAdminLastName());
        adminDOB.setText(admin.getAdminDOB());
        adminGender.setText(admin.getAdminGender());
        adminAddress.setText(admin.getAdminAddress());
        adminPhone.setText(admin.getAdminPhone());
        adminEmail.setText(admin.getAdminEmail());
    }
}
