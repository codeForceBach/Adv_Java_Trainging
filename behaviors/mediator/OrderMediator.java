package designPatterns.behaviors.mediator;

public class OrderMediator {

    //initialize all the object
    private EcommerceSite eCom;
    private Customer customer;
    private Driver driver;

    //instantiate all the object in constructor

    public OrderMediator(String address) {

        this.customer = new Customer(address);
        //this.eCom = new EcommerceSite(customer);
        this.eCom = new EcommerceSite();
        this.driver = new Driver();
    }


    //implement buy method from EcommerceSite
    public void buy(String item, int quantity){
        if(eCom.checkStock(item, quantity)){
            eCom.sell(item, quantity);
            driver.deliver(item, quantity, customer.getAddress());
        }
    }
}
