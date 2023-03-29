package javaEssential.oop;

import javaEssential.oop.abstraction.*;
import javaEssential.oop.inherit.PassengerCar;
import javaEssential.oop.inherit.Van;
import javaEssential.oop.inherit.Vehicle;
import javaEssential.oop.lambdas.Greeting;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static javaEssential.oop.inherit.Trim.*;

public class OopTest {

    /*
    Set - do not allow duplicate elements, unordered
    List - allow duplicate entries element in a list is ordered
    Queues - let you add to the head of javaEssential.collection (first in first out FIFO)
    map (do not extend the javaEssential.collection interface) key value pairs
     */

    public static void main(String [] args){
    /*  Testing console argument output
    //https://www.linkedin.com/learning/java-essential-training-syntax-and-structure/pass-arguments-to-a-console-application?resume=false&u=26281682
        for (String s : args) {
             System.out.println(s);
            }
    */
/*

        List <Vehicle> cars = new ArrayList<>();
        cars.add(new Van (2011, "Cystler", "Grand Caravan", EX));
        cars.add(new Van (2014, "Ford","Transit", EX));
        cars.add(new PassengerCar(2019, "Honda", "Civic", SPORT));
        for (Vehicle auto: cars
             ) {
            System.out.println(auto);
        }
*/

        /*
        Employee developerJson = new Employee("Jason Baker", 27, 65000, "Seattle");
        Employee analystKim = new Employee("Kimberly Coon", 24, 68000, "Mercer Island");

        analystKim.raiseSalary(0.08);
        developerJson.raiseSalary(0.2);
        SalesPerson SaraSale = new SalesPerson("Sara Wonder", 29, 71000, "Federal way", 2000);
        SaraSale.raiseCommission();
        Analyst analystMoly = new Analyst("Moly Joel",  35, 59000, "Shoreline");
        analystMoly.getAnnualBonus();

        BankAccount savingAcct = new BankAccount("Richard", 1200.00);
        BankAccount checkingAcct = new BankAccount("Elaine",  3000.00);

        savingAcct.deposit(500.00);
        savingAcct.withdraw(700.00);
        */
        //https://www.linkedin.com/learning/java-object-oriented-programming-2/solution-reduce-redundant-code-with-inheritance?u=26281682

/*
        ModArrayList mlist = new ModArrayList();

        mlist.add(13);
        mlist.add(71);
        mlist.add(34);
        mlist.add(17);
        mlist.add(33);
        mlist.add(24);

        System.out.println("the index of -3 of the list is : " + mlist.getUsingMod(-3));
        System.out.println("the index of 32 of the list is : " + mlist.getUsingMod(32));
*/

        //4 PolyMorphism
/*

        Contact Sally = new Contact("Sally", new PhoneNumber("2637263737"));
        Contact Maggie = new Contact("Maggie Smith", new PhoneNumber(41, "9384713401"));
        Contact Roger = new Contact("Roger Williams", new PhoneNumber("448474734929"));
        Contact David = new Contact("David Jones", "david_jones@bluewire.com");
        Contact Sarah = new Contact("Sarah Brown", new PhoneNumber("2029384982"), "sarahb@gmail.com");
        System.out.println(Sally);
        System.out.println(Maggie);
        System.out.println(Roger);
        System.out.println(David);
        System.out.println(Sarah);
        */

        //5 Abstraction - Interface, Abstract classes
/*

        DigitOnlyFileReader digitReader = new DigitOnlyFileReader("files/message.txt");
        try {
            System.out.println(digitReader.readFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(digitReader.getPath());

        PercentFileReader percentReader = new PercentFileReader("files/message.txt");
        try {
            System.out.println(percentReader.readFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(percentReader.getPath());
*/
/*

        AbstractEvent pwEvent = new PasswordChangeEvent("20012");
        AbstractEvent payEvent = new MissedPalynentEvent("190012723");
        AbstractEvent transferEvent = new MissedPalynentEvent("20210806");

        AbstractEvent[] events = {pwEvent, payEvent, transferEvent};
        for (AbstractEvent abE: events
             ) {
            System.out.println(abE.getTimeStamp());
            abE.process();
            System.out.println();

        }
*/

        Greeting gm = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("Hello " + name + "!");
            }
        };
        gm.greet("Richard");
        /*
        function is stateless.
        referential transparency
        absence of memory
         */
        Greeting gm2 = (name) -> {
            System.out.println("Hello " + name + "!");
        };
        gm2.greet("Elaine");

    }//end main

}