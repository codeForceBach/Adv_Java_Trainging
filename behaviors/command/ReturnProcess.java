package designPatterns.behaviors.command;

public class ReturnProcess implements Order{
    private Jacket jacket;
    public ReturnProcess(Jacket jacket) {
        this.jacket = jacket;
    }

    @Override
    public void process(int qty) {
        jacket.returnOrder(qty);
    }
}
