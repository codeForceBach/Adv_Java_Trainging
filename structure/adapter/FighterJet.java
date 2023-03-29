package designPatterns.structure.adapter;

public class FighterJet implements Airplane{

    private double payload;
    private double speed;
    private String[] weapons;

    public FighterJet(double payload, double speed, String[] weapons) {
        this.payload = payload;
        this.speed = speed;
        this.weapons = weapons;
    }

    public double getPayload() {
        return payload;
    }

    public void setPayload(double payload) {
        this.payload = payload;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public String[] getWeapons() {
        return weapons;
    }

    public void setWeapons(String[] weapons) {
        this.weapons = weapons;
    }

    @Override
    public void fly() {
        System.out.println("fight as speed of sound, ready to unload missiles and bombs");
    }

    @Override
    public void payload() {
        System.out.println("max weapon payload : " + payload);
    }

    @Override
    public void speedOdometer() {
        System.out.println("unparalleled speed of : " + speed + " that no one can catch up");
    }
}
