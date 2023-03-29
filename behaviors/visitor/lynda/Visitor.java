package designPatterns.behaviors.visitor.lynda;

public interface Visitor {
    void visit(Bread bread);
    void visit(Milk milk);
    void visit(GroceriesList groceriesList);
}
