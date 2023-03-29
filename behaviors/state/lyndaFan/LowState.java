package designPatterns.behaviors.state.lyndaFan;

public class LowState implements State{

    @Override
    public void turnUp(Fan fan) {
        System.out.println("The fan is already in low setting!");
    }

    @Override
    public void turnDown(Fan fan) {
        fan.setState(new MediumState());
        System.out.println("the fan is set to Medium!");

    }
}
