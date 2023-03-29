package designPatterns.behaviors.visitor.lynda;

public class Bread implements Groceries{
    private double price;

    public Bread(double price) {
        this.price = price;
    }


    public void setPrice(double price){
        this.price = price;
    }
    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
