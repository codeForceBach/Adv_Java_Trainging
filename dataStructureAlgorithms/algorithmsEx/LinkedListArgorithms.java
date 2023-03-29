package dataStructureAlgorithms.algorithmsEx;

import java.util.HashMap;
import java.util.Map;

public class LinkedListArgorithms {

    ListNode listNode = new ListNode();

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        /*
        2. Add Two Numbers - https://leetcode.com/problems/add-two-numbers/
        You are given two non-empty linked lists representing two non-negative integers.
        The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
        You may assume the two numbers do not contain any leading zero, except the number 0 itself.
            Example 1:
            Input: l1 = [2,4,3], l2 = [5,6,4]
            Output: [7,0,8]
            Explanation: 342 + 465 = 807

            Example 2:
            Input: l1 = [0], l2 = [0]
            Output: [0]

            Example 3:
            Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
            Output: [8,9,9,9,0,0,0,1]

            The number of nodes in each linked list is in the range [1, 100].
            0 <= Node.val <= 9
            It is guaranteed that the list represents a number that does not have leading zeros.
         */
        /*
        06/15/2022
        https://www.youtube.com/watch?v=wgFPrzTjm7s - python
        https://www.youtube.com/watch?v=aM4Iv7eEr2o - java
        to encounter corner case of one of node is null, check the value is available
        use OR case in while loop for both list to eliminate if for each list
        initialize carry outside of loop
         */
        ListNode sumNode = new ListNode(0);
        ListNode head = sumNode;
        int carry = 0;
        //as long as there are L1 and l2 node
        while (l1 != null || l2 != null) {

            int val = (l1.val + l2.val + carry);//for current node value
            carry = val / 10;//possibly pass on to next node
            val = val % 10;

            //create a node with value
            ListNode temp = new ListNode(val);
            //assign the temp node to next to current node
            sumNode.next = temp;
            //move the current node to next ndoe which is temp
            sumNode = sumNode.next;

            //assign next node of l1, l2 if only next exist otherwise
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        //if the initial node was created with zero or no value has been assinged
        //thus pass the next node of the list to point first node with sum value
        return head.next;

    }

    public ListNode reverseListIterative(ListNode head){
        /*
        206. Reverse Linked List - https://leetcode.com/problems/reverse-linked-list/
        Given the head of a singly linked list, reverse the list, and return the reversed list.

            Example 1:
            Input: head = [1,2,3,4,5]
            Output: [5,4,3,2,1]

            Example 2:
            Input: head = [1,2]
            Output: [2,1]

            Example 3:
            Input: head = []
            Output: []
         */
        //https://www.youtube.com/watch?v=N_Y12-5oa-w (Fisher Code)
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = head.next;//temprary node in each iteration
            curr.next = prev; //assign prev as next node for current node, so that it lost link from the head.next which is same as curr.next
            prev = curr; // reverse the temp "prev" node as head node curr
            curr = next;//move curr to next which hold remainng node as temp node
            //revisit curr node
        }
        return prev;
    }

    public ListNode reverseListRecursive(ListNode head){
        //https://www.youtube.com/watch?v=W-EfGB0E_ao&list=PLK0ZC7fyo01L_GQ09e7GwcGFLba40s6JM&index=5
        //call private method to pass head with null for the temp Node newHead
        return ReverseLinkedListHelp(head, null);
    }

    public void reorderList(ListNode head){
        /*
        143. Reorder List - https://leetcode.com/problems/reorder-list/

            You are given the head of a singly linked-list. The list can be represented as:
            L0 → L1 → … → Ln - 1 → Ln

            Reorder the list to be on the following form:
            L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …

            You may not modify the values in the list's nodes. Only nodes themselves may be changed.
            The number of nodes in the list is in the range [0, 500].
            -100 <= Node.val <= 100
            0 <= k <= 2 * 109
         */
        /* 06/13/2022
           https://www.youtube.com/watch?v=S5bfdUTrKLM
           https://www.youtube.com/watch?v=xRYPjDMSUFw
           split the list to two with two pointer technique to reverse second half of the list
           litarate
         */
        //prerequisit check to see if head or head.next is null.
        // without pro condition check it run into null point exception. in the iteration.
        if(head == null || head.next == null){
            return;
        }
        //1. split the list to two with two pointer technique

        ListNode slow = head;
        ListNode fast = head;
        ListNode firstHalf = null;
        while(fast != null && fast.next != null){
            firstHalf = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode half = slow.next;
        slow.next = null;//break link from second half list for the firstHalf

        //2. reverse second half of the list
        ListNode reverse = null;
        while(half != null){
            ListNode temp = half.next;
            half.next = reverse;
            reverse = half;
            half = temp;
        }

        //3. iterate two separate lists to combine together

        while(reverse != null) {
            ListNode tempFirst = firstHalf.next;
            ListNode tempSecond = reverse.next;
            firstHalf.next = reverse;
            reverse.next = tempFirst;
            firstHalf = tempFirst;
            reverse = tempSecond;

        }

    }

    public ListNode rotateRight(ListNode head, int k){
        /*
        61. Rotate List - https://leetcode.com/problems/rotate-list/
        Given the head of a linked list, rotate the list to the right by k places.

            Example 1:
            Input: head = [1,2,3,4,5], k = 2
            Output: [4,5,1,2,3]

            Example 2:
            Input: head = [0,1,2], k = 4
            Output: [2,0,1]
         */
        /*06/14/2022
        https://www.youtube.com/watch?v=UcGtPs2LE_c
        move k node from the end of a list to the front of the node in the list
         */

        //1. count number of node.It also give the last node (tail) to link to head

        ListNode tail = head;
        //start with 1 so that when it reaches tail.next == null it already optain last index value ahead of exist the loop
        int length = 1;
        while(tail != null && tail.next != null){
            tail = tail.next;
            length++;
        }

        //2. get mod value in case the k > length
        k = k % length;
        if(k == 0){
            return head;
        }

        //3. jump over amount of node prior to new head
        ListNode newHead = null;
        ListNode curr = head;
        for(int i = 1 ; i < length - k ; i++){
            curr = curr.next;
        }
        //cut the link to next to new node
         newHead = curr.next;
        //re assign next of current node to be null
        curr.next = null;
        //the tail which is last node of the newHead node to be linked to head so swap is complete
        tail.next = head;

        return newHead;

    }

    public ListNode removeNthFromEnd(ListNode head, int n){
        /*
        19. Remove Nth Node From End of List - https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    Given the head of a linked list, remove the nth node from the end of the list and return its head.

        Example 1:
        Input: head = [1,2,3,4,5], n = 2
        Output: [1,2,3,5]

        Example 2:
        Input: head = [1], n = 1
        Output: []

        Example 3:
        Input: head = [1,2], n = 1
        Output: [1]
     */
        /*06/14/2022
        https://www.youtube.com/watch?v=Kka8VgyFZfc&list=PLK0ZC7fyo01L_GQ09e7GwcGFLba40s6JM&index=3
        two pointer technique slow and fast from haed
        slow start at head fast starts head.next.next which is equal distance of int n
        also assign additioal ListNode to point slow to return the new LinkedList
        move until fast reach end another word if fast.next == null
        move pointer of slow.next to slow.next.next which would delete the nth node from the end.
         */
        ListNode doodle;
        doodle = head;

        ListNode slow = doodle;
        ListNode fast = doodle;
        //move fast only until the distance between fast and slow is equals n
        //as fast mvoe along subtract n by 1 until it reach t0 zero which mean it reaches the distance between fast and slow
        while (fast.next != null){
            fast = fast.next;
            if(n-- <= 0){
                slow = slow.next;
            }
        }
        //once all iteration come to an end, the slow is one node before the n node that need to be removed.
        //so simply jump to next node it disconnects from the previous node
        slow.next = slow.next.next;

        return doodle;
    }//end remvoeNthFromEnd

    public ListNode deleteDuplicates(ListNode head){
        /*
        Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

        Input: head = [1,1,2]
        Output: [1,2]

        Input: head = [1,1,2,3,3]
        Output: [1,2,3]

        Input: head = [1,1,2,3,3]
        Output: [1,2,3]
        Constraints:

        The number of nodes in the list is in the range [0, 300].
        -100 <= Node.val <= 100
        The list is guaranteed to be sorted in ascending order.
        */
        //if head is null or head next is null, return head itself

        ListNode current = head;
        //while current is not null and current.next is not null
        //check to see if the current.value is equals to next current.value
        //else keep moving to next.
        int data = 0;
        if(current != null){
            while(current.next != null) {
            }
        }

        return null;
    }//end deleteDuplicates

    public boolean isPalindromeLinkedList(ListNode head){
        /*
        234. Palindrome Linked List - https://leetcode.com/problems/palindrome-linked-list/
        Given the head of a singly linked list, return true if it is a palindrome.

        Example 1:
            Input: head = [1,2,2,1]
            Output: true

        Example 2:
            Input: head = [1,2]
            Output: false

         Follow up: Could you do it in O(n) time and O(1) space?
         */

        /*
        //https://www.youtube.com/watch?v=bOGh_3MTrdE&list=PLK0ZC7fyo01L_GQ09e7GwcGFLba40s6JM&index=8
        create two node (pointers) and move through one node to next and the other to next.next
        move twice faster that the other to get to end of node
        reverse the slow Node since it reached to half of the Node the fast node already reverse beginning of the node.
        compare two list to see if each values are equals and if these are not match return false.
        otherwise keep move to the next until the end and return true if all the value are match.
         */

        if (head == null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode firstHalf = reverseListIterative(slow.next);
        ListNode secondHalf = head;

        while(firstHalf != null && secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            } else {
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next;
            }
        }
        return true;
    }

    private ListNode ReverseLinkedListHelp(ListNode head, ListNode newHead){
        /*if head is null return newHead which passed as null
        if the head is not null, assign new temp next as head
        since head.next established new node as next, assign  head.next to point newHead
        then move newHead to replace head and move head to next
         */

        if(head == null){

            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;

        return ReverseLinkedListHelp(head, newHead);

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
        /*
        21. Merge Two Sorted Lists - https://leetcode.com/problems/merge-two-sorted-lists/
         //https://www.youtube.com/watch?v=XIdigk956u0
            You are given the heads of two sorted linked lists list1 and list2.
            Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
            Return the head of the merged linked list.

            Input: list1 = [1,2,4], list2 = [1,3,4]
            Output: [1,1,2,3,4,4]

            Input: list1 = [], list2 = []
            Output: []

            Input: list1 = [], list2 = [0]
            Output: [0]

            Constraints:
                The number of nodes in both lists is in the range [0, 50].
                -100 <= Node.val <= 100
                Both list1 and list2 are sorted in non-decreasing order.
        */

        //https://www.youtube.com/watch?v=N8WTaSSivEI&list=PLK0ZC7fyo01L_GQ09e7GwcGFLba40s6JM&index=6

        ListNode temp = new ListNode();
        ListNode curr = temp;

        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                curr.next = list1;
                list1 = list1.next;
            }else {
                curr.next = list2;
                list2 = list2.next;
            }
            curr = curr.next;

        }

        curr.next = list1 != null ? list1 : list2;
        return temp.next;
    }

    public ListNode mergeTwolistsRecursive(ListNode l1, ListNode l2){
        //https://www.youtube.com/watch?v=bdWOmYL5d1g&list=PLK0ZC7fyo01L_GQ09e7GwcGFLba40s6JM&index=7
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        if(l1.val < l2.val){
            l1.next = mergeTwolistsRecursive(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwolistsRecursive(l1, l2.next);
            return l2;
        }

    }

    public boolean hasCycle(ListNode head){
        /*
        141. Linked List Cycle - https://leetcode.com/problems/linked-list-cycle/
        Given head, the head of a linked list, determine if the linked list has a cycle in it.
        There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
        Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
        Return true if there is a cycle in the linked list. Otherwise, return false.
        https://www.youtube.com/watch?v=agkyC-rbgKM&list=PLK0ZC7fyo01L_GQ09e7GwcGFLba40s6JM&index=9 - Fisher Code
         */
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void deleteNode(ListNode node){
        /*
        237. Delete Node in a Linked List - https://leetcode.com/problems/delete-node-in-a-linked-list/
        Write a function to delete a node in a singly-linked list.
        You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

            It is guaranteed that the node to be deleted is not a tail node in the list.

            Example 1:
            Input: head = [4,5,1,9], node = 5
            Output: [4,1,9]
            Explanation: You are given the second node with value 5, the linked list should become 4 -> 1 -> 9 after calling your function.

            Example 2:
            Input: head = [4,5,1,9], node = 1
            Output: [4,5,9]
            Explanation: You are given the third node with value 1, the linked list should become 4 -> 5 -> 9 after calling your function.

            basically this is a code trick : simply assgine value of the node to next node value.
            then assign node.next = node.next.next

         */
        node.val = node.next.val;
        node.next = node.next.next;

    }

    public Node copyRandomList(Node head){
        /*
        138. Copy List with Random Pointer - https://leetcode.com/problems/copy-list-with-random-pointer/
        A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

        Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
        For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
        Return the head of the copied linked list.
        The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
        val: an integer representing Node.val
        random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
        Your code will only be given the head of the original linked list.
         */
        /*
        06/15/2022
        https://www.youtube.com/watch?v=5Y2EiZST97Y - neetCode/amazon Q
        https://www.youtube.com/watch?v=toXiQdhGf64 - java
          ** use HashMap to store copy of the each node
          in 2nd iteartion get value node from the map and establish link to next and random.
        iterate two pass
        first pass  - make deep copy all the node without any link, and hashmap
         */
        Map<Node, Node> nodeMap = new HashMap<>();
        return nodeMap.get(head);
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}



