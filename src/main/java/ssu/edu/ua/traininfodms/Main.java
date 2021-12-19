package ssu.edu.ua.traininfodms;

import com.mongodb.MongoException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import ssu.edu.ua.traininfodms.Controllers.MainMenuController;
import ssu.edu.ua.traininfodms.Domain.ITrainRepository;
import ssu.edu.ua.traininfodms.MongoDb.MongoDbContext;
import ssu.edu.ua.traininfodms.MongoDb.MongoDbTrainRepository;

import java.io.IOException;

public class Main extends Application {
    public static Stage primaryStage;
    private ITrainRepository _trainRepository;

    @Override
    public void init() throws Exception {
        super.init();
        MongoDbContext.Connect();
        _trainRepository = new MongoDbTrainRepository();
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.primaryStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Views/main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        MainMenuController mainMenuController = fxmlLoader.getController();
        mainMenuController.setTrainRepository(_trainRepository);
        stage.setTitle("Train Info DMS - Main menu");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        MongoDbContext.Disconnect();
    }

    public static void main(String[] args) {
        launch();
    }
}