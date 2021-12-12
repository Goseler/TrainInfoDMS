package ssu.edu.ua.traininfodms.Models;

import org.bson.Document;
import org.bson.types.ObjectId;
import ssu.edu.ua.traininfodms.Domain.AppTrainInfo;
import ssu.edu.ua.traininfodms.Domain.Shared.Seats;

public class Mapper {
    public static TrainInfoDto MapToTrainInfoDto(AppTrainInfo appTrain){
        TrainInfoDto trainDto = new TrainInfoDto();

        trainDto.setId(appTrain.getId());
        trainDto.setDestination(appTrain.getDestination());
        trainDto.setTrainNumber(appTrain.getTrainNumber());
        trainDto.setDeptHour(appTrain.getDeptHour());
        trainDto.setSeats(appTrain.getSeats());

        return trainDto;
    }

    public static Document MapToDocument(AppTrainInfo appTrain){

        return new Document(DocumentKeys.id, new ObjectId())
                .append(DocumentKeys.destination, appTrain.getDestination())
                .append(DocumentKeys.trainNumber, appTrain.getTrainNumber())
                .append(DocumentKeys.deptHour, appTrain.getDeptHour())
                .append(DocumentKeys.seats, new Document()
                        .append(DocumentKeys.SeatsKeys.firstClass, appTrain.getSeats().getFirstClass())
                        .append(DocumentKeys.SeatsKeys.secondClass, appTrain.getSeats().getSecondClass())
                        .append(DocumentKeys.SeatsKeys.thirdClass, appTrain.getSeats().getThirdClass()));
    }

    public static AppTrainInfo MapToAppTrainInfo(Document document){
        AppTrainInfo appTrainInfo = new AppTrainInfo();

        appTrainInfo.setId((ObjectId) document.get(DocumentKeys.id));
        appTrainInfo.setDestination((String) document.get(DocumentKeys.destination));
        appTrainInfo.setTrainNumber((String) document.get(DocumentKeys.trainNumber));
        appTrainInfo.setDeptHour((int) document.get(DocumentKeys.deptHour));

        Document seatsDocument = (Document) document.get(DocumentKeys.seats);
        appTrainInfo.setSeats(new Seats(
                (int) seatsDocument.get(DocumentKeys.SeatsKeys.firstClass),
                (int) seatsDocument.get(DocumentKeys.SeatsKeys.secondClass),
                (int) seatsDocument.get(DocumentKeys.SeatsKeys.thirdClass)
        ));

        return appTrainInfo;
    }
}
