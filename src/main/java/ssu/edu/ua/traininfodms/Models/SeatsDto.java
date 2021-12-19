package ssu.edu.ua.traininfodms.Models;

import ssu.edu.ua.traininfodms.Domain.Shared.Seats;

public class SeatsDto {
    public SeatsDto(Seats seats) {
        firstClass = seats.getFirstClass();
        secondClass = seats.getSecondClass();
        thirdClass = seats.getThirdClass();

        all = firstClass + secondClass + thirdClass;
    }

    private int all;
    private int firstClass;
    private int secondClass;
    private int thirdClass;

    public int getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(int firstClass) {
        this.firstClass = firstClass;
    }

    public int getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(int secondClass) {
        this.secondClass = secondClass;
    }

    public int getThirdClass() {
        return thirdClass;
    }

    public void setThirdClass(int thirdClass) {
        this.thirdClass = thirdClass;
    }

    public int getAll() {
        return all;
    }

    public void setAll(int all) {
        this.all = all;
    }
}
