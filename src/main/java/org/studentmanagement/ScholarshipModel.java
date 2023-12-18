package org.studentmanagement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ScholarshipModel {
    private SimpleIntegerProperty scholarshipId;
    private SimpleStringProperty scholarshipName;
    private SimpleStringProperty scholarshipDescription;

    public ScholarshipModel(Integer scholarshipId, String scholarshipName, String scholarshipDescription) {
        this.scholarshipId = new SimpleIntegerProperty(scholarshipId);
        this.scholarshipName = new SimpleStringProperty(scholarshipName);
        this.scholarshipDescription = new SimpleStringProperty(scholarshipDescription);
    }

    public int getScholarshipId() {
        return scholarshipId.get();
    }

    public SimpleIntegerProperty scholarshipIdProperty() {
        return scholarshipId;
    }

    public void setScholarshipId(int scholarshipId) {
        this.scholarshipId.set(scholarshipId);
    }

    public String getScholarshipName() {
        return scholarshipName.get();
    }

    public SimpleStringProperty scholarshipNameProperty() {
        return scholarshipName;
    }

    public void setScholarshipName(String scholarshipName) {
        this.scholarshipName.set(scholarshipName);
    }

    public String getScholarshipDescription() {
        return scholarshipDescription.get();
    }

    public SimpleStringProperty scholarshipDescriptionProperty() {
        return scholarshipDescription;
    }

    public void setScholarshipDescription(String scholarshipDescription) {
        this.scholarshipDescription.set(scholarshipDescription);
    }
}
