package org.studentmanagement.Model;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentScoreModel {
    private SimpleIntegerProperty studentID;
    private SimpleStringProperty studentName;
    private SimpleIntegerProperty studentScore;

    public StudentScoreModel(Integer studentID, String studentName, Integer studentScore) {
        this.studentID = new SimpleIntegerProperty(studentID);
        this.studentName = new SimpleStringProperty(studentName);
        this.studentScore = new SimpleIntegerProperty(studentScore);
    }
}
