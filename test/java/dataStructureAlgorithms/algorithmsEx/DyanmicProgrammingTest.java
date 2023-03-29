package dataStructureAlgorithms.algorithmsEx;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DyanmicProgrammingTest {
    DyanmicProgramming dpTests = new DyanmicProgramming();

    @Test
    void climbStairsTest() {
    }

    @Test
    void minCostClimbStairsTest() {
        int [] cost = {1,100,1,1,1,100,1,1,100,1};
        assertEquals(6, dpTests.minCostClimbStairs(cost));
    }

    @Test
    void climbStairs() {
        assertEquals(8, dpTests.ClimbStairs(5));
    }

    @Test
    void robTest() {
        int [] rob = {1, 2, 3, 1, 1, 100};
        int [] rob2 = {2,7,9,3,1};
        int [] robMin = {102, 2};
        int [] one = {3};
        int [] empty = null;
        //assertEquals(104, dpTests.rob(rob));
        //assertEquals(12, dpTests.rob(rob2));
        assertEquals(102, dpTests.rob(robMin));
        assertEquals(3, dpTests.rob(one));
        assertEquals(0, dpTests.rob(empty));
    }
}