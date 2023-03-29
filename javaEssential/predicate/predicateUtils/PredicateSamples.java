package javaEssential.predicate.predicateUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//https://www.educative.io/edpresso/what-is-a-java-predicate

public class PredicateSamples {

    public void predicateGreaterThan(int in){
        Predicate<Integer> greater_than = x -> (x > 10 );
        System.out.println("is the " + in + " greater than 10? : " + greater_than.test(in));
    }


    public void predIsEquals(String input, String value){

        Predicate<String> predEq = Predicate.isEqual(input);
        System.out.println("is \"" + value + "\" equals to \"" + input + "\" ? : " + predEq.test(value));

    }

    public void predicateAnd(int value){
        Predicate<Integer> greaterThan10 = x -> (x > 10);
        Predicate<Integer> isEven = x -> (value % 2) < 1;
        System.out.println("is \"" + value + "\" is greater than 10 and even number ? : " + greaterThan10.and(isEven).test(value));

    }

    public void predList(List<String> name){
        //Predicate<String> predStartA = str -> str.startsWith("A");
        List<String> result = name.stream().filter(names -> names.startsWith("A")).collect(Collectors.toList());

        System.out.println(result.toString());


    }



}
