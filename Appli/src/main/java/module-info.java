module main.appli {
    requires javafx.controls;
    requires javafx.fxml;


    opens main.appli to javafx.fxml;
    exports main.appli;
}