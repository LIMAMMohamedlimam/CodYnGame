module main.appli {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens main.appli to javafx.fxml;
    exports main.appli;
}