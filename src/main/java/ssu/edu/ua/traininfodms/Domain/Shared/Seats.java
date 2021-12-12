package ssu.edu.ua.traininfodms.Domain.Shared;

public class Seats {
    private int FirstClass;
    private int SecondClass;
    private int ThirdClass;

    public Seats(){}

    public Seats(int firstClass, int secondClass, int thirdClass){
        FirstClass = firstClass;
        SecondClass = secondClass;
        ThirdClass = thirdClass;
    };

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
}
