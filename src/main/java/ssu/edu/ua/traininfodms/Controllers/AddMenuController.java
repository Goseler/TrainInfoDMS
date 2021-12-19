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
    }

    public void onFirstClassTextFieldChanged(KeyEvent keyEvent) {
    }

    public void onSecondClassTextFieldChanged(KeyEvent keyEvent) {
    }

    public void onThirdClassTextFieldChanged(KeyEvent keyEvent) {
    }
}
