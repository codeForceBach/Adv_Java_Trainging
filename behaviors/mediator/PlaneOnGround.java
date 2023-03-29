package designPatterns.behaviors.mediator;

import java.util.ArrayList;

public class PlaneOnGround {
    private ArrayList<Plane> groundPlanes = new ArrayList<Plane>();

    public void addPlane(Plane plane){
        if(!groundPlanes.contains(plane)){
            groundPlanes.add(plane);
            System.out.println("The Plane Id:  " + plane.getPlaneId() + " is in the air!");
        }

    }

    public void removePlane(Plane plane){
        if(groundPlanes.contains(plane)) {
            groundPlanes.remove(plane);
        }
    }
}
