package ssu.edu.ua.traininfodms.Domain;

import ssu.edu.ua.traininfodms.Domain.Shared.Seats;

import java.util.UUID;

// Domain class
public class AppTrainInfo {
    private UUID Id;
    private String Destination;
    private String TrainNumber;
    private int DeptHour;
    private Seats Seats;

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

    public Seats getSeats() {
        return Seats;
    }
    public void setSeats(Seats seats) {
        Seats = seats;
    }
}
