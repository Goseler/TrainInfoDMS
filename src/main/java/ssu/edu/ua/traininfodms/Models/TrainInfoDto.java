package ssu.edu.ua.traininfodms.Models;

import ssu.edu.ua.traininfodms.Domain.Shared.Seats;

import java.util.UUID;

public class TrainInfoDto {
    private UUID Id;
    private String Destination;
    private String TrainNumber;
    private int DeptHour;
    private SeatsDto Seats;

    public TrainInfoDto(){}

    public TrainInfoDto (UUID id, String destination, String trainNumber, int deptHour, SeatsDto seatsDto){
        Id = id;
        Destination = destination;
        TrainNumber = trainNumber;
        DeptHour = deptHour;
        Seats = seatsDto;
    }

    // Getters and Setters
    public UUID getId() {
        return Id;
    }
    public void setId(UUID id) {
        Id = id;
    }

    public String getDestination() {
        return Destination;
    }
    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getTrainNumber() {
        return TrainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        TrainNumber = trainNumber;
    }

    public int getDeptHour() {
        return DeptHour;
    }
    public void setDeptHour(int deptHour) {
        DeptHour = deptHour;
    }

    public SeatsDto getSeats() {
        return Seats;
    }
    public void setSeats(Seats seats) {
        Seats = new SeatsDto(seats);
    }
}