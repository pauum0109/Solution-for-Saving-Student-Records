package org.studentmanagement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CoursesModel {
    private SimpleIntegerProperty courseID;
    private SimpleStringProperty courseName;
    private SimpleStringProperty courseDescription;
    private SimpleStringProperty courseCredit;

    private SimpleStringProperty courseDay;

    private SimpleStringProperty courseTime;

    private SimpleStringProperty courseRoom;

    public CoursesModel(Integer courseId, String courseName, String courseDescription, String courseCredits, String courseDay, String courseTime, String courseRoom) {
        this.courseID = new SimpleIntegerProperty(courseId);
        this.courseName = new SimpleStringProperty(courseName);
        this.courseDescription = new SimpleStringProperty(courseDescription);
        this.courseCredit = new SimpleStringProperty(courseCredits);
        this.courseDay = new SimpleStringProperty(courseDay);
        this.courseTime = new SimpleStringProperty(courseTime);
        this.courseRoom = new SimpleStringProperty(courseRoom);
    }


    public int getCourseID() {
        return courseID.get();
    }

    public SimpleIntegerProperty courseIDProperty() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID.set(courseID);
    }

    public String getCourseName() {
        return courseName.get();
    }

    public SimpleStringProperty courseNameProperty() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName.set(courseName);
    }

    public String getCourseDescription() {
        return courseDescription.get();
    }

    public SimpleStringProperty courseDescriptionProperty() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription.set(courseDescription);
    }

    public String getCourseCredit() {
        return courseCredit.get();
    }

    public SimpleStringProperty courseCreditProperty() {
        return courseCredit;
    }

    public void setCourseCredit(String courseCredit) {
        this.courseCredit.set(courseCredit);
    }

    public String getCourseDay() {
        return courseDay.get();
    }

    public SimpleStringProperty courseDayProperty() {
        return courseDay;
    }

    public void setCourseDay(String courseDay) {
        this.courseDay.set(courseDay);
    }

    public String getCourseTime() {
        return courseTime.get();
    }

    public SimpleStringProperty courseTimeProperty() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime.set(courseTime);
    }

    public String getCourseRoom() {
        return courseRoom.get();
    }

    public SimpleStringProperty courseRoomProperty() {
        return courseRoom;
    }

    public void setCourseRoom(String courseRoom) {
        this.courseRoom.set(courseRoom);
    }
}
