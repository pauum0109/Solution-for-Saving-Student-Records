package org.studentmanagement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ClassModel {
    private SimpleIntegerProperty classID;
    private SimpleStringProperty courseName;
    private SimpleStringProperty professorName;
    private SimpleStringProperty startDate;

    private SimpleStringProperty endDate;

    private SimpleIntegerProperty slots;

    private SimpleIntegerProperty availableSlots;

    public ClassModel(Integer classID, String courseName, String professorName, String startDate, String endDate, Integer slots, Integer availableSlots) {
        this.classID = new SimpleIntegerProperty(classID);
        this.courseName = new SimpleStringProperty(courseName);
        this.professorName = new SimpleStringProperty(professorName);
        this.startDate = new SimpleStringProperty(startDate);
        this.endDate = new SimpleStringProperty(endDate);
        this.slots = new SimpleIntegerProperty(slots);
        this.availableSlots = new SimpleIntegerProperty(availableSlots);
    }

    public int getClassID() {
        return classID.get();
    }

    public SimpleIntegerProperty classIDProperty() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID.set(classID);
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

    public String getProfessorName() {
        return professorName.get();
    }

    public SimpleStringProperty professorNameProperty() {
        return professorName;
    }

    public void setProfessorName(String professorName) {
        this.professorName.set(professorName);
    }

    public String getStartDate() {
        return startDate.get();
    }

    public SimpleStringProperty startDateProperty() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate.set(startDate);
    }

    public String getEndDate() {
        return endDate.get();
    }

    public SimpleStringProperty endDateProperty() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate.set(endDate);
    }

    public int getSlots() {
        return slots.get();
    }

    public SimpleIntegerProperty slotsProperty() {
        return slots;
    }

    public void setSlots(int slots) {
        this.slots.set(slots);
    }

    public int getAvailableSlots() {
        return availableSlots.get();
    }

    public SimpleIntegerProperty availableSlotsProperty() {
        return availableSlots;
    }

    public void setAvailableSlots(int availableSlots) {
        this.availableSlots.set(availableSlots);
    }
}
