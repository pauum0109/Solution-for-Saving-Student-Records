package org.studentmanagement.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class TuitionModel {
    private SimpleIntegerProperty tuitionID;
    private SimpleIntegerProperty tuitionAmount;
    private SimpleStringProperty tuitionDeadline;

    private SimpleStringProperty tuitionStatus;
    private SimpleIntegerProperty tuitionSemester;

    public TuitionModel(Integer tuitionID, Integer tuitionAmount, String tuitionDeadline, String tuitionStatus, Integer tuitionSemester) {
        this.tuitionID = new SimpleIntegerProperty(tuitionID);
        this.tuitionAmount = new SimpleIntegerProperty(tuitionAmount);
        this.tuitionDeadline = new SimpleStringProperty(tuitionDeadline);
        this.tuitionStatus = new SimpleStringProperty(tuitionStatus);
        this.tuitionSemester = new SimpleIntegerProperty(tuitionSemester);
    }

    public SimpleIntegerProperty getTuitionID() {
        return tuitionID;
    }

    public SimpleIntegerProperty getTuitionAmount() {
        return tuitionAmount;
    }

    public SimpleIntegerProperty getTuitionSemester() {
        return tuitionSemester;
    }

    public SimpleStringProperty getTuitionStatus() {
        return tuitionStatus;
    }

    public SimpleStringProperty getTuitionDeadline() {
        return tuitionDeadline;
    }

}
