package designPatterns.behaviors.mediator;

import java.util.ArrayList;

public class PlaneInFright {
    ArrayList<Plane> planesInAir = new ArrayList<Plane>();

    public void addPlane(Plane plane) {
        if (!planesInAir.contains(plane)) {
            planesInAir.add(plane);
        }
    }

    public void removePlane(Plane plane){
        if(planesInAir.contains(plane)) {
            planesInAir.remove(plane);
            System.out.println("Plane id " + plane.getPlaneId() + " is on the ground!");
        }
    }
}
