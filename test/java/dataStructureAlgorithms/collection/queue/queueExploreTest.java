package dataStructureAlgorithms.collection.queue;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class queueExploreTest {

    //https://www.baeldung.com/java-deque-vs-stack
    //https://www.baeldung.com/java-stack
    @Test
    void StackIterateFromBottomTest(){
        /*  the default capacity of Stack is 10.
        If the number of elements exceeds the total stack size, the capacity get doubled automatically.
        However, its size will never shrink after removing elements
         */
        Stack<String> tier = new Stack<>();
        //add element to Stack with add()
        tier.add("at the bottom");
        tier.push("at the middle");
        tier.addElement("at the top");

        List<String> tierList = Arrays.asList("at the North", "at the south", "at the west", "at the east");
        boolean addList = tier.addAll(tierList);

        Iterator<String> it = tier.iterator();
        //assertThat(it).toIterable().containsExactly();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        //we can access element by its index in Stack which break LIFO contract
        assertEquals("at the top", tier.get(2));
        //we can even insert and remove an element by its index
        tier.remove(5);
        assertEquals(6, tier.size());

        //retrieve element based on the index
        assertEquals("at the bottom", tier.get(0));
        assertEquals("at the east", tier.pop());

        //Stack can be searched for an element and get its distance from the top
        assertEquals(2, tier.search("at the North"));

        tier.add("at the bottom");
        tier.push("at the middle");
        tier.addElement("at the top");

        //since Stack is synchronized re iterating same iterator will throw ConcurrentModificationException
        Iterator<String> it2 = tier.iterator();
        System.out.println("------------ extend list-------------");
        while(it2.hasNext()) {
            System.out.println(it2.next());
        }
        //since Stack doesn't check duplicate element, lastIndexOf(element) would return location of the element most closest to the top of the stack
        assertEquals(6, tier.lastIndexOf("at the middle"));

        //indexOf(element) will return location of the element first found in the stack (bottom of the stack)
        assertEquals(0, tier.indexOf("at the bottom"));

    }

    @Test
    void removeStackElementWtFilterTest(){
        Stack <String> directStack = new Stack<>();
        List<String> directList = Arrays.asList("up", "down", "left", "right", "north", "south", "west", "east");
        directStack.addAll(directList);

        //we can delete element  a specific index from the top of the stack
        directStack.removeElementAt(4);
        assertEquals(-1, directStack.search("north"));

        directStack.removeIf(element -> element == "down");
        assertEquals(-1, directStack.search("down"));
    }

    @Test
    void stackIteratorTest(){
        /*
        Stack allows to use both iterator & listIterator
        the listIterator can traverse from both direction
         */
        Stack<Integer> intStack = new Stack<>();
        List<Integer> intList = Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19, 23);
        intStack.addAll(intList);

        ListIterator<Integer> listIt = intStack.listIterator();
        Stack<Integer> copyStack = new Stack<>();

        while(listIt.hasNext()){
            copyStack.push(listIt.next());
        }

        assertEquals(copyStack, intStack);

    }

    //9.STREAM API
    @Test
    void streamAPIStackTest(){
        Stack<Integer> intStack = new Stack<>();
        List<Integer> intList = Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19, 23);
        intStack.addAll(intList);

        List<Integer> filterdList = intStack.stream()
                .filter(element -> element <= 20)
                .collect(Collectors.toList());

        assertEquals(9, filterdList.size());
    }


}