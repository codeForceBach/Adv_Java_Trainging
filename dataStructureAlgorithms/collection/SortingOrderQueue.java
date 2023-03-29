package dataStructureAlgorithms.collection;

import dataStructureAlgorithms.Order;

import java.util.Queue;

public class SortingOrderQueue {

    private Queue<Order> sortedOrder;

    /*
    Given list of orders in a Queue, sort orders based on orderId in ascending order.
    do not use extra memory space to create new list and copy
     */
    public void sortByOrderId(Queue<Order> orderList){
        //iterate orderList
        for(int i = 1 ; i <= orderList.size() ; i++) {
            // each iteration pass on the orderlist with size of unordered list size
            //to find index of the least orderId in the list
            int min_index = findMinimumOrderId(orderList, orderList.size() - i);
            //with the least orderId index, iterate list to re order based on orderId
            sortOrderId(orderList, min_index);
        }//end for loop

    }

    /*
    iterate through the queue to find an order of min_value.
    store the order aside and insert at the end of the iteration to sort based on orderId
     */
    private void sortOrderId(Queue<Order> orderList, int min_index) {
        Order minOrder = null;
        /*the reason j<= orderList.size() is at some point of iteration the minimum Order is polled out from the list
        so the size of the list is shrink but in order to go through the entire list( especially the last one in the list
        it need to be includes shrink size of the list.
         */
        for(int j = 0 ; j <= orderList.size() ; j++){
            Order currentOrder = orderList.peek();
            orderList.poll();
            //if the index of the order is not same as min_index simply put the order back to queue
            if(j != min_index){
                orderList.add(currentOrder);
            } else {
                minOrder = currentOrder;
            }
        }//end for loop
        orderList.add(minOrder);
    }

    private int findMinimumOrderId(Queue<Order> orderList, int unSortedIndex) {
        //initialize bogus min_index as -1
        int min_index = -1;
        //initialize bogus min_value as Integer.MIN_VALUE
        int min_value = Integer.MAX_VALUE;
        //iterate over orderList
        for(int j = 0; j < orderList.size(); j++){

            int currentOrderId = orderList.peek().getOrderId();
            Order currentOrder = orderList.poll();

            //if the current value is the new minimum and iteration count J less than unSortedIndex
            if(currentOrderId <= min_value && j <= unSortedIndex){
                //assign current iteration j as min_index and currnet orderId as min_value
                min_index = j;
                min_value = currentOrderId;
            }
            //put the current order to queue at the back
            orderList.add(currentOrder);
        }
        return min_index;
    }//end of findMinmunOrderId

    /*
    Given list of orders in a Queue, sort orders based on orderId in descending order.
    do not use extra memory space to create new list and copy
     */
    public void sortByDesceningOrderid(Queue<Order> orderQueue){

    }

    /*
    given list of Order in a Queue, sort Orders based on orderAmount in ascending order
    do not use extra memory space to create new list and copy
     */
    public void sortByOrderAmount(Queue<Order> orderQueue){

    }

    /*
    given list of Order in a Queue, sort Orders based on orderAmount in descending order
    do not use extra memory space to create new list and copy
     */
    public void sortByDescendingOrderAmount(Queue<Order> orderQueue){

    }

    /*
    given list of Order in a Queue, sort Orders based on orderAmount in ascending order
    do not use extra memory space to create new list and copy
     */
    public void sortByCutomerId(Queue<Order> orderQueue){

    }

    /*
    given list of Order in a Queue, sort Orders based on customerId in descending order
    do not use extra memory space to create new list and copy
     */
    public void sortByDescendingCustomerId(Queue<Order> orderQueue){

    }

}
