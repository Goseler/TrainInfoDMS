package ssu.edu.ua.traininfodms.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.bson.types.ObjectId;
import ssu.edu.ua.traininfodms.Controllers.EditMenuController;
import ssu.edu.ua.traininfodms.Domain.ITrainRepository;
import ssu.edu.ua.traininfodms.Main;

import java.io.IOException;

public class EditTrainTrip {
    public static void openAddTrainTripView(ITrainRepository trainRepository, ObjectId id) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Views/edit-train-trip-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 530, 190);
        fxmlLoader.<EditMenuController>getController().setUpController(trainRepository, id);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Train Info DMS - Edit menu");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initOwner(Main.primaryStage);
        stage.show();
    }
}
