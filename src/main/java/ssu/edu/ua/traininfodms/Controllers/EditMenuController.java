package ssu.edu.ua.traininfodms.Controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.bson.types.ObjectId;
import ssu.edu.ua.traininfodms.Domain.AppTrainInfo;
import ssu.edu.ua.traininfodms.Domain.ITrainRepository;
import ssu.edu.ua.traininfodms.Domain.Shared.Seats;

public class EditMenuController {
    public TextField destTextField;
    public TextField trainNumberTextField;
    public TextField deptHourTextField;
    public TextField firstClassTextField;
    public TextField secondClassTextField;
    public TextField thirdClassTextField;
    public Button cancelButton;
    public Button addButton;
    private AppTrainInfo trainInfo = null;
    private ITrainRepository _trainRepository;
    private ObjectId id;

    public void setUpController(ITrainRepository trainRepository, ObjectId id) {
        this._trainRepository = trainRepository;
        this.id = id;
    }

    @FXML
    void initialize() {
        Platform.runLater(()->{
            trainInfo = _trainRepository.getTrainInfo(id);
            destTextField.setText(trainInfo.getDestination());
            trainNumberTextField.setText(trainInfo.getTrainNumber());
            deptHourTextField.setText(String.valueOf(trainInfo.getDeptHour()));
            Seats seats = trainInfo.getSeats();
            firstClassTextField.setText(String.valueOf(seats.getFirstClass()));
            secondClassTextField.setText(String.valueOf(seats.getSecondClass()));
            thirdClassTextField.setText(String.valueOf(seats.getThirdClass()));
        });

    }

    public void onDestinationTextFieldChanged(KeyEvent keyEvent) {
        trainInfo.setDestination(destTextField.getText());
    }

    public void onTrainNumberTextFieldChanged(KeyEvent keyEvent) {
        trainInfo.setTrainNumber(trainNumberTextField.getText());
    }

    public void setTrainRepository(ITrainRepository trainRepository) {
        this._trainRepository = trainRepository;
    }

    public void onDeptHourTextFieldChanged(KeyEvent keyEvent) {
        trainInfo.setDeptHour(Integer.parseInt(deptHourTextField.getText()));
    }

    public void onFirstClassTextFieldChanged(KeyEvent keyEvent) {
        Seats seats = trainInfo.getSeats();
        seats = seats != null ? seats : new Seats();
        seats.setFirstClass(Integer.parseInt(firstClassTextField.getText()));
        trainInfo.setSeats(seats);
    }

    public void onSecondClassTextFieldChanged(KeyEvent keyEvent) {
        Seats seats = trainInfo.getSeats();
        seats = seats != null ? seats : new Seats();
        seats.setSecondClass(Integer.parseInt(secondClassTextField.getText()));
        trainInfo.setSeats(seats);
    }

    public void onThirdClassTextFieldChanged(KeyEvent keyEvent) {
        Seats seats = trainInfo.getSeats();
        seats = seats != null ? seats : new Seats();
        seats.setThirdClass(Integer.parseInt(thirdClassTextField.getText()));
        trainInfo.setSeats(seats);
    }

    public void onCancelButtonClicked(MouseEvent mouseEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void onAddButtonClicked(MouseEvent mouseEvent) {
        _trainRepository.updateTrainInfo(trainInfo);

        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
