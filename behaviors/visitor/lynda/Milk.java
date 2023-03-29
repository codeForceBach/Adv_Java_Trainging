package designPatterns.behaviors.visitor.lynda;

public class Milk implements Groceries{

    private double price;

    public Milk(Double price) {
        this.price = price;
    }

    public void setPrice(Double price){
        this.price = price;
    }
    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
