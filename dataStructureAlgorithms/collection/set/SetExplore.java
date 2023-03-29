package dataStructureAlgorithms.collection.set;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class SetExplore {
    //https://www.geeksforgeeks.org/set-in-java/
    enum st {CODE, LEARN, QUIZ, TEST};
    public static void main(String[] args) {

        SetExplore setTest = new SetExplore();

        Set<Integer> exa = new HashSet<>();
        exa.addAll(Arrays.asList(new Integer[] {1, 3, 2, 4, 8, 9, 0}));

        Set<Integer> exb = new HashSet<>();
        exb.addAll(Arrays.asList(new Integer [] {1, 3, 7, 5, 4, 0, 7, 5}));


        //https://www.geeksforgeeks.org/enumset-class-java/ - Study further
        EnumSet<st> enumSet;
        enumSet = EnumSet.of(st.CODE, st.LEARN, st.QUIZ, st.TEST);

        System.out.println(setTest.unionSet(exa, exb));
        System.out.println(setTest.intersection(exa, exb));
        System.out.println(setTest.difference(exa, exb));
        System.out.println("is exa contain all the diff? " + exa.containsAll(setTest.difference(exa, exb)));
        System.out.println("compare default removeAll with stream filter : " + setTest.difference(exa, exb).equals(setTest.streamFilterDiff(exa, exb)));
    }

    public Set<Integer> unionSet(Set<Integer> a, Set<Integer> b){
        Set<Integer> union = new HashSet<>(a);
        System.out.println("has set b added to set A? " + union.addAll(b));
        return union;
    }

    public Set<Integer> intersection(Set<Integer> a, Set<Integer> b){
        Set<Integer> intersection = new HashSet<>(a);
        System.out.println("Has the set A have been changed? " + intersection.retainAll(b));
        return intersection;
    }

    public Set<Integer> difference(Set<Integer> a, Set<Integer> b){
        Set<Integer> diff = new HashSet<>(a);
        //System.out.println(diff.removeAll(b));
        diff.removeAll(b);
        return diff;
    }

    public Set<Integer> streamFilterDiff(Set<Integer> a, Set<Integer> b){
        Set<Integer> stDiff = a.stream()
                .filter(s -> !b.contains(s))
                .collect(Collectors.toSet());
        return stDiff;
    }

}

