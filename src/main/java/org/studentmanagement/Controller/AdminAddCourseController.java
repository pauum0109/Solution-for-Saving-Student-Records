package org.studentmanagement.Controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import org.studentmanagement.Utils.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminAddCourseController implements Initializable {

    @FXML
    private Button btnSave;

    @FXML
    private TableView tblData;

    @FXML
    private TextField txtCourseCredit;

    @FXML
    private TextField txtCourseDay;

    @FXML
    private TextField txtCourseDescription;

    @FXML
    private TextField txtCourseName;

    @FXML
    private TextField txtCourseRoom;

    @FXML
    private TextField txtCourseTime;

    Connection con;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private void ClearField(){
        txtCourseName.clear();
        txtCourseDescription.clear();
        txtCourseCredit.clear();
        txtCourseDay.clear();
        txtCourseTime.clear();
        txtCourseRoom.clear();
    }

    public AdminAddCourseController(){
        con = ConnectionUtil.conDB();
    }

    private int getMaxCourseId(){
        String sql = "SELECT MAX(courseID) FROM course";
        int max = 0;
        try{
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                max = resultSet.getInt(1);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return max;
    }

    private void insertCourse(){
        int max = getMaxCourseId()+1;
        String sql = "INSERT INTO course (courseID, courseName, courseDescription, courseCredit, courseDay, courseTime, courseRoom) VALUES (?,?,?,?,?,?,?)";
        try {
            preparedStatement = con.prepareStatement(sql);

            preparedStatement.setInt(1, max);
            preparedStatement.setString(2, txtCourseName.getText());
            preparedStatement.setString(3, txtCourseDescription.getText());
            preparedStatement.setString(4, txtCourseCredit.getText());
            preparedStatement.setString(5, txtCourseDay.getText());
            preparedStatement.setString(6, txtCourseTime.getText());
            preparedStatement.setString(7, txtCourseRoom.getText());
            preparedStatement.execute();

        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleAddButton(ActionEvent event) {
        if(event.getSource()== btnSave){
            insertCourse();
            ClearField();
            fetRowList();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fetColumnList();
        fetRowList();
    }

    private void fetColumnList()
    {
        String sql = "SELECT * FROM course";
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
        courseData = FXCollections.observableArrayList();
        ResultSet rs;
        try {
            String sql = "SELECT * FROM course";
            preparedStatement = con.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                //Iterate Row
                ObservableList<Object> row = FXCollections.observableArrayList();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(resultSet.getString(i));
                }
                courseData.add(row);

            }

            tblData.setItems(courseData);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    private final ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");
    private ObservableList<ObservableList> courseData;
}
