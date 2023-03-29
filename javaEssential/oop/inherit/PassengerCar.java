package javaEssential.oop.inherit;

import java.awt.*;

public class PassengerCar implements Vehicle{
    private int year;
    private String manufacture;
    private String name;
    private Color exterior_Color;
    private Color interior_Color;
    Trim trim;


    public PassengerCar(int year, String manufacture, String name, Trim trim) {
        this.year = year;
        this.manufacture = manufacture;
        this.name = name;
        this.trim = trim;
    }

    public Color getInterior_Color() {
        return interior_Color;
    }

    public void setInterior_Color(Color interior_Color) {
        this.interior_Color = interior_Color;
    }

    public Color getExterior_Color() {
        return exterior_Color;
    }

    public void setExterior_Color(Color exterior_Color) {
        this.exterior_Color = exterior_Color;
    }

    public int getYear() {

        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {

        this.manufacture = manufacture;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public Trim getTrim() {

        return trim;
    }

    public void setTrim(Trim trim) {

        this.trim = trim;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "year=" + year +
                ", Manufacture='" + manufacture + '\'' +
                ", name='" + name + '\'' +
                ", trim='" + trim + '\'' +
                "}";
    }
}
