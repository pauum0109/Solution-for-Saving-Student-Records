package org.studentmanagement.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Student {
    private static Student instance = null;

    private String studentID;
    private String studentFirstName;
    private String studentLastName;
    private String studentDOB;
    private String studentGender;
    private String studentAddress;
    private String studentPhone;
    private String studentEmail;
    private String studentMajor;

    public static Student getInstance() {
        if (instance == null) {
            instance = new Student();
        }
        return instance;
    }

}
