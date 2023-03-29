package dataStructureAlgorithms.collection.map;

import dataStructureAlgorithms.collection.Guest;

import java.util.*;
import java.util.stream.Collectors;

public class MapExplore {
    //-------------- https://mkyong.com/java/how-to-sort-a-map-in-java/
    private Map<Integer, String> intToRoman;

    public static void main(String[] args) {

        Properties properties = System.getProperties();
        // not easy to sort this
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();

        LinkedHashMap<String, String> collect = entries.stream()
                //Map<String, String>
                .collect(Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        collect.forEach((k, v) -> System.out.println(k + ":" + v));


        MapExplore mapEx = new MapExplore();

        Map<Integer, String> ascendTreeMap = mapEx.sortIntToRomanAutoAscendTreeMap();
        System.out.println("------ 1 convert initial unordered hashmap to Tree map which by default sort ascending order!");
        printMap(ascendTreeMap);

        Map<Integer, String> descendTreeMap = mapEx.sortIntToRomanDescendingTreeMap();
        System.out.println("\n\n------2 convert initial unordered hashmap to Tree Map with descending order by compare o2 with o1!");
        printMap(descendTreeMap);

        Map<Integer, String> descendHashMap = mapEx.sortIntToRomanByKeyHashMap();
        System.out.println("\n\n------3 convert initial unordered hashmap to Hash Map with ascending order by Key");
        printMap(descendHashMap);

        Map<Integer, String> descendValueHashMap = mapEx.descendSortByValuesHashMap();
        System.out.println("\n\n------4 convert initial unordered hashmap to Hash Map with descended order by value");
        printMap(descendValueHashMap);

        Map<Integer, String> descendSortbyVauleLinkedhash =  mapEx.descentSortByVaueLinkedHash();
        System.out.println("\n\n------5 convert initial unordered hashmap to Linked Hash Map with descended order by value");
        printMap(descendSortbyVauleLinkedhash);

    }//end main method

    private void addUnsortedIntToRoman(){
        intToRoman = new HashMap<>();
        intToRoman.put(100, "C");
        intToRoman.put(9, "IX");
        intToRoman.put(10, "X");
        intToRoman.put(400, "CD");
        intToRoman.put(1, "I");
        intToRoman.put(4, "IV");
        intToRoman.put(5, "V");
        intToRoman.put(500, "D");
        intToRoman.put(900, "CM");
        intToRoman.put(50, "L");
        intToRoman.put(90, "XC");
        intToRoman.put(1000, "M");
        intToRoman.put(40, "XL");

        //intToRoman = new TreeMap<>(Comparator.reverseOrder());
    }

    private void addAscendSortedIntToRoman(){
        intToRoman = new HashMap<>();
        intToRoman.put(1, "I");
        intToRoman.put(4, "IV");
        intToRoman.put(5, "V");
        intToRoman.put(9, "IX");
        intToRoman.put(10, "X");
        intToRoman.put(40, "XL");
        intToRoman.put(50, "L");
        intToRoman.put(90, "XC");
        intToRoman.put(100, "C");
        intToRoman.put(400, "CD");
        intToRoman.put(500, "D");
        intToRoman.put(900, "CM");
        intToRoman.put(1000, "M");

    }

    /*
    Using treeMap all the map is ordered(ascending) by key value.
    this is very interesting with putAll(hashMap)
     */
    public Map<Integer, String> sortIntToRomanAutoAscendTreeMap(){

        addUnsortedIntToRoman();
        Map<Integer, String> treeSortInt = new TreeMap<>(intToRoman);
        return treeSortInt;

    }

    public Map<Integer, String> sortIntToRomanDescendingTreeMap(){
        addUnsortedIntToRoman();

        Map<Integer, String> treeSortDesc = new TreeMap<>(
                (Comparator<Integer>) (o1, o2) -> o2.compareTo(o1)
        );
        treeSortDesc.putAll(intToRoman);
        return treeSortDesc;
        /*
        Map<Integer, String> treeSortDescInt = new TreeMap<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2.compareTo(o1);
                    }
                }
        );
         treeSortDescInt.putAll(intToRoman);
        return treeSortDescInt;
         */

    }

    public Map<Integer, String> sortIntToRomanByKeyHashMap(){

        addUnsortedIntToRoman();

        //achive same result by
        //return intToRoman = new TreeMap<>(Comparator.reverseOrder());

        Map<Integer, String> sortedMap = intToRoman.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, newValue) -> old, LinkedHashMap::new));

        return sortedMap;
    }

    public Map<Integer, String> descendSortByValuesHashMap(){

        addAscendSortedIntToRoman();
        Map<Integer, String> valueDesceResult = intToRoman.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (o1, o2) -> o2, LinkedHashMap::new));
        return valueDesceResult;
    }

    public Map<Integer, String> descentSortByVaueLinkedHash(){
        addAscendSortedIntToRoman();
        Map<Integer, String> valueDescendLinkedHash = new LinkedHashMap<>();
        intToRoman.entrySet().stream()
                .sorted(Map.Entry.<Integer, String>comparingByValue().reversed())
                .forEachOrdered(x -> valueDescendLinkedHash.put(x.getKey(),x.getValue()));
        return valueDescendLinkedHash;
    }


    private static <K, V> void printMap(Map<K, V> map){

        for(Map.Entry<K, V> entry : map.entrySet()){
            System.out.print("key : " + entry.getKey() + ", Value : " + entry.getValue() + " / ");
        }

    }

    public String hashmapGetOrDefault(int i, Map<Integer, String> testMap){
        //06/02/2022
        //https://www.geeksforgeeks.org/hashmap-getordefaultkey-defaultvalue-method-in-java-with-examples/
        return testMap.getOrDefault(i, "not in the map");

    }

    public void mapEntryWithAbsMapSimpleEntry(){
        //https://www.baeldung.com/java-map-entry#2-usingmapentryset-instead
        Map.Entry<Long, Guest> tuple;
        tuple = new AbstractMap.SimpleEntry<>(1284735L, new Guest("Roger", "Browon", false));

        List<Map.Entry<Long, Guest>> tupleList = new ArrayList<>();
        tupleList.add(new AbstractMap.SimpleEntry<>(1238475L, new Guest("Jimmy","Cater", false)));
        tupleList.add(new AbstractMap.SimpleEntry<>(184575L, new Guest("Jone", "Miller", true)));

    }



}//end MapExplore class

