package functionalWtStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArrayListConversionTest {
    static List<String> arrayName, streamName;

    /*
    https://www.baeldung.com/java-init-list-one-line
     */
    @BeforeEach
     void listinitialize(){
        arrayName = Arrays.asList("Miyei", "Yuna", "Ioan", "Mina", "Yeina");
        streamName = Stream.of("Miyei", "Yuna", "Ioan", "Mina", "Yeina")
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("a given name contained in the arraylist")
    void arrayListWithVaragTest(){
        //List<String> KidName = Arrays.asList("Miyei", "Yuna", "Ioan", "Mina", "Yeina");
        assertTrue(arrayName.contains("Yeina"));
    }

    //the list has fixed size
    @Test//(expected = UnsupportedOperationException.class)
    @DisplayName("a list with Arrays.asList can't be modified")
     void arrayListFixedsizeTest(){
        arrayName.add("Elaine");
        //assertThrows(UnsupportedOperationException.class, kidName.add("Elaine"));
    }

    //the original array and the list share the same reference to the object.
    @Test
    @DisplayName("original array and the list share same reference")
    void sharedReferenceObjects(){
        String[] names = {"Miyei", "Yuna"};
        List<String> oldKids = Arrays.asList(names);
        names[0] = "Ioan";
        assertEquals("Ioan", oldKids.get(0));
    }

    //conversion of an array to List with Stream doesn't guerentee mutability, serializability or thread safety of the return instance
    @Test
    @DisplayName("conversion of an array to List with stream is mutable")
    void mutabilityOfStreamListTest(){
        streamName.add("Elaine");
        assertTrue(streamName.contains("Elaine"));
    }

}