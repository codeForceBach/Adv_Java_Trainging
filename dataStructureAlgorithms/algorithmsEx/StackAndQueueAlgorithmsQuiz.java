package dataStructureAlgorithms.algorithmsEx;

import dataStructureAlgorithms.collection.TreeNode;
import java.util.*;

/*
https://www.baeldung.com/java-depth-first-search
https://www.baeldung.com/java-breadth-first-search
 */
public class StackAndQueueAlgorithmsQuiz {

    public static void main(String[] args) {

    }

    public List<Integer> inorderTraversalStack(TreeNode root){
        /*
        94. Binary Tree Inorder Traversal - despite the name of method "in- Order" this is pre-order
        as it first read root and left and right sub tree.
        "in- order" should be read left frist and root and right sub tree.
        https://leetcode.com/problems/binary-tree-inorder-traversal/discuss/31213/Iterative-solution-in-Java-simple-and-readable
         */
        List<Integer> inOrderList = new ArrayList<>();
        Stack <TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null|| !stack.empty()){
            while(curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            inOrderList.add(curr.value);
            curr = curr.right;
        }
        return inOrderList;
    }

    public boolean isValidParentheses(String s) {
        /*20. Valid Parentheses
            Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

               An input string is valid if:
               Open brackets must be closed by the same type of brackets.
               Open brackets must be closed in the correct order.
               Every close bracket has a corresponding open bracket of the same type.
          https://leetcode.com/problems/valid-parentheses/discuss/2577162/Java91-Stack-Solution-with-Beginner-Friendly-Explained
         */
        //initialize a Stack
        Stack<Character> parenC = new Stack<>();
        //iterate over input String as character
        for (int i = 0; i < s.length(); i++) {

            //if the character is one of opening character, add to Stack
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                parenC.push(s.charAt(i));
            } else {
                //else if the stack is empty(which means there is already some opening character to match) or character in stack is not a coresponding character, return false
                if (s.charAt(i) == ')') {
                    if (parenC.isEmpty() || parenC.pop() != '(') {
                        return false;
                    }
                }
                if (s.charAt(i) == '}') {
                    if (parenC.isEmpty() || parenC.pop() != '{') {
                        return false;
                    }
                }
                if (s.charAt(i) == ']') {
                    if (parenC.isEmpty() || parenC.pop() != '[') {
                        return false;
                    }
                }
            }

        }
        //at the end simply return whether the Stack is empty - if all the characters valid the Stack should be empty.

        return parenC.isEmpty();
    }

    public List<String> generateParentheses(int n) {
        /*
        22. Generate Parentheses - https://leetcode.com/problems/generate-parentheses/
        Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
            Example 1:
            Input: n = 3
            Output: ["((()))","(()())","(())()","()(())","()()()"]

            Example 2:
            Input: n = 1
            Output: ["()"]
         */

        // https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
        List<String> parentheses = new ArrayList<>();
        listBackTrack(parentheses, "", 0, 0, n);
        return parentheses;
    }

    //This is quite confusing to understand with recursive call (need more study - back tracking).
    private void listBackTrack(List<String> parentheses, String str, int open, int close, int n) {
        if (str.length() == n * 2) {
            parentheses.add(str);
            return;
        }
        if (open < n) {
            listBackTrack(parentheses, str + "(", open + 1, close, n);
        }
        if (open > close) {
            listBackTrack(parentheses, str + ")", open, close + 1, n);
        }
    }

    public List<String> letterCombinations(String digit) {
        /*
        17. Letter Combinations of a Phone Number - https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
        Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
        Return the answer in any order.
        A mapping of digits to letters (just like on the telephone buttons) is given below.
        Note that 1 does not map to any letters.

           Example 1:
            Input: digits = "23"
            Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

            Example 2:
            Input: digits = ""
            Output: []

            Example 3:
            Input: digits = "2"
            Output: ["a","b","c"]
         */
        List<String> result = new ArrayList<>();
        return result;

    }

    public int[] dailyTemperatures(int[] temperatures) {
        /*739. Daily Temperaturetures - https://leetcode.com/problems/daily-temperatures/
        Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
        If there is no future day for which this is possible, keep answer[i] == 0 instead.

            Example 1:
            Input: temperatures = [73,74,75,71,69,72,76,73]
            Output: [1,1,4,2,1,1,0,0]

            Example 2:
            Input: temperatures = [30,40,50,60]
            Output: [1,1,1,0]

            Example 3:
            Input: temperatures = [30,60,90]
            Output: [1,1,0]
         */

        //https://leetcode.com/problems/daily-temperatures/discuss/109862/O(n)-Java-Stack
        //https://leetcode.com/problems/daily-temperatures/discuss/1478040/Java%3A-monotonic-increasing-stack
        int[] tempLog = new int[temperatures.length];

        //stack hold index of temperature element from array.
        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < temperatures.length; i++){
            //if current temperature in the array is bigger than top of the stack (which the stack is not empty also),
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                //new higher temperature found, so remove the last index of temperate from stack
                int index = stack.pop();
                //add difference between current index of the temperature and index of the top of the stack
                tempLog[index] = i - index;
            }
            //if the current stack is empty or current temperature is less than temperature in stack, push current index of temperature to stack
            stack.push(i);
        }
        return tempLog;
    }

    public int carFleet(int target, int[] position, int[] speed){
        /*
        853. Car Fleet - https://leetcode.com/problems/car-fleet/
        There are n cars going to the same destination along a one-lane road. The destination is target miles away.

        You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).
        A car can never pass another car ahead of it, but it can catch up to it and drive bumper to bumper at the same speed.
        The faster car will slow down to match the slower car's speed.
        The distance between these two cars is ignored (i.e., they are assumed to have the same position).
        A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.
        If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
        Return the number of car fleets that will arrive at the destination.
         */

        /*
        Example 1:
        Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
        Output: 3
        Explanation:
        The cars starting at 10 (speed 2) and 8 (speed 4) become a fleet, meeting each other at 12.
        The car starting at 0 does not catch up to any other car, so it is a fleet by itself.
        The cars starting at 5 (speed 1) and 3 (speed 3) become a fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.
        Note that no other cars meet these fleets before the destination, so the answer is 3.

        Example 2:
        Input: target = 10, position = [3], speed = [3]
        Output: 1
        Explanation: There is only one car, hence there is only one fleet.

        Example 3:
        Input: target = 100, position = [0,2,4], speed = [4,2,1]
        Output: 1
        Explanation:
        The cars starting at 0 (speed 4) and 2 (speed 2) become a fleet, meeting each other at 4. The fleet moves at speed 2.
        Then, the fleet (speed 2) and the car starting at 4 (speed 1) become one fleet, meeting each other at 6. The fleet moves at speed 1 until it reaches target.


        Constraints:
        n == position.length == speed.length
        1 <= n <= 105
        0 < target <= 106
        0 <= position[i] < target
        All the values of position are unique.
        0 < speed[i] <= 106
         */

        //https://leetcode.com/problems/car-fleet/discuss/2418669/Java-simple-faster-than-98
        //iterate through the array in sorted order (reverse order)?
        //calculate the time each object reach the target time = (Target - position) / speed

    return 0;
    }

    public int[] nextGeneratorElement (int [] num1, int[] num2){
        /*
        496. Next Greater Element I - https://leetcode.com/problems/next-greater-element-i/description/
        The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
        You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
        For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
        If there is no next greater element, then the answer for this query is -1.
        Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.

            Example 1:
            Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
            Output: [-1,3,-1]
            Explanation: The next greater element for each value of nums1 is as follows:
            - 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.
            - 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
            - 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so the answer is -1.

            Example 2:
            Input: nums1 = [2,4], nums2 = [1,2,3,4]
            Output: [3,-1]
            Explanation: The next greater element for each value of nums1 is as follows:
            - 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
            - 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so the answer is -1.

            Constraints:
            1 <= nums1.length <= nums2.length <= 1000
            0 <= nums1[i], nums2[i] <= 104
            All integers in nums1 and nums2 are unique.
            All the integers of nums1 also appear in nums2.

            Follow up: Could you find an O(nums1.length + nums2.length) solution?
         */
        int[] answer = new int[num1.length];
       Stack <Integer> intStack = new Stack<>();
       HashMap<Integer, Integer> intHashM = new HashMap<>();
       //find out all the next greater elements in num2 array
       for(int n : num2){
           while(!intStack.isEmpty() && n > intStack.peek()){
               intHashM.put(intStack.pop(), n);
           }
           intStack.add(n);
       }
       int i = 0;
       for(int num : num1){
           answer[i++]= intHashM.getOrDefault(num, -1);
       }
        return answer;

        //https://leetcode.com/problems/next-greater-element-i/discuss/2618900/Easy-Java-Solution-or-Map-Stack-O(n)
        //https://leetcode.com/problems/next-greater-element-i/discuss/2432504/JAVA-optimised-O(n)-solution
        //https://leetcode.com/problems/next-greater-element-i/discuss/1579935/Java-easy-solution-oror-Brute-and-optimal-oror-Stack-oror-Diagrammatic-explanation
    }

    public boolean validStackSequence(int[] pushed, int[]popped){
    /*
    946. Validate Stack Sequences - https://leetcode.com/problems/validate-stack-sequences/
    Given two integer arrays pushed and popped each with distinct values,
    return true if this could have been the result of a sequence of push and pop operations on an initially empty stack, or false otherwise.
    https://leetcode.com/problems/validate-stack-sequences/discuss/1063703/JAVA-STACK-EXTREMELY-EASY
     */
        //initialize stack, integer count index
        Stack <Integer> numStack = new Stack<>();
        int index = 0;
        //iterate over pushed array and push each value to stack
        for(int i : pushed){
            numStack.push(i);
            //as long as the stack is not empty and if current value in stack is equal to popped array index value...
            while(!numStack.empty() && numStack.peek() == popped[index]){
                //pop the value from stack and increment index
                numStack.pop();
                index++;
            }
            //return whether the stack is empty or not.
        }
        return numStack.empty();


    }

    //https://www.geeksforgeeks.org/sorting-queue-without-extra-space/
    public Queue<Integer> sortingQueueWoExtra(Queue<Integer> queueList){
        Queue <Integer> sortedQueue = queueList;
        for(int i = 1; i <= sortedQueue.size(); i++){
            //each iteration pass the queue with size of un sorted element to find next minimum value
            int min_index = minIndex(sortedQueue, sortedQueue.size()-i);
            insertMinAtTheEnd(sortedQueue, min_index);
        }
        return sortedQueue;
    }

    /*
    iterate through the queue and find matching index of min_value index
    if the index of element is same as parameter "min_value" pull and hold the value and store back at the end of iteration
     */
    private void insertMinAtTheEnd(Queue<Integer> sortedQueue, int min_index) {
        int min_value = 0;

        for(int i = 0; i <= sortedQueue.size(); i++){
            int current = sortedQueue.peek();
            sortedQueue.poll();
            //if the index is not equals to min_index put the value back to the queue to cycle back
            if(i != min_index){

                sortedQueue.add(current);
            } else {
                //if the index is matches with min_index, save the current value as minimum value adn wait until the end of iteartion
                min_value = current;
            }
        }
        //put the minimum value at the end of the queue in the order.
        sortedQueue.add(min_value);
    }

    /*
    this method iterate through entire queue to pull each element and  push each element back to queue to find minimum index
     */
    private int minIndex(Queue<Integer> queueList, int sortIndex) {

        int min_index = -1;//initialize bogus min_index
        int min_value = Integer.MAX_VALUE;// -2147483647 - initialize bogus min_value to compare value in the queue

        //examine each element to see if the value is the minimum.
        for(int j = 0; j < queueList.size(); j++){

            int current = queueList.peek();//peek at value at the top of the queue and store the value as current
            queueList.poll();

            //if the current value is minimum and the index of the value is not greater than already sorted value's index, re assgin index of current value as min_index
            if(current <= min_value && j <= sortIndex){
                min_index = j;
                min_value = current;
            }//end if
            queueList.add(current);
        }//end for loop
        return min_index;
    }

}

class IntegerDescendCompartor implements Comparator<Integer>{
    //https://www.freecodecamp.org/news/priority-queue-implementation-in-java/
    /*
    in order to implement custom ordering of Priority queue, create a comparator class  and implement Comparator
     */
    @Override
    public int compare(Integer o1, Integer o2) {
        //the result of the priorityQueue is in descending order.
        return o1 < o2 ? 1 : -1;
    }

}


class StringDescendCompartor implements Comparator<String>{
    //https://www.freecodecamp.org/news/priority-queue-implementation-in-java/
    /*
    in order to implement custom ordering of Priority queue, create a comparator class  and implement Comparator
     */
    @Override
    public int compare(String s1, String s2) {
        //the result of the priorityQueue is in descending order.
        //https://www.geeksforgeeks.org/compare-two-strings-in-java/
        if(s1.compareTo(s2) > 0){
            return -1;
        } else if (s1.compareTo(s2) < 0){
            return 1;
        } else {
            return 0;
        }
    }
}


