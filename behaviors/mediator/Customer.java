package designPatterns.behaviors.mediator;

import java.util.HashMap;

public class Customer {
    //instantiate EcommerceSite and String address
    //private EcommerceSite ecom;
    private String address;

    //in constructor the address as argument to define, and pass this customer class as argument for the EcommerceSite

    public Customer(String address) {
        //ecom = new EcommerceSite(this);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
/*
    //add buy method with item and quantity and if EcommerceSite check quantity available then call sell method with item and quantity
    public void buy(String item, int quantity){
        if(ecom.checkStock(item, quantity)){
            ecom.sell(item, quantity);
        }
    }
    */
}
