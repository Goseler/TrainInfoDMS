package ssu.edu.ua.traininfodms.Models;

public class SearchRequestDto {
    private String destination = "";
    private int deptHour = 0;
    private boolean generalSeats = true;

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Number getDeptHour() {
        return deptHour;
    }

    public void setDeptHour(int deptHour) {
        this.deptHour = deptHour;
    }

    public boolean isGeneralSeats() {
        return generalSeats;
    }

    public void setGeneralSeats(boolean generalSeats) {
        this.generalSeats = generalSeats;
    }
}
