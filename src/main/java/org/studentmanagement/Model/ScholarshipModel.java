package org.studentmanagement.Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ScholarshipModel {
    private SimpleIntegerProperty scholarshipId;
    private SimpleStringProperty scholarshipName;
    private SimpleStringProperty scholarshipDescription;

    public ScholarshipModel(Integer scholarshipId, String scholarshipName, String scholarshipDescription) {
        this.scholarshipId = new SimpleIntegerProperty(scholarshipId);
        this.scholarshipName = new SimpleStringProperty(scholarshipName);
        this.scholarshipDescription = new SimpleStringProperty(scholarshipDescription);
    }

}
