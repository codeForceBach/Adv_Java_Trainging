package designPatterns.behaviors.state.lyndaFan;

public class HighState implements State{
    @Override
    public void turnUp(Fan fan) {
        System.out.println("The fan is already set to high!");
    }

    @Override
    public void turnDown(Fan fan) {
        fan.setState(new MediumState() );

    }
}
