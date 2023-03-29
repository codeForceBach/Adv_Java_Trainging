package designPatterns.behaviors.command;

public class OrderHandler {

    public void invoke(int orderQty, Order order){

        order.process(orderQty);
    };
}
