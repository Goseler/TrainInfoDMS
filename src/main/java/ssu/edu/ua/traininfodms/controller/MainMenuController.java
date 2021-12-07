package ssu.edu.ua.traininfodms.controller;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import ssu.edu.ua.traininfodms.view.AddTrainTrip;

import java.io.IOException;

public class MainMenuController {
    public void onMouseClicked(MouseEvent mouseEvent) {

    }

    public void onNewTrainTripClicked(MouseEvent mouseEvent) {
        try {
            AddTrainTrip.openAddTrainTripView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
