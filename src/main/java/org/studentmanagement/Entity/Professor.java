package org.studentmanagement.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Professor {
    private static Professor instance = null;

    private String professorID;
    private String professorFirstName;
    private String professorLastName;
    private String professorDOB;
    private String professorGender;
    private String professorAddress;
    private String professorPhone;
    private String professorEmail;
    private String professorDepartment;

    public static Professor getInstance() {
        if (instance == null) {
            instance = new Professor();
        }
        return instance;
    }
}
