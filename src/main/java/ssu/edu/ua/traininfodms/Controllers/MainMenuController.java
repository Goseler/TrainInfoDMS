package ssu.edu.ua.traininfodms.Controllers;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.bson.types.ObjectId;
import ssu.edu.ua.traininfodms.Domain.AppTrainInfo;
import ssu.edu.ua.traininfodms.Domain.ITrainRepository;
import ssu.edu.ua.traininfodms.Models.Mapper;
import ssu.edu.ua.traininfodms.Models.SearchRequestDto;
import ssu.edu.ua.traininfodms.Models.TrainInfoDto;
import ssu.edu.ua.traininfodms.Views.AddTrainTrip;
import ssu.edu.ua.traininfodms.Views.EditTrainTrip;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MainMenuController {
    private ArrayList<AppTrainInfo> list;
    private List<TrainInfoDto> listDto;
    private ITrainRepository _trainRepository;
    private final Alert warningAlert = new Alert(Alert.AlertType.WARNING);
    private final Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION);
    private SearchRequestDto searchRequestDto = new SearchRequestDto();

    @FXML
    private TableView<TrainInfoDto> generalTableView;
    @FXML
    private TableColumn<TrainInfoDto, ObjectId> idCol;
    @FXML
    private TableColumn<TrainInfoDto, String> destCol;
    @FXML
    private TableColumn<TrainInfoDto, String> deptHourCol;
    @FXML
    private TableColumn<TrainInfoDto, String> trainNumberCol;
    @FXML
    private TableColumn<TrainInfoDto, Number> allCol;
    @FXML
    private TableColumn<TrainInfoDto, Number> firstClassCol;
    @FXML
    private TableColumn<TrainInfoDto, Number> secondClassCol;
    @FXML
    private TableColumn<TrainInfoDto, Number> thirdClassCol;

    @FXML
    private CheckBox seatsCheckBox;
    @FXML
    private Slider hourSlider;
    @FXML
    private TextField destTextField;

    public MainMenuController() {
    }

    @FXML
    void initialize() {
        idCol.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );
        destCol.setCellValueFactory(
                new PropertyValueFactory<>("destination")
        );
        deptHourCol.setCellValueFactory(
                new PropertyValueFactory<>("deptHour")
        );
        trainNumberCol.setCellValueFactory(
                new PropertyValueFactory<>("trainNumber")
        );
        allCol.setCellValueFactory(
                cellValue -> new SimpleIntegerProperty(cellValue.getValue().getSeats().getAll())
        );
        firstClassCol.setCellValueFactory(
                cellValue -> new SimpleIntegerProperty(cellValue.getValue().getSeats().getFirstClass())
        );
        secondClassCol.setCellValueFactory(
                cellValue -> new SimpleIntegerProperty(cellValue.getValue().getSeats().getSecondClass())
        );
        thirdClassCol.setCellValueFactory(
                cellValue -> new SimpleIntegerProperty(cellValue.getValue().getSeats().getThirdClass())
        );
        seatsCheckBox.setSelected(true);

        Platform.runLater(this::refreshTableViewData);
    }

    // Event actions
    public void onEditTrainButtonClicked(MouseEvent mouseEvent) {
        TrainInfoDto dto = generalTableView.getSelectionModel().getSelectedItem();
        if (dto == null) {
            warningAlert.contentTextProperty().setValue("Please, choose row to edit");
            warningAlert.show();
            return;
        }

        try {
            EditTrainTrip.openAddTrainTripView(_trainRepository, dto.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onAddTrainButtonClicked(MouseEvent mouseEvent) throws IOException {
        try {
            AddTrainTrip.openAddTrainTripView(_trainRepository);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDeleteTrainButtonClicked(MouseEvent mouseEvent) {
        TrainInfoDto dto = generalTableView.getSelectionModel().getSelectedItem();
        if (dto == null) {
            warningAlert.contentTextProperty().setValue("Please, choose row to delete");
            warningAlert.show();
            return;
        }

        if (deleteConfirmation(dto.getId())) {
            _trainRepository.deleteTrainInfo(dto.getId());
        }

        refreshTableViewData();
    }

    public void onGeneralSeatsStatusChanged(MouseEvent inputMethodEvent) {
        searchRequestDto.setGeneralSeats(seatsCheckBox.isSelected());
        refreshTableViewData();
    }

    public void onDestinationInputTextChanged(KeyEvent inputMethodEvent) {
        searchRequestDto.setDestination(destTextField.getText());
        refreshTableViewData();
    }

    public void onHoursSliderValueChanged(MouseEvent inputMethodEvent) {
        searchRequestDto.setDeptHour((int) hourSlider.getValue());
        refreshTableViewData();
    }

    public void refreshTableViewData() {
        list = _trainRepository.getTrainInfoList(searchRequestDto);
        listDto = Mapper.MapToTrainInfoDtoList(list);
        generalTableView.getItems().clear();
        generalTableView.setItems(FXCollections.observableList(listDto));
    }

    private TrainInfoDto getSelectedItem(String warningMessage) {
        TrainInfoDto dto = generalTableView.getSelectionModel().getSelectedItem();
        if (dto == null) {
            warningAlert.contentTextProperty().setValue(warningMessage);
            warningAlert.show();
        }
        return dto;
    }

    private boolean deleteConfirmation(ObjectId id) {
        confirmAlert.contentTextProperty().setValue("Are you sure to delete object with id:" + id.toString() + "?");
        Optional<ButtonType> option = confirmAlert.showAndWait();

        if (option.get() == ButtonType.OK) {
            return true;
        }
        return false;
    }

    public void setTrainRepository(ITrainRepository trainRepository) {
        this._trainRepository = trainRepository;
    }

    public void onRefreshButtonClicked(MouseEvent keyEvent) {
        refreshTableViewData();
    }
}
