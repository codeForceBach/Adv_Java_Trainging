package designPatterns.structure.adapter;

public class passangerPlane implements Airplane{

    private int passanger;
    private int cargo;
    private double speed;

    public passangerPlane(int passanger, int cargo, double speed) {
        this.passanger = passanger;
        this.cargo = cargo;
        this.speed = speed;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getPassanger() {
        return passanger;
    }

    public void setPassanger(int passanger) {
        this.passanger = passanger;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    @Override
    public void fly() {
        System.out.println("frying quite with comfort of passenger in long distance");

    }

    @Override
    public void payload() {
        System.out.println("Passenger capacity : " + passanger);
        System.out.println("Cargo capacity : " + cargo + "Ib");
    }

    @Override
    public void speedOdometer() {
        System.out.println("max speed with max cargo and passenger capacity : " + getSpeed());
    }
}
