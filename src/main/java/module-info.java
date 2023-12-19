module org.studentmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires com.calendarfx.view;
    requires static lombok;
    requires de.jensd.fx.glyphs.fontawesome;


    exports org.studentmanagement.Model;
    opens org.studentmanagement.Model to javafx.fxml;
    exports org.studentmanagement.Controller;
    opens org.studentmanagement.Controller to javafx.fxml;
    exports org.studentmanagement;
    opens org.studentmanagement to javafx.fxml;
}