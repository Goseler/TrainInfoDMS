package ssu.edu.ua.traininfodms.Controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ssu.edu.ua.traininfodms.Domain.AppTrainInfo;
import ssu.edu.ua.traininfodms.Domain.ITrainRepository;
import ssu.edu.ua.traininfodms.Domain.Shared.Seats;

public class AddMenuController {
    public TextField deptHourTextField;
    public TextField firstClassTextField;
    public TextField secondClassTextField;
    public TextField thirdClassTextField;
    private AppTrainInfo appTrainInfo = new AppTrainInfo();
    private ITrainRepository _trainRepository;

    public TextField destTextField;
    public TextField trainNumberTextField;
    public Button cancelButton;
    public Button addButton;

    public void onCancelButtonClicked(MouseEvent mouseEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void onAddButtonClicked(MouseEvent mouseEvent) {
        _trainRepository.insertTrainInfo(appTrainInfo);

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void onDestinationTextFieldChanged(KeyEvent keyEvent) {
        appTrainInfo.setDestination(destTextField.getText());
    }

    public void onTrainNumberTextFieldChanged(KeyEvent keyEvent) {
        appTrainInfo.setTrainNumber(trainNumberTextField.getText());
    }

    public void setTrainRepository(ITrainRepository trainRepository) {
        this._trainRepository = trainRepository;
    }

    public void onDeptHourTextFieldChanged(KeyEvent keyEvent) {
        appTrainInfo.setDeptHour(Integer.parseInt(deptHourTextField.getText()));
    }

    public void onFirstClassTextFieldChanged(KeyEvent keyEvent) {
        Seats seats = appTrainInfo.getSeats();
        seats = seats != null ? seats : new Seats();
        seats.setFirstClass(Integer.parseInt(firstClassTextField.getText()));
        appTrainInfo.setSeats(seats);
    }

    public void onSecondClassTextFieldChanged(KeyEvent keyEvent) {
        Seats seats = appTrainInfo.getSeats();
        seats = seats != null ? seats : new Seats();
        seats.setSecondClass(Integer.parseInt(secondClassTextField.getText()));
        appTrainInfo.setSeats(seats);
    }

    public void onThirdClassTextFieldChanged(KeyEvent keyEvent) {
        Seats seats = appTrainInfo.getSeats();
        seats = seats != null ? seats : new Seats();
        seats.setThirdClass(Integer.parseInt(thirdClassTextField.getText()));
        appTrainInfo.setSeats(seats);
    }
}
