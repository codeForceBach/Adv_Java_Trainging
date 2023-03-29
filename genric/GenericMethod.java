package genric;

import java.util.ArrayList;
import java.util.List;

public class GenericMethod {

    static Character[] charArray = {'h', 'e', 'i', 'o', 'u'};
    static Integer[] intArray = {1, 2, 3, 5, 8, 13};
    static Boolean[] boolArray = {true, false, false};

    public static List arrayToList (Object [] array, List<Object> list) {
        for (Object object : array) {
            list.add(object);
        }//end for
        return list;
    }

    /*To prevent unexpected runtime error, the solution is to make the array to list method a generic method*/
    public static<T> List<T> arrayToListDefine (T[] array, List<T> list) {
        for (T object : array) {
            list.add(object);
        }//end for
        return list;
    }

     public static void main(String[] args) {
            List <Character> charList = arrayToList(charArray, new ArrayList<>());
            List <Boolean> booleanList = arrayToList(boolArray, new ArrayList<>());
            List <String> stringList = arrayToList(intArray, new ArrayList<>());

            /* when the type of list is not correct, it doesn't cause compile error*/
            System.out.println(stringList.get (0));

            List <Integer> intList = arrayToListDefine(intArray, new ArrayList<>());

    }



}
