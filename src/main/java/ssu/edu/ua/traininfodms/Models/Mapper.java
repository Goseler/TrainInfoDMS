package ssu.edu.ua.traininfodms.Models;

import ssu.edu.ua.traininfodms.Domain.AppTrainInfo;

public class Mapper {
    public static TrainInfoDto MapToTrainInfoDto(AppTrainInfo appTrain){
        var trainDto = new TrainInfoDto();

        trainDto.setId(appTrain.getId());
        trainDto.setDestination(appTrain.getDestination());
        trainDto.setTrainNumber(appTrain.getTrainNumber());
        trainDto.setDeptHour(appTrain.getDeptHour());
        trainDto.setSeats(appTrain.getSeats());

        return trainDto;
    }
}
