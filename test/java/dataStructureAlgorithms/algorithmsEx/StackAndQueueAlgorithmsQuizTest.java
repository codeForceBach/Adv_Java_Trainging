package dataStructureAlgorithms.algorithmsEx;

import dataStructureAlgorithms.collection.Tree.BinaryTree;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StackAndQueueAlgorithmsQuizTest {

    BinaryTree biTree = new BinaryTree();
    StackAndQueueAlgorithmsQuiz stackQ = new StackAndQueueAlgorithmsQuiz();

    @Test
    void isValidParenthesesTest() {
        String s = "()";
        assertTrue(stackQ.isValidParentheses(s));
    }

    @Test
    void generateParenthesesTest() {
        List<String> parentheses = stackQ.generateParentheses(4);
        //List<String> result = Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()");
        for(String s : parentheses){
            System.out.print(s + ", ");
        }
        assertEquals(14, stackQ.generateParentheses(4).size());
        //assertEquals(parentheses, result);
    }

    @Test
    void nextGeneratorElementTest() {
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};
        int[] result = {-1, 3, -1};
        assertEquals(result, stackQ.nextGeneratorElement(num1, num2));

    }

    @Test
    void dailyTemperaturesTest() {
        int [] Tempe = {73,74,75,71,69,72,76,73};
        int [] result = {1,1,4,2,1,1,0,0};
        assertEquals(result, stackQ.dailyTemperatures(Tempe));
    }

    @Test
    void inorderTraversalStackTest() {
        int[] intTree = {6, 4, 8, 3, 5, 7, 9, 13, 11, 2, 17, 15, 19};
        for (int i : intTree) {
            biTree.add(i);
        }
        List<Integer> inOrderList = stackQ.inorderTraversalStack(biTree.getRoot());

        // created private method to do the conversion at the top
        int[] copyTree = convertToIntArray(inOrderList);

        //https://www.baeldung.com/java-comparing-arrays
        int[] expectList = {2, 3, 4, 5, 6, 7, 8, 9, 11, 13, 15, 17, 19};
        assertTrue(Arrays.equals(expectList, copyTree));
    }

    @Test
    void validStackSequenceTest() {
        int [] popped = {1, 2, 3, 4, 5};
        int [] pushed = {4, 3 ,5, 1, 2};
        //assertFalse(stackQ.validStackSequence(popped, pushed));
        int [] pushOk = {4, 5 ,3, 2, 1};
        assertTrue(stackQ.validStackSequence(popped, pushOk));
    }

    //https://leetcode.com/problems/kth-largest-element-in-a-stream/
    //https://leetcode.com/problems/kth-largest-element-in-a-stream/solutions/1416368/kth-largest-element-in-a-stream/

    @Test
    void testDescendingOrderQueue(){
        //when you initialize a PriorityQueue add the custom Comparator class
            Queue<Integer> priorityIntegerQueue = new PriorityQueue<>(new IntegerDescendCompartor());
            priorityIntegerQueue.add(24);
            priorityIntegerQueue.add(17);
            priorityIntegerQueue.add(8);
            priorityIntegerQueue.add(3);

            List <Integer> DescendOrderList = new ArrayList<>();

            while(!priorityIntegerQueue.isEmpty()){
                System.out.println(priorityIntegerQueue.peek());
                DescendOrderList.add(priorityIntegerQueue.poll());
            }
            assertEquals(8, DescendOrderList.get(2));

    }

    @Test
    void testDescendingStringPriortyQueue(){
        Queue<String> priorityStringQueue = new PriorityQueue<>(new StringDescendCompartor());
        priorityStringQueue.add("ABC");
        priorityStringQueue.add("Park");
        priorityStringQueue.add("bach");
        priorityStringQueue.add("Bach");
        priorityStringQueue.add("abc");

        List <String> DescendStringList = new ArrayList<>();

        while(!priorityStringQueue.isEmpty()){
            System.out.println(priorityStringQueue.peek());
            DescendStringList.add(priorityStringQueue.poll());
        }

        assertEquals("ABC", DescendStringList.get(4));
    }

    @Test
    void sortingQueueWoExtraTest() {
        Queue<Integer> intList = new LinkedList<>();
        intList.add(30);
        intList.add(15);
        intList.add(19);
        intList.add(45);
        intList.add(21);
        assertEquals(15, stackQ.sortingQueueWoExtra(intList).peek());
    }

    //using java stream: https://www.techiedelight.com/convert-list-integer-array-int/
    private int[] convertToIntArray(List<Integer> list){
        //int[] intArray = list.toArray(new Integer[0]); not working -->
        int [] intArray = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return intArray;
    }

    //using java stream: https://stackoverflow.com/questions/1073919/how-to-convert-int-into-listinteger-in-java//
    private List<Integer> convertToIntegerList(int [] intArray){
        //List<Integer> list = Arrays.asList(intArray);not working -->
        List<Integer> list = Arrays.stream(intArray).boxed().collect(Collectors.toList());
        return list;
    }



}