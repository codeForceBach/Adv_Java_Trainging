package dataStructureAlgorithms.collection.set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SetExploreTest {
     SetExplore setTest = new SetExplore();

    @Test
    void streamFilterDiffTest() {
        Set<Integer> exa = new HashSet<>();
        exa.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0}));

        Set<Integer> exb = new HashSet<>();
        exb.addAll(Arrays.asList(new Integer [] {1, 3, 7, 5, 4, 0, 7, 5}));

        assertTrue(setTest.difference(exa, exb).equals(setTest.streamFilterDiff(exa, exb)));
    }

    @Test
    public void hashSetImplemenTest(){
        BRHashSet testSet = new BRHashSet();
        testSet.add(2);
        testSet.remove(5);
        //assertTrue(testSet.contains(2));
        assertFalse(testSet.contains(5));
    }
}