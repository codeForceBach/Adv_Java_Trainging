package designPatterns.behaviors.command;

public class OrderProcess implements Order{
    private Jacket jacket;

    public OrderProcess(Jacket jacket) {
        this.jacket = jacket;
    }

    @Override
    public void process(int qty) {
        jacket.placeOrder(qty);
    }
}
