module ssu.edu.ua.traininfodms {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens ssu.edu.ua.traininfodms to javafx.fxml;
    exports ssu.edu.ua.traininfodms;
    exports ssu.edu.ua.traininfodms.controller;
}