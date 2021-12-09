package ssu.edu.ua.traininfodms.Models;

import ssu.edu.ua.traininfodms.Domain.Shared.Seats;

public class SeatsDto {
    public SeatsDto(Seats seats) {
        FirstClass = seats.getFirstClass();
        SecondClass = seats.getSecondClass();
        ThirdClass = seats.getThirdClass();

        All = FirstClass + SecondClass + ThirdClass;
    }

    private int All;
    private int FirstClass;
    private int SecondClass;
    private int ThirdClass;

    public int getFirstClass() {
        return FirstClass;
    }

    public void setFirstClass(int firstClass) {
        FirstClass = firstClass;
    }

    public int getSecondClass() {
        return SecondClass;
    }

    public void setSecondClass(int secondClass) {
        SecondClass = secondClass;
    }

    public int getThirdClass() {
        return ThirdClass;
    }

    public void setThirdClass(int thirdClass) {
        ThirdClass = thirdClass;
    }

    public int getAll() {
        return All;
    }

    public void setAll(int all) {
        All = all;
    }
}
