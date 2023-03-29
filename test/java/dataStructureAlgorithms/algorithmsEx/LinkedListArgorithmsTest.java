package dataStructureAlgorithms.algorithmsEx;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListArgorithmsTest {
    LinkedListArgorithms ListNode = new LinkedListArgorithms();

    ListNode ls1 = new ListNode(2);
    ListNode node2 = new ListNode(4, ls1);
    ListNode node3 = new ListNode(3, node2);

    ListNode ls2 = new ListNode(5);
    ListNode node6 = new ListNode(6, ls2);
    ListNode node4 = new ListNode(4, node6);

    @Test
    @DisplayName("testing Node concept with linked list")
    void addTwoNumbersTest() {
        ListNode sumNode = ListNode.addTwoNumbers(ls1, ls2);
        assertEquals(7, sumNode.val);
    }

    @Test
    @DisplayName("merge two linked node ")
    void mergeTwoListsTest() {
        ListNode node13 = new ListNode(13);
        ListNode node8 = new ListNode(8, node13);
        ListNode node4 = new ListNode(4, node8);

        ListNode node11 = new ListNode(11);
        ListNode node9 = new ListNode(6, node11);
        ListNode node5 = new ListNode(4, node9);

        LinkedListArgorithms nodeApp = new LinkedListArgorithms();
        ListNode mergeNode = nodeApp.mergeTwoLists(node4, node5);
        assertEquals(4, mergeNode.next.val);
        assertNotNull(mergeNode.next.next.next);
    }
}

