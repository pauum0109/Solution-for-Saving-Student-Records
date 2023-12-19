package org.studentmanagement.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
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

}
