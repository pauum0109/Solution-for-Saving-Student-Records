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

public class AdminRemoveCourseController implements Initializable {

    @FXML
    private Button btnRemove;

    @FXML
    private TableView tblData;

    @FXML
    private TextField txtCourseID;

    Connection con;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public AdminRemoveCourseController(){
        con = ConnectionUtil.conDB();
    }

    private void ClearField(){
        txtCourseID.clear();
    }

    private void removeCourse(){
        String sql = "DELETE FROM course WHERE courseID = ?";
        try{
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, txtCourseID.getText());
            preparedStatement.executeUpdate();
            fetRowList();
            ClearField();
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleAddButton(ActionEvent event) {
        if(event.getSource() == btnRemove){
            removeCourse();

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
    private ObservableList<ObservableList> courseData;

}
