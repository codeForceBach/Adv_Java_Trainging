package designPatterns.behaviors.mediator;

public class Driver {

    //it has single method call delivery with item quantity and customer argument
    //simply print out the action.
    public void deliver(String item, int quantity, String customer){
        System.out.println(quantity + " " + item + " delivered to " + customer );
    }
}
