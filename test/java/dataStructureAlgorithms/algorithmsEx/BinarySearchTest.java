package dataStructureAlgorithms.algorithmsEx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    BinarySearch biSearch = new BinarySearch();
    @Test
    void searchRotatedSortArrayTest() {
        int nums[] = {6, 7, 8, 9, 11, 13, 14, 16, 17, 0, 2, 4, 5};
        assertEquals(3, biSearch.searchRotatedSortArray(nums, 9));
    }

    @Test
    void searchMatrix() {
        int numMatrix [][] = {{1,3,5,7}, {10,11,16,20}, {23,30,34,60}};
        int numMatrixL [][] = {{1,3,5,7,9,10}, {11,12,14,16,17,20}, {23,24,26,30,33,60}};
        assertTrue(biSearch.searchMatrix(numMatrix, 3));
        assertFalse(biSearch.searchMatrix(numMatrix, 99));
        assertTrue(biSearch.searchMatrix(numMatrixL, 60));
    }

    @Test
    void searchMatrixCondense() {
        int numMatrixL [][] = {{1,3,5,7,9,10, 11, 12,14,16,17}, {20,23,24,26,30,33,35, 38, 39, 40,42}, {43,44,46,47,49, 51, 52, 55, 56, 58,59},{61, 63, 64, 65, 67, 69, 70, 71,72, 74, 75}, {76, 77, 78,79, 80, 81, 82, 83, 84, 85, 86}};
        assertTrue(biSearch.searchMatrixCondense(numMatrixL, 61));
    }

    @Test
    void minEatingSpeedTest() {
        int[] pile = {3,6,7,11};
        assertEquals(4, biSearch.minEatingSpeed(pile, 8));
    }

    @Test
    void minRotatedSortedArrayTest() {
        int [] minTest = {4,5,6,7,0,1,2};
        assertEquals(0,biSearch.minRotatedSortedArray(minTest));
        int [] minNums = {4,5,6,7,9, 10, 11, 14, 16, 17, 18,20,1,2};
        assertEquals(1, biSearch.minRotatedSortedArray(minNums));
    }
}