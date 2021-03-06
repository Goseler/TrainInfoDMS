package ssu.edu.ua.traininfodms.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ssu.edu.ua.traininfodms.Controllers.AddMenuController;
import ssu.edu.ua.traininfodms.Domain.ITrainRepository;
import ssu.edu.ua.traininfodms.Main;

import java.io.IOException;

public class AddTrainTrip {
    public static void openAddTrainTripView(ITrainRepository trainRepository) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Views/add-train-trip-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 530, 190);
        AddMenuController addMenuController = fxmlLoader.getController();
        addMenuController.setTrainRepository(trainRepository);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Train Info DMS - Add menu");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initOwner(Main.primaryStage);
        stage.show();
    }
}
