package ssu.edu.ua.traininfodms.Controllers;

import javafx.collections.FXCollections;
import javafx.scene.control.TableView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import ssu.edu.ua.traininfodms.Domain.Shared.Seats;
import ssu.edu.ua.traininfodms.Models.SeatsDto;
import ssu.edu.ua.traininfodms.Models.TrainInfoDto;
import ssu.edu.ua.traininfodms.Views.AddTrainTrip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainMenuController {
    private ArrayList<TrainInfoDto> list = new ArrayList<>();

    public MainMenuController() {
        list.add(new TrainInfoDto(UUID.randomUUID(), "Sumy", "L-256", 15, new SeatsDto(new Seats(5, 7, 9))));
        FXCollections.observableArrayList(list);
    }

    // Event actions
    public void onEditTrainButtonClicked(MouseEvent mouseEvent) {
    }

    public void onAddTrainButtonClicked(MouseEvent mouseEvent) {
    }

    public void onDeleteTrainButtonClicked(MouseEvent mouseEvent) {
    }

    public void onGeneralSeatsStatusChanged(InputMethodEvent inputMethodEvent) {
    }

    public void onDestinationInputTextChanged(InputMethodEvent inputMethodEvent) {
    }

    public void onHoursSliderValueChanged(InputMethodEvent inputMethodEvent) {
    }
}
