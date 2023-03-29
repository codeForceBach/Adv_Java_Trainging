package dataStructureAlgorithms;

import dataStructureAlgorithms.collection.SortingOrderQueue;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.*;

class OrderQueueTests {

    Order od1 = new Order(345, 546.34, "Bach234");
    Order od2 = new Order(194, 991.11, "Park9352");
    Order od4 = new Order(191, 241.79, "Talyor8123");
    Order od6 = new Order(233, 336.37, "Smith434");

    Queue<Order> descendingOrderIdQueue = new PriorityQueue<Order> (new OrderIdDescendCompare());
    Queue<Order> descendingOrderAmountQueue = new PriorityQueue<Order>(new OrderAmountDescendCompare());
    Queue<Order> descendingCustomerIdQueue = new PriorityQueue<>(new OrderCustomerIdDescendCompare());
    Queue<Order> descedingCustomerNameQueue = new PriorityQueue<>(new OrderCustomerNameDescendCompare());

    @Test
    void LinkedListOrderIdAscendingTest(){

        Queue<Order> unSortedOrderList = new LinkedList<>();

        unSortedOrderList.add(od1);
        unSortedOrderList.add(od2);
        unSortedOrderList.add(od4);
        unSortedOrderList.add(od6);

        assertEquals(345, unSortedOrderList.peek().getOrderId());

        SortingOrderQueue queueOrderSort = new SortingOrderQueue();
        queueOrderSort.sortByOrderId(unSortedOrderList);
        assertEquals(191, unSortedOrderList.peek().getOrderId());
    }

    @Test
    void orderIdDescendingTest(){
        descendingOrderIdQueue.add(od1);
        descendingOrderIdQueue.add(od2);
        descendingOrderIdQueue.add(od4);
        descendingOrderIdQueue.add(od6);

        assertEquals(345, descendingOrderIdQueue.peek().getOrderId());

    }

    @Test
    void orderAmountDescendingTest(){
        descendingOrderAmountQueue.add(od1);
        descendingOrderAmountQueue.add(od2);
        descendingOrderAmountQueue.add(od4);
        descendingOrderAmountQueue.add(od6);
        assertEquals(991.11, descendingOrderAmountQueue.peek().getAmount());
    }

    @Test
    void descendingCutomerIdQueueTest(){
        descendingCustomerIdQueue.add(od1);
        descendingCustomerIdQueue.add(od2);
        descendingCustomerIdQueue.add(od4);
        descendingCustomerIdQueue.add(od6);
        assertEquals(191, descendingCustomerIdQueue.peek().getOrderId());

    }

    @Test
    void descedingCustomerNameTest(){
        descedingCustomerNameQueue.add(od1);
        descedingCustomerNameQueue.add(od2);
        descedingCustomerNameQueue.add(od4);
        descedingCustomerNameQueue.add(od6);
        assertEquals(233, descedingCustomerNameQueue.peek().getOrderId());
    }

}