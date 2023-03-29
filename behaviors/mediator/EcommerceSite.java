package designPatterns.behaviors.mediator;

import java.util.HashMap;

public class EcommerceSite {
    //instamtiate Customer, Driver and Stock HashMap with type of String and Integer
    //private Customer customer;
    //private Driver driver;
    private HashMap <String , Integer> stock;

    //constructor pass Customer and define and add several item adn quantity(?)

    public EcommerceSite(){//Customer customer) {
       // this.customer = customer;
        //this.driver = new Driver();
        stock = new HashMap<>();
        stock.put("pens", 20);
        stock.put("eraser", 30);
        stock.put("notepad", 17);
        stock.put("envelopes", 45);

    }


    //add checkStock with item and quantity argument
    //if hashMap contain the item and quantity is more than order quantity set boolean return value
    public boolean checkStock(String item, int quantity){

        if(stock.containsKey(item) && stock.get(item) > quantity){
            return true;
        } else {
            return false;
        }
    }

    //sell method with item and quantity argument adjust quantity in the Stock
    //and call Deliver method in Driver with item quantity and customer
    public void sell(String item, int quantity){
        int newQty = stock.get(item) - quantity;
        stock.put(item, newQty);
        //driver.deliver(item, quantity, customer.getAddress());
    }
}
