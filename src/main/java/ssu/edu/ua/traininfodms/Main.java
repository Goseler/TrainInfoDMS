package ssu.edu.ua.traininfodms;

import com.mongodb.MongoException;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import ssu.edu.ua.traininfodms.MongoDb.MongoDbContext;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Views/main-menu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 400);
        stage.setTitle("Train Info DMS");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
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