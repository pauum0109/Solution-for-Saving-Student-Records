package org.studentmanagement.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.studentmanagement.Entity.Score;
import org.studentmanagement.Utils.ConnectionUtil;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class EditScoreController implements Initializable {

    @FXML
    private Button btn_save;

    @FXML
    private Label studentID;

    @FXML
    private Label studentName;

    @FXML
    private TextField studentScore;

    Connection con;
    PreparedStatement preparedStatement = null;

    public EditScoreController(){
        con = ConnectionUtil.conDB();
    }

    private void updateScore(int new_score){
        Score score = Score.getInstance();
        int student_id = score.getStudentID();
        int class_id = score.getClassID();
        String sql = "UPDATE enrollment SET score = ? WHERE studentID = ? AND classID = ?";
        try{
            preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, new_score);
            preparedStatement.setInt(2, student_id);
            preparedStatement.setInt(3, class_id);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void handleBtnSave(ActionEvent event) {
        if(event.getSource() == btn_save){
            int new_score = Integer.parseInt(studentScore.getText());
            Score score = Score.getInstance();
            if(new_score != score.getStudentScore()){
                updateScore(new_score);
                Stage stage = (Stage) btn_save.getScene().getWindow();
                stage.close();
            }
        }
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Score score = Score.getInstance();
        studentID.setText(String.valueOf(score.getStudentID()));
        studentName.setText(score.getStudentName());
        studentScore.setText(String.valueOf(score.getStudentScore()));

    }
}
