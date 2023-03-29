package dataStructureAlgorithms.algorithmsEx;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayHashAlgorithmsTest {
    ArrayHashAlgorithms arrayAlgo = new ArrayHashAlgorithms();

    @Test
    void removeTripletandBeyondTest() {
        int[] fiveUniqueTen = {0, 1, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5};
        assertEquals(9, arrayAlgo.removeTripletandBeyond(fiveUniqueTen));
    }


    @Test
    void removeDuplicatesTest() {
        int[] fiveUnique = {0, 0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 5};
        assertEquals(5, arrayAlgo.removeDuplicates(fiveUnique));
    }

    @Test
    void generatePascalTrialgleTest() {
        List<List<Integer>> pascal12 = arrayAlgo.generatePascalTrialgle(12);
        assertEquals(12, pascal12.size());
        assertEquals(6, pascal12.get(4).get(2));

    }

    @Test
    void pascalTriangleRowII() {
        List<Integer> indexTriangle = arrayAlgo.pascalTriangleRowII(7);
        assertEquals(8, indexTriangle.size());
        assertEquals(35, indexTriangle.get(4));
    }

    @Test
    void rotatedSortArraySearch() {
        int[]nums = {7, 8, 9, 10, 11, 13, 15, 17, 18,0,1,2, 4,5,6};
        assertEquals(4, arrayAlgo.rotatedSortArraySearch(nums, 0));
    }

    @Test
    void topKFrequentTest() {
        int [] nums = {3, 5, 7, 2, 6, 2, 5, 3, 9, 1, 3, 7, 3, 4, 5, 6, 1, 7, 9, 3};
        int [] result = arrayAlgo.topKFrequent(nums, 4);
        assertEquals(3, result[0]);

    }

    @Test
    void isValidSudokuTest() {
        char [][] invalid =
                {{'8','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};
        char [][] valid =
                {{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};

        //assertTrue(arrayAlgo.isValidSudoku(valid));
        assertFalse(arrayAlgo.isValidSudoku(invalid));
    }

    @Test
    void longestConsecutiveTest() {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums2 = {100, 4, 200, 1, 3, 2};
        int[] nuNums = {0, -1};
        int[] nums4 ={1,2,0,1};
        assertEquals(9, arrayAlgo.longestConsecutive(nums));
        assertEquals(4, arrayAlgo.longestConsecutive(nums2));
        assertEquals(2, arrayAlgo.longestConsecutive(nuNums));
        assertEquals(3, arrayAlgo.longestConsecutive(nums4));
    }

    @Test
    void logestConsecutiveSetTest() {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        assertEquals(9, arrayAlgo.longestConsecutiveSet(nums));
        int[] nums2 = {100, 4, 200, 1, 3, 2};
        assertEquals(4, arrayAlgo.longestConsecutiveSet(nums2));
        int[] nuNums = {0, -1};
        assertEquals(2, arrayAlgo.longestConsecutiveSet(nuNums));
        int[] nums4 ={1,2,0,1};
        assertEquals(3, arrayAlgo.longestConsecutiveSet(nums4));
    }

    @Test
    void longestConsecutiveMapTest() {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        assertEquals(9, arrayAlgo.longestConsecutiveMap(nums));
    }

    @Test
    void productExceptSelfTest() {
        int[] prodNum = {1, 2, 3, 4};
        //int[] result = arrayAlgo.productExceptSelf(prodNum);
        //assertEquals(24, result[0]);
        int [] numsWZero = {-1,1,0,-3,3};
        int[] answer = arrayAlgo.productExceptSelf(numsWZero);
        assertEquals(9, answer[2]);
    }

    @Test
    void encodeStringTest() {
        List<String> words = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
        String combine = "12*Buenos Aires7*Córdoba8*La Plata";
        //assertEquals(combine, arrayAlgo.encodeString(words));
        assertEquals("Buenos Aires", arrayAlgo.decodeString(combine).get(1));
    }

    @Test
    void containsNearByDuplicateSlideTest() {
        int[] num = {1,2,3,1,2,3};
        assertFalse(arrayAlgo.containsNearByDuplicateSlide(num, 2));
    }

    @Test
    void containNearByDuplicateMapTest() {
        int [] nums = {1, 3, 5, 6, 8, 9, 1, 2, 4, 5, 7};
        int [] numsT = {1, 3, 5, 6, 7, 9, 8, 2, 4, 1, 3, 7};
        assertFalse(arrayAlgo.containNearByDuplicateMap(nums, 2));
        assertTrue(arrayAlgo.containsNearByDuplicateSlide(numsT, 7));
    }

    @Test
    void isAnagramTest() {
        String s = "anagram";
        String t = "nagaram";
        assertTrue(arrayAlgo.isAnagram(s, t));
    }

    @Test
    void findAnagramsTest() {
        String s = "cbaebabacd", p = "abc";
        String t = "abab", z = "ab";
        List<Integer> result = arrayAlgo.findAnagrams(s, p);
        assertEquals(2, result.size());
        //List<Integer>resultTz = arrayAlgo.findAnagrams(t, z);
        //assertEquals(3, resultTz.size());
    }
}