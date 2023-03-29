package javaEssential.predicate;

import javaEssential.predicate.predicateUtils.PredicateSamples;

import java.util.Arrays;
import java.util.function.Predicate;

public class predicateTests {

    public static void main(String[] args) {

        //https://www.educative.io/edpresso/what-is-a-java-predicate
        PredicateSamples predicateEx = new PredicateSamples();
        predicateEx.predicateGreaterThan(13);
        predicateEx.predIsEquals("Easy", "easy");
        predicateEx.predicateAnd( 18);

        //https://www.baeldung.com/java-predicate-chain
        predicateEx.predList(Arrays.asList("Adam", "Alex", "Ioan", "tom", "Jeff", "Anold", "Aaron"));
    }
}
