package designPatterns.behaviors.mediator;

public class Plane {
    //initialize planeid &  boolean isInTheAir with
    //Runaway, PlaneInFright, PlaneOnGround object
    private int planeId;
    private boolean isInTheAir;
    //private Runway runway;
    //private PlaneInFright planeInFright;
    //private PlaneOnGround planeOnGround;

    //instantiate all the object in constructor with argument id
    public Plane(int planeId) {
        this.planeId = planeId;
        isInTheAir = false;
        //runway = new Runway();
        //planeInFright = new PlaneInFright();
        //planeOnGround = new PlaneOnGround();
    }

    public int getPlaneId() {
        return planeId;
    }

    public void setPlaneId(int planeId) {
        this.planeId = planeId;
    }

    public boolean isInTheAir() {
        return isInTheAir;
    }

    public void setInTheAir(boolean inTheAir) {
        isInTheAir = inTheAir;
    }
/*
    //implement takeOff method that validate variable isInTheAir and runaway getIsAvailiable method
    public void takeOff() {
        if(!isInTheAir && runway.isAvailable()){
            System.out.println("plane " + planeId + " is taking off...");
            setInTheAir(true);
            planeInFright.addPlane(this);
            planeOnGround.removePlane(this);
            runway.setIsAvailable(false);

        }

    }
*/


}
