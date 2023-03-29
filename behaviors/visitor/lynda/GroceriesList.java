package designPatterns.behaviors.visitor.lynda;

import java.util.ArrayList;

public class GroceriesList implements Groceries{

    ArrayList<Groceries> grocery = new ArrayList<Groceries>();

    public void addGroceries(Groceries grocery){
        this.grocery.add(grocery);
    }

    @Override
    public double getPrice() {
        double sum = 0;
        for(Groceries g : grocery){
            sum += g.getPrice();
        }
        return sum;

    }

    @Override
    public void accept(Visitor visitor) {
       for(Groceries g : grocery){
           g.accept(visitor);

       }
        visitor.visit(this);
    }
}
