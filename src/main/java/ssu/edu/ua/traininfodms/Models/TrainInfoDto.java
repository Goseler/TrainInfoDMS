package ssu.edu.ua.traininfodms.Models;

import org.bson.types.ObjectId;
import ssu.edu.ua.traininfodms.Domain.Shared.Seats;

public class TrainInfoDto {
    private ObjectId id;
    private String destination;
    private String trainNumber;
    private int deptHour;
    private SeatsDto seats;

    public TrainInfoDto(){}

    public TrainInfoDto (ObjectId id, String destination, String trainNumber, int deptHour, SeatsDto seatsDto){
        this.id = id;
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.deptHour = deptHour;
        seats = seatsDto;
    }

    // Getters and Setters
    public ObjectId getId() {
        return id;
    }
    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getTrainNumber() {
        return trainNumber;
    }
    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public int getDeptHour() {
        return deptHour;
    }
    public void setDeptHour(int deptHour) {
        this.deptHour = deptHour;
    }

    public SeatsDto getSeats() {
        return seats;
    }
    public void setSeats(Seats seats) {
        this.seats = new SeatsDto(seats);
    }
}
