package designPatterns.behaviors.visitor.lynda;

public class discountVisitor implements Visitor{
    @Override
    public void visit(Bread bread) {
        bread.setPrice(2.99);
    }

    @Override
    public void visit(Milk milk) {
        milk.setPrice(1.99);
    }

    @Override
    public void visit(GroceriesList groceriesList) {

    }
}
