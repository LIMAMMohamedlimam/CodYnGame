module main.appli {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.jetbrains.annotations;


    opens main.appli to javafx.fxml;
    exports main.appli;
}