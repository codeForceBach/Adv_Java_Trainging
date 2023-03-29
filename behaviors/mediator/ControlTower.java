package designPatterns.behaviors.mediator;

public class ControlTower {

    private Plane plane;
    private PlaneInFright frightPlane;
    private PlaneOnGround groundPlane;
    private Runway runway;

    public ControlTower(Plane plane) {
        this.plane = plane;
        frightPlane = new PlaneInFright();
        groundPlane = new PlaneOnGround();
        runway = new Runway();
    }

    public void landing(){
        if(plane.isInTheAir() && runway.isAvailable()){
            System.out.println("plane " + plane.getPlaneId() + " is landing...");
            plane.setInTheAir(false);
            frightPlane.removePlane(plane);
            groundPlane.addPlane(plane);
            runway.setIsAvailable(true);

        }

    }
    public void takeOff() {
        if(!plane.isInTheAir() && runway.isAvailable()){
            System.out.println("plane " + plane.getPlaneId() + " is taking off...");
            plane.setInTheAir(true);
            frightPlane.addPlane(plane);
            groundPlane.removePlane(plane);
            runway.setIsAvailable(true);

        }
    }
}
