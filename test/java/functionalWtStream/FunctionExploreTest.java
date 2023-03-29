package functionalWtStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

class FunctionExploreTest {

    FunctionExplore functionEx = new FunctionExplore();
    List<String> nameList = Arrays.asList("Miyei", "Yuna", "Ioan", "Mina", "Yeina");

    @Test
    @DisplayName("Test simple function as argument")
    void convertListToMapTest() {
        Map<String, Integer> convertMap = functionEx.convertListToMap(nameList, functionEx::doubleStringLength);
        assertNotNull(convertMap);
        assertEquals(10, convertMap.get("Miyei"));
    }
/*
    @Test
    @DisplayName("Tests String list to Sha256.")
    void convert256ShaTest(){
        List<String> sha256List = functionEx.convertSha256(nameList, functionEx::sha256);
        assertNotNull(sha256List);
            for(String s: sha256List){
            System.out.println(s);
        }
        assertEquals("1eaeb84268e7cf8f41f8e4c8e8bb606fdda587e6c66a8960b96346cadca1c82b", sha256List.get(0));
    }


    @Test
    @DisplayName("Testing String list of sha256 Conversion value.")
    void sha256NameMapTest(){
        Map<String, String> sha256Namelist = functionEx.sha256NameMap(nameList, functionEx::sha256);
        assertNotNull(sha256Namelist);
        assertTrue(sha256Namelist.containsKey("Yeina"));
        assertEquals("22a058fb690a395e2dd4148e8e6cd5094b6bfa949037f31eaae63d31b0914454", sha256Namelist.get("Ioan"));

        Iterator mapIterator = sha256Namelist.entrySet().iterator();
        while(mapIterator.hasNext()){
            Map.Entry entry = (Map.Entry) mapIterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

 */

    //https://mkyong.com/java8/java-8-bifunction-examples/
    @Test
    @DisplayName("Testing BiFunction Syntax")
    void BiFunctionSyntaxTests(){
        //define biFunction
        BiFunction<Integer, Integer, Integer> addFunc = (t, r) -> t + r;
        assertEquals(5, addFunc.apply(2, 3));
        BiFunction<Integer, Integer, Double> powFunc = (t, r) -> Math.pow(t, r);
        assertEquals(8, powFunc.apply(2, 3));
        BiFunction<Integer, Integer, List<String>> listFunc = (t, r) -> Arrays.asList("t", "r");
        assertEquals(2, listFunc.apply(2, 4).size());
    }

    @Test
    @DisplayName("Testing BiFunction andThen")
    void BiFunctionAndTnen(){
        BiFunction<Integer, Integer, Integer> multiFunc = (i, j) -> i * j;
        Function<Integer, String> convertStr = (t) -> String.valueOf(t);
        assertEquals("30", multiFunc.andThen(convertStr).apply(5, 6));
        //call a defined method of function and bifunctioin
        String result = functionEx.powerToString(5, 6, (i, j) -> Integer.valueOf(i * j), (r) -> String.valueOf(r) );
        assertEquals(result, multiFunc.andThen(convertStr).apply(5, 6));
    }

    @Test
    @DisplayName("Testing BiFunction and then as generic method call")
    void GenericBiFunctionMethodTest(){
        /*
        public <A1, A2, R1, R2> R2 convertValue(A1 a1, A2 a2, BiFunction<A1, A2, R1> biFunc, Function<R1, R2> func){
        return biFunc.andThen(func).apply(a1, a2);
        }
        it provides unlimited flexibility based on how to define function and biFunction of return type as lambda expression
         */
        String powerString = functionEx.convertValue( 2, 3, (a1, a2) -> Math.pow(a1, a2), (r) -> String.valueOf(r));
        assertEquals("8.0", powerString);

        Double multipleString = functionEx.convertValue(5, 6, (i, j)-> Double.valueOf(i * j), (r) -> Math.pow(r, 2));
        assertEquals(Double.valueOf(900.0), multipleString);

        String appendString = functionEx.convertValue("Byung", "Ryang", (s1, s2)-> s1 + "-" + s2, (r) -> "Park, " + r);
        assertEquals("Park, Byung-Ryang", appendString);
    }


    @Test
    void filterListTest() {
        List<String> holiday = Arrays.asList("Ester", "Hanukkah", "NewYear", "Christmas", "Thanksgiving");
        //return new list after filtered by a method reference
        List<String> lengthHoliday = functionEx.filterList(holiday, 7, functionEx::filterByLength);
        assertEquals(3, lengthHoliday.size());

        //return new list after filterd by a bifunction as lambda expression
        List<String> filterHoliday = functionEx.filterList(holiday, 7, (hDay, size) ->{
            if(hDay.length() > size){
                return hDay;
            }else{
                return null;
            }
        });
        assertEquals(lengthHoliday.size(), filterHoliday.size());

        List<Integer> number = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> evenNum = functionEx.filterList(number, 6, (num, condition) -> {
            Integer reSetNo = num;
            if(num < condition){
                reSetNo += num;
                return reSetNo;
            }else{
                return null;
            }
        });
        assertEquals(8, evenNum.get(3));
        System.out.println(evenNum);
    }
}