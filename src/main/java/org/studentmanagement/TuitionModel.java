package org.studentmanagement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

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

    public int getTuitionID() {
        return tuitionID.get();
    }

    public SimpleIntegerProperty tuitionIDProperty() {
        return tuitionID;
    }

    public void setTuitionID(int tuitionID) {
        this.tuitionID.set(tuitionID);
    }

    public int getTuitionAmount() {
        return tuitionAmount.get();
    }

    public SimpleIntegerProperty tuitionAmountProperty() {
        return tuitionAmount;
    }

    public void setTuitionAmount(int tuitionAmount) {
        this.tuitionAmount.set(tuitionAmount);
    }

    public String getTuitionDeadline() {
        return tuitionDeadline.get();
    }

    public SimpleStringProperty tuitionDeadlineProperty() {
        return tuitionDeadline;
    }

    public void setTuitionDeadline(String tuitionDeadline) {
        this.tuitionDeadline.set(tuitionDeadline);
    }

    public String getTuitionStatus() {
        return tuitionStatus.get();
    }

    public SimpleStringProperty tuitionStatusProperty() {
        return tuitionStatus;
    }

    public void setTuitionStatus(String tuitionStatus) {
        this.tuitionStatus.set(tuitionStatus);
    }

    public int getTuitionSemester() {
        return tuitionSemester.get();
    }

    public SimpleIntegerProperty tuitionSemesterProperty() {
        return tuitionSemester;
    }

    public void setTuitionSemester(int tuitionSemester) {
        this.tuitionSemester.set(tuitionSemester);
    }
}
