package genric;

import java.util.Collections;
import java.util.List;

public class VarargsSample {

    public static void main(String[] args){
        String item1 = "Apples";
        String item2 = "Banana";
        String item3 = "Chips";
        String[] shopList = {"Bread", "milk", "Yogurt", "Sausage"};
        printShoppingList(item1, item2, item3);
        printShoppingList(shopList);
        //in order to use Varags requires message
        printShoppingListDirect("Fish Sticks", "Potato Wedge", "ice Cream", "Browne", "Orange Juice");
        varargInta(100, 200, 300, 400);

        varargStrInt("Exercise",123, 456, 789, 012, 345);

        //Method Override
        //https://www.linkedin.com/learning/oracle-java-certification-3-methods-and-inheritance/arguments-and-return-values-of-methods?u=26281682
        int [] ary = {1, 2, 3, 4};
        printNum("Test_03", ary);
        printNum("Test_01", 1, 2, 3, 4);
        printNum("Test_02", new int[] {1, 2, 3, 4});
        //printArray("Test_04", {1, 2, 3, 4});


    }//End main

    private static void printShoppingList(String str1, String str2, String str3){
        System.out.println("Shopping List 1");
        System.out.println("1. " + str1);
        System.out.println("2. " + str2);
        System.out.println("3. " + str3);
        System.out.println();
    }

    private static void printShoppingList(String[] itemList){
        System.out.println("Shopping List 2");
        for(int i = 0; i < itemList.length; i++){
            System.out.println(i + 1 + ":" + itemList[i]);
        }
        System.out.println();
    }

    //Varargs  - A method that takes a variable number of arguments
    //each method only have one varargs parameter and the last parameter
    private static void printShoppingListDirect(String... items){
        System.out.println("Shopping List 3");
        for(int i = 0; i < items.length; i++){
            System.out.println(i + 1 + ":" + items[i]);
        }
        System.out.println();
    }
    /*https://www.geeksforgeeks.org/variable-arguments-varargs-in-java/

    */
    private static void varargInta(int... a){
        System.out.println("Number of arguments : " + a.length);
        for (int i : a){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void varargStrInt(String str, Integer... a){
        System.out.println("String : " + str);
        System.out.println("Number of Arguments is : " + a.length);
        for (int i : a){
            System.out.print(i + " ");
        }
        System.out.println();
    }




    /* https://www.baeldung.com/java-varargs
    Heap Pollution - every time we use varargs, the java compiler creates an array to hold the given parameters.
    When we use varargs with generic types, as there is a potential risk of a fatal runtime exception.
     */
    private static String firstOffFirst(List<String>... strings){
        List<Integer> ints = Collections.singletonList(42);
        Object[] objects = strings;
        objects[0] = ints;

        return  strings[0].get(0);//ClassCastException
    }


    /*
    Escape Varargs References
    private static <T> t[] returnAsIs(T a, T b){
        return toArray(a, b);
    }

    String[] args = returnAsIs("One", "Two");//ClassCastException
    to pass a and b to the toArray method, java needs to create an array
    since the Object[] can hold items of any type, the compiler creates one
    the toArray method returns the given Object[] to the caller
    Since the call site expects a String[], the compiler tries to cast the Object[] to the expected String[]
    hence the ClassCastException
     */

    /*
    Vararg safe usage - do not store anything in the implicitly created array.
    Don't let a reference to the generated array escape the method.
    if it is sure that the method itself does safely use the varargs, use @SafeVarargs to support the warning.
     */
    static void printNum(String label, int... data){
        System.out.print(label + " : ");
        for(int value : data){
            System.out.print(value);
        }
        System.out.println();

    }//end printArray

}
