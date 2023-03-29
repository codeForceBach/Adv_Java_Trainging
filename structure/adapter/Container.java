package designPatterns.structure.adapter;

public class Container implements Truck{
    private int cylinder;
    private double volume;
    private int horsePower;
    private double cargoCap;


    public Container(int cynlinder, double volume, int horsePower) {
        this.cylinder = cynlinder;
        this.volume = volume;
        this.horsePower = horsePower;
    }

    public int getCylinder() {
        return cylinder;
    }

    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public void engine() {
        System.out.println("Engine equipped with : " + cylinder + ", " + volume + ", " + horsePower + ".");
    }

    @Override
    public void cargoCapacity() {

    }

    @Override
    public void speedOdometer() {

    }
}
