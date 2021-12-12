package ssu.edu.ua.traininfodms.Domain;

import org.bson.BsonType;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.codecs.pojo.annotations.BsonRepresentation;
import org.bson.types.ObjectId;
import ssu.edu.ua.traininfodms.Domain.Shared.Seats;

// Domain class
public class AppTrainInfo {
    @BsonId()
    @BsonRepresentation(BsonType.OBJECT_ID)
    private ObjectId id;
    private String destination;
    private String trainNumber;
    private int deptHour;
    private Seats seats;

    public AppTrainInfo() {
    }

    public AppTrainInfo(String destination, String trainNumber, int deptHour, Seats seats) {
        this.destination = destination;
        this.trainNumber = trainNumber;
        this.deptHour = deptHour;
        this.seats = seats;
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

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }
}
