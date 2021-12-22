module ssu.edu.ua.traininfodms {
    requires javafx.fxml;
    requires javafx.controls;

    requires org.kordamp.bootstrapfx.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.driver.core;
    requires org.mongodb.bson;

    opens ssu.edu.ua.traininfodms to javafx.fxml;
    opens ssu.edu.ua.traininfodms.Controllers to javafx.fxml;
    opens ssu.edu.ua.traininfodms.Views to javafx.fxml;
    exports ssu.edu.ua.traininfodms;
    exports ssu.edu.ua.traininfodms.Controllers;
    exports ssu.edu.ua.traininfodms.Models;
    exports ssu.edu.ua.traininfodms.Views;
}