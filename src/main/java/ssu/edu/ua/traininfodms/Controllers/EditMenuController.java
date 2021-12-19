package ssu.edu.ua.traininfodms.Controllers;

import javafx.fxml.FXML;
import org.bson.types.ObjectId;
import ssu.edu.ua.traininfodms.Domain.AppTrainInfo;
import ssu.edu.ua.traininfodms.Domain.ITrainRepository;

public class EditMenuController {
    private AppTrainInfo trainInfoDto = null;
    private ITrainRepository _trainRepository;
    private ObjectId id;

    public void setUpController(ITrainRepository trainRepository, ObjectId id) {
        this._trainRepository = trainRepository;
        this.id = id;
    }

    @FXML
    void initialize() {
        var entity = _trainRepository.getTrainInfo(id);

    }
}
