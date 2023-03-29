package dataStructureAlgorithms.collection.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MapExploreTest {

    MapExplore map = new MapExplore();

    @Test
    void hashmapGetOrDefaultTest() {
        Map<Integer, String> testM = new HashMap<>();
        testM.put(1, "String");
        testM.put(2, "Map");
        testM.put(3, "Set");
        testM.put(5, "in the map");
        assertEquals("not in the map", map.hashmapGetOrDefault(4, testM));
        assertEquals("String", map.hashmapGetOrDefault(1, testM));
    }
}