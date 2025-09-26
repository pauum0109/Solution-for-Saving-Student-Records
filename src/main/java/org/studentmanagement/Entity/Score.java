package org.studentmanagement.Entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Score {
    private static Score instance = null;

    private int studentID;
    private String studentName;
    private int studentScore;
    private int classID;

    public static Score getInstance() {
        if (instance == null) {
            instance = new Score();
        }
        return instance;
    }

    public int getStudentID() {
        return studentID;
    }

    public int getClassID() {
        return classID;
    }

    public int getStudentScore() {
        return studentScore;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentID(Integer value) {
        this.studentID = value;
    }

    public void setStudentName(String value) {
        this.studentName = value;
    }

    public void setStudentScore(Integer value) {
        this.studentScore = value;
    }

    public void setClassID(int finalClassID) {
        this.studentID = finalClassID;
    }
}
