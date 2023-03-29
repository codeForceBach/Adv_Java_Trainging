package designPatterns.behaviors.visitor.lynda;

public interface Groceries {
    double getPrice();
    void accept(Visitor visitor);
}
