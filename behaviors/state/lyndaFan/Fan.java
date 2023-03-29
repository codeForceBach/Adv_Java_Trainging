package designPatterns.behaviors.state.lyndaFan;

public class Fan {

    State state = new LowState();

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void turnUp(){
        state.turnUp(this);

    }
    public void turnDown(){
        state.turnDown(this);
    }
}
