package ssu.edu.ua.traininfodms.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ssu.edu.ua.traininfodms.Main;

import java.io.IOException;

public class AddTrainTrip {
    public static void openAddTrainTripView() throws IOException {
        Stage stage = new Stage();

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Views/add-train-trip-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320*3, 240*3);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
