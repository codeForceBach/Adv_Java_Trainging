package designPatterns.behaviors.state.lyndaFan;

public class MediumState implements State {
    @Override
    public void turnUp(Fan fan) {
        fan.setState(new HighState());
        System.out.println("the fans is set to High!");
    }

    @Override
    public void turnDown(Fan fan) {
        fan.setState(new LowState());
        System.out.println("the fan is set to low");
    }
}
