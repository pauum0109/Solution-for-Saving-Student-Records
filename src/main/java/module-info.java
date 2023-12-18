module org.studentmanagement {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;
    requires com.calendarfx.view;

    opens org.studentmanagement to javafx.fxml;
    exports org.studentmanagement;
}