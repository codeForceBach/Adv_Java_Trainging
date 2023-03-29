package designPatterns.behaviors.mediator;

public class Runway {

    private boolean isAvailable = true;

    public void setIsAvailable(boolean b) {
        this.isAvailable = b;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
