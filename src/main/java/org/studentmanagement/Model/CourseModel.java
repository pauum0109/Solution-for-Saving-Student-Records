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

    public SimpleIntegerProperty getCourseID() {
        return courseID;
    }

    public SimpleStringProperty getCourseName() {
        return courseName;
    }

    public SimpleStringProperty getCourseDescription() {
        return courseDescription;
    }

    public SimpleStringProperty getCourseCredit() {
        return courseCredit;
    }

    public SimpleStringProperty getCourseDay() {
        return courseDay;
    }

    public SimpleStringProperty getCourseTime() {
        return courseTime;
    }

    public SimpleStringProperty getCourseRoom() {
        return courseRoom;
    }


}
