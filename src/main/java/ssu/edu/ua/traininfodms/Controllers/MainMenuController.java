package ssu.edu.ua.traininfodms.Controllers;

import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import ssu.edu.ua.traininfodms.Domain.AppTrainInfo;
import ssu.edu.ua.traininfodms.Domain.ITrainRepository;
import ssu.edu.ua.traininfodms.Models.TrainInfoDto;
import ssu.edu.ua.traininfodms.MongoDb.MongoDbContext;
import ssu.edu.ua.traininfodms.MongoDb.MongoDbTrainRepository;

import java.util.ArrayList;

public class MainMenuController {
    private ArrayList<AppTrainInfo> list;
    private ITrainRepository _trainRepository;

    public MainMenuController() {
        MongoDbContext.Connect();
        _trainRepository = new MongoDbTrainRepository();
        list = _trainRepository.getTrainInfoList();
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
