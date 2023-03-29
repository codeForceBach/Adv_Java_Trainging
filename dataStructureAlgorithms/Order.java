package dataStructureAlgorithms;

import java.util.Comparator;
import java.util.Objects;

/*
simple order class to validate nested classes to compare each property of the class in descending order
 */
public class Order implements Comparable<Order> {

    private int orderId;
    private double amount;
    private String customerId;
    private String customerName;

    public Order(int orderId, double amount, String customerId) {
        this.orderId = orderId;
        this.amount = amount;
        this.customerId = customerId;

        ;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String setCustomerName(String customerName) {
        String newCustomerName = customerName;
        return newCustomerName;
    }

    @Override
    /*
    sort order instances based on orderId in ascending order(natural order)
     */
    public int compareTo(Order o) {
        return this.orderId > o.orderId ? 1: -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getOrderId() == order.getOrderId() && Double.compare(order.getAmount(), getAmount()) == 0 && getCustomerId() == order.getCustomerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getAmount(), getCustomerId());
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", amount=" + amount +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}// end Order class


/*
This nested class implements Comparator for the Order object resulting descending order based on orderId.
 */
class OrderIdDescendCompare implements Comparator<Order>{

    @Override
    public int compare(Order o1, Order o2) {
        //by using o1 < o2> 1 :-1 we will get the result in descending order
        return o1.getOrderId() < o2.getOrderId()? 1 : -1;
    }
}

/*
This nested class implements Comparator for the order object resulting ascending order based on orderAmount.
 */
class AscendOrderAmountCompare implements  Comparator<Order>{

    @Override
    public int compare(Order o1, Order o2) {
        return o1.getAmount() > o2.getAmount() ? 1 : -1;
    }
}

/*
This nested class implements Comparator for the order object resulting descending order based on orderAmount.
 */
class OrderAmountDescendCompare implements Comparator<Order>{

    @Override
    public int compare(Order o1, Order o2) {
        return o1.getAmount() < o2.getAmount() ? 1 : -1;
    }
}

class AscendCustomerIdCommpare implements Comparator<Order>{
    @Override
    public int compare(Order o1, Order o2) {
        if(o1.getCustomerId().compareTo(o2.getCustomerId()) > 0) {
            return 1;
        }else if (o1.getCustomerId().compareTo(o2.getCustomerId()) < 0 ){
            return -1;
        } else {
            return 0;
        }
    }
}

/*

 */
class OrderCustomerIdDescendCompare implements Comparator<Order>{

    @Override
    public int compare(Order o1, Order o2) {
        if(o1.getCustomerId().compareTo(o2.getCustomerId()) < 0){
            return 1;
        } else if(o1.getCustomerId().compareTo(o2.getCustomerId()) > 0){
            return -1;
        } else {
            return 0;
        }
    }
}

class OrderCustomerNameDescendCompare implements Comparator<Order>{

     @Override
     public int compare(Order o1, Order o2) {
         if(o1.getCustomerName().compareTo(o2.getCustomerName()) < 0){
            return 1;
         } else if(o1.getCustomerName().compareTo(o2.getCustomerName()) > 0){
             return -1;
         } else {
             return 0;
         }
     }
 }



