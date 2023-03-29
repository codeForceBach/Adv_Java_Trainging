package dataStructureAlgorithms.collection.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListNodeImplementTest {

    LinkedListNodeImplement nodeList = new LinkedListNodeImplement();

    @Test
    void addAtTest() {
        nodeList.insertAtEnd(5);
        nodeList.insertAtEnd(15);
        assertNotNull(nodeList);
    }

    @Test
    void insertTest() {
    }


    @Test
    void sizeTest() {
        nodeList.insertAtEnd(10);
        nodeList.insertAtEnd(15);
        nodeList.insertAtEnd(17);
        assertEquals(3, nodeList.size());
        nodeList.shows();
    }

    @Test
    void getDataTest() {
        nodeList.insertAtEnd(10);
        nodeList.insertAtEnd(15);
        nodeList.insertAtEnd(17);
        assertNotEquals(17, nodeList.getData(1));
        assertEquals(17, nodeList.getData(3));
    }

    @Test
    void insertAtFirstEndTest() {
        nodeList.insertAtFirst(7);
        assertEquals(7, nodeList.getData(1));
        nodeList.insertAtEnd(25);
        assertEquals(25, nodeList.getData(2));
        nodeList.insertAtEnd(15);
        nodeList.insertAtFirst(11);
        assertEquals(4, nodeList.size());
        assertEquals(11, nodeList.getData(1));

    }

    @Test
    void insertAtTest() {
        nodeList.insertAtEnd(15);
        assertEquals(1, nodeList.size());
        nodeList.insertAtFirst(7);
        assertEquals(15, nodeList.getData(2));
        nodeList.InsertAt(1, 27);
        assertEquals(27, nodeList.getData(1));
        assertEquals(3, nodeList.size());
        nodeList.shows();
    }


    @Test
    void deleteAtTest() {
        nodeList.insertAtEnd(10);
        nodeList.insertAtEnd(15);
        nodeList.insertAtEnd(17);
        nodeList.insertAtEnd(9);
        nodeList.deleteAt(2);
        assertEquals(3, nodeList.size());
        assertEquals(17, nodeList.getData(2));
    }

    @Test
    void deleteTest() {
        /*
        assertFalse(nodeList.delete(5));
        nodeList.insertAtEnd(17);
        nodeList.insertAtEnd(17);
        assertTrue(nodeList.delete(17));
        nodeList.delete(17);

        assertNull(nodeList.head);
         */

        nodeList.insertAtEnd(10);
        nodeList.insertAtEnd(17);
        nodeList.insertAtEnd(9);
        nodeList.insertAtEnd(2);
        assertEquals(4, nodeList.size());

    }
}