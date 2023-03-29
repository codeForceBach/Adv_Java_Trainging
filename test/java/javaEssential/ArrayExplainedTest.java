package javaEssential;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayExplainedTest {

    @Test
    void ArraySameRefereneceCompareTest(){
        //https://www.baeldung.com/java-comparing-arrays
        int[] intTree = {6, 4, 8, 3, 5, 7, 9, 13, 11, 2, 17, 15, 19};
        int[] copyTree = intTree;
        assertTrue(intTree == copyTree);
        assertTrue(intTree.equals(copyTree));

        int value = 14;
        intTree[1] = value;
        assertTrue(intTree.equals(copyTree));
        assertTrue(value==copyTree[1]);


    }
    @Test
    void arrayDifferentObjectCompareTest(){
        String[] planes1 = new String[] { "A320", "B738", "A321", "A319", "B77W", "B737", "A333", "A332" };
        String[] planes2 = new String[] { "A320", "B738", "A321", "A319", new String("B77W"), "B737", "A333", "A332" };
        assertFalse(planes1 == planes2);
        assertFalse(planes1.equals(planes2));
        //https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-assertions-with-junit-5-api/
        assertArrayEquals(planes1, planes2);

        assertTrue(Arrays.equals(planes1, planes2));


        assertTrue(planes1[3].equals(planes2[3]));//this case comparing value of two different String return true even though each string is different object reference
        assertTrue(planes1[3] == planes2[3]);//this compare two String literal object. so it points to same object
        assertTrue(planes1[4].equals(planes2[4]));
        assertFalse(planes1[4] == planes2[4]);//this compares two String but different object one with literal, and the other is String object creation

        String b77 = "B77W";
        String b772 = "B77W";
        String b77n = new String("B77W");

        assertTrue(b77.equals(b772));//equals() inherited from object and compare two String character by character  ignore their address - means content (value) compare
        assertTrue(b77.equals(b77n));
        assertTrue(b77 == b772);//these two variable are point to same String literal
        assertFalse(b77 == b77n);//these two variable arr point to different object thus has different reference

        /*
        compareTo() return an int type value.
        It compares two Strings character by character lexicographically
         */
        assertEquals(0, b77.compareTo(b77n));
    }

    @Test
    void arrayDeepEqualsTest(){
        //2.3. Comparing Arrays with Arrays.equals - check if two arrays are equals in terms of their contents
        //it will iterate through the arrays per position in parallel and apply equal(==) operator for every pair of element.
        //https://www.geeksforgeeks.org/compare-two-arrays-java/
        //https://www.baeldung.com/java-compare-strings

    }

    /*
    https://www.baeldung.com/java-comparing-arrays
    https://www.baeldung.com/java-arrays-deepequals
    https://www.baeldung.com/java-util-arrays
     */

    @Test
    void arrayCopyTest(){
        String[] intro = new String[]{"Once", "upon", "a", "time"};
        String[] copyRangeIntro = Arrays.copyOfRange(intro, 0, 3);
        //String[] shortIntro = new String[] {"Once", "upon", "a"};
        assertTrue(Arrays.equals(new String[] {"Once", "upon", "a"}, copyRangeIntro));
        assertArrayEquals(new String[] {"Once", "upon", "a"}, copyRangeIntro);
        assertFalse(new String[] {"Once", "upon", "a"}.equals(copyRangeIntro));//I would think the equals() method compare each element in two array so that it return true??
        assertNotEquals(new String[] {"Once", "upon", "a"}, copyRangeIntro);//compare object's reference equality??

        String[] copyOfIntro = Arrays.copyOf(intro, 3);
    }
    //https://www.petrikainulainen.net/programming/testing/junit-5-tutorial-writing-assertions-with-junit-5-api/

}
