package functionalWtStream;

//import org.apache.commons.codec.digest.DigestUtils;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExplore {
    /*
    Function examples
     */
    public static void main(String[] args) {

        //this function defined to take String as argument and return length of the String as Integer
        Function<String, Integer> func = x-> x.length();
        Integer stringSize = func.apply("java functional Interface");
        System.out.println(stringSize);

        //function can be chained together
        Function<Integer, Integer> func2 = x -> x * 2;
        Integer doubleStringSize = func.andThen(func2).apply("java functional Interface");
        System.out.println(doubleStringSize);


    }// end main method


    //https://mkyong.com/java8/java-8-function-examples/
    /*
    this method accept function as part of argument
     */
    public<T, R> Map<T, R> convertListToMap(List<T> list, Function<T, R> func){
        Map<T, R> convertMap = new HashMap<>();
        for(T t : list){
            convertMap.put(t, func.apply(t));
        }
        return convertMap;
    }//end convertListToMap

    public <T, R> List<R> convertSha256(List<T> shaList, Function<T, R> func){
        List<R> sha256List = new ArrayList<>();
        Map<T, R> sha256Map = new HashMap<>();

        for(T t : shaList){
            sha256List.add(func.apply(t));
            sha256Map.put(t, func.apply(t));
        }

        return sha256List;
    }//end convertSha256

    public <T, R> Map<T, R> sha256NameMap(List<T> shaList, Function<T, R> func){
        Map<T, R> sha256Map = new HashMap<>();
        for(T t : shaList){
            sha256Map.put(t, func.apply(t));
        }
        return sha256Map;
    }//end sha256NameMap

    public Integer getLength(String s){
        return s.length();
    }//end getLength

    public Integer doubleStringLength(String s){
        return s.length() * 2;
    }//end doubleStringLength

    /*public String sha256(String s){
        return DigestUtils.sha256Hex(s);
    }

     */

    public String filterByLength(String s, Integer size){
        if(s.length() > size){
            return s;
        } else {
            return null;
        }
    }

    //https://mkyong.com/java8/java-8-bifunction-examples/
    /*
    2.2 converts each individual functions to a method that accept BiFunction and Function as arguments and chains it together.
     */
    public <R> R powerToString(Integer i1, Integer i2, BiFunction<Integer, Integer, Integer> biFunc, Function<Integer, R> func){
        return biFunc.andThen(func).apply(i1, i2);
    }

    /*
    the method can be turn into a generic method that accept different function and bifuction
     */
    public <A1, A2, R1, R2> R2 convertValue(A1 a1, A2 a2, BiFunction<A1, A2, R1> biFunc, Function<R1, R2> func){
        return biFunc.andThen(func).apply(a1, a2);
    }

    /*
    3.1 bifunction as Method reference call to create an object acts as a factory pattern
    by passing various method as function each filterList object return unique list suite the filter (conditon) in the function.
     */
    public <T, U, R> List<R> filterList(List<T> list, U condition, BiFunction<T, U, R> func){
        List<R> resultList = new ArrayList<>();
        for(T t: list){
            R apply = func.apply(t, condition);
            if(apply != null){
                resultList.add(apply);
            }
        }//end for
        return resultList;
    }//end filterList with BiFunction


}
