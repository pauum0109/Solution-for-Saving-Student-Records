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
}
