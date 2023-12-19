package org.studentmanagement.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CourseModel {
    private SimpleIntegerProperty courseID;
    private SimpleStringProperty courseName;
    private SimpleStringProperty courseDescription;
    private SimpleStringProperty courseCredit;

    private SimpleStringProperty courseDay;

    private SimpleStringProperty courseTime;

    private SimpleStringProperty courseRoom;

    public CourseModel(Integer courseId, String courseName, String courseDescription, String courseCredits, String courseDay, String courseTime, String courseRoom) {
        this.courseID = new SimpleIntegerProperty(courseId);
        this.courseName = new SimpleStringProperty(courseName);
        this.courseDescription = new SimpleStringProperty(courseDescription);
        this.courseCredit = new SimpleStringProperty(courseCredits);
        this.courseDay = new SimpleStringProperty(courseDay);
        this.courseTime = new SimpleStringProperty(courseTime);
        this.courseRoom = new SimpleStringProperty(courseRoom);
    }


}
