package genric;

import java.util.ArrayList;
import java.util.List;

public class GenericSample {
    public static void main(String[] args){

        List names = new ArrayList();
        names.add("Kelly");
        String name = (String) names.get(0);
        System.out.println("First name: " + name);
        names.add(7);

        List<String> names2 = new ArrayList();
        names2.add("Kelly");
        String name2 = names2.get(0);
        System.out.println("First name: " + name2);
        //names2.add(7);


    }
}
