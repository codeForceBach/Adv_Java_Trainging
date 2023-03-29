package javaEssential.oop.inherit;

public class Van extends PassengerCar{

    private String Feature = "Hor Air";
    int passengerCapacity = 7;

    //constructor
    public Van(String manufacture, String name, Trim trim) {
        super(2004, manufacture, name, trim);
    }
    public Van(int year, String manufacture, String name, Trim trim) {
        super(year, manufacture, name, trim);
    }

    public String getFeature() {

        return Feature;
    }

    public void setFeature(String feature) {

        Feature = feature;
    }
}
