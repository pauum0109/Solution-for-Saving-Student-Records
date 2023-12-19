package org.studentmanagement.Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import org.studentmanagement.Utils.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminAddStudentController implements Initializable {

    @FXML
    private Button btnSave;

    @FXML
    private TableView tblData;

    @FXML
    private DatePicker txtDOB;

    @FXML
    private TextField txtMajor;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtFirstname;

    @FXML
    private ComboBox<String> txtGender;

    @FXML
    private TextField txtLastname;

    Connection con;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private void ClearField(){
        txtFirstname.clear();
        txtLastname.clear();
        txtGender.setValue(null);
        txtDOB.setValue(null);
        txtEmail.clear();
        txtMajor.clear();
    }

    public AdminAddStudentController(){
        con = ConnectionUtil.conDB();
    }

    private int getMaxStudentId(){
        String sql = "SELECT MAX(studentID) FROM student";
        try{
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
            else{
                return 0;
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private int getMaxUserId(){
        String sql = "SELECT MAX(userID) FROM user";
        try{
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getInt(1);
            }
            else{
                return 0;
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void insertStudentRecord(){
        int id = getMaxStudentId() + 1;
        String sql = "INSERT INTO student (studentID, studentFirstname, studentLastname, studentGender, studentDOB, studentEmail, studentMajor) VALUES (?,?,?,?,?,?,?)";
        try{
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, txtFirstname.getText());
            preparedStatement.setString(3, txtLastname.getText());
            preparedStatement.setString(4, txtGender.getValue());
            preparedStatement.setString(5, txtDOB.getValue().toString());
            preparedStatement.setString(6, txtEmail.getText());
            preparedStatement.setString(7, txtMajor.getText());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    private void insertUserRecord(){
        int id = getMaxUserId() + 1;
        String sql = "INSERT INTO user (userID, username, password, role) VALUES (?,?,?,?)";
        try{
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, txtEmail.getText());
            preparedStatement.setString(3, "123456");
            preparedStatement.setString(4, "student");
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleAddButton(ActionEvent event) {
        if(event.getSource() == btnSave){
            insertStudentRecord();
            insertUserRecord();
            fetRowList();
            ClearField();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtGender.setItems(genderList);
        fetColumnList();
        fetRowList();
    }

    private void fetColumnList()
    {
        String sql = "SELECT * FROM student";
        try {
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;
                TableColumn col = new TableColumn(resultSet.getMetaData().getColumnName(i + 1).toUpperCase());

                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                tblData.getColumns().removeAll(col);
                tblData.getColumns().addAll(col);

            }
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    private void fetRowList() {
        studentData = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * FROM student";
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //Iterate Row
                ObservableList<Object> row = FXCollections.observableArrayList();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(resultSet.getString(i));
                }
                studentData.add(row);

            }

            tblData.setItems(studentData);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    private final ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
    private ObservableList<ObservableList> studentData;

}
