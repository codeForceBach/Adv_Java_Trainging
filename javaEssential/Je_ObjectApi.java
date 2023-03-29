package javaEssential;

import javaEssential.oop.inherit.*;

public class Je_ObjectApi {

    public static void main (String [] args){
        //Ch12
        //exceptionDebugEx();
        //Ch2 Encapsulation
/*
        //change the access modifier to non static,
        //it is necessary to initialize a class and use the instance variables to access methods
        InputHelper prompt = new InputHelper();
        String input = prompt.getInput("Enter a value : ");
        System.out.println("You entered :" + input);
        input = prompt.getInput("Enter another value : ");
        System.out.println("You entered :" + input);
*/

/*

        MathHelper calculate = new MathHelper();
        double value;
        do {
            value = calculate.operation();
            double total = calculate.getTotal();
            System.out.println("you entered " + value + " and the total is " + total);
        } while (value > 0);
*/

/*        //Ch3 - Inheritance & polymorphism
        PassengerCar pCar = new PassengerCar(1996, "Toyota", "Camry", Trim.LE);
        //System.out.println(pCar);
        getProduct(pCar);

        Van sienna = new Van ("Toyota", "Sienna", Trim.XLE);
        //System.out.println(sienna);
        getProduct(sienna);
        sienna.setFeature("GPS Navigation");
        System.out.println("the added feature of Sienna is : " + sienna.getFeature());

        PassengerCar caravan = new Van ("Dodge", "Grand Carava", Trim.LX);
        //System.out.println(caravan);
        getProduct(caravan);

        //casting
        Van pacific = (Van) caravan;
        caravan.setName("Pacific");
        caravan.setManufacture("Chrysler");

        getProduct(pacific);
        pacific.setFeature("heated seat!");
        System.out.println(" the feature of the Pacific is " + pacific.getFeature());*/



    }//end main

     private static void getProduct(Vehicle car) {
         String output = car.getClass().getSimpleName() + "{" +
                 "year=" + car.getYear() +
                 ", Manufacture='" + car.getManufacture() + '\'' +
                 ", name='" + car.getName() + '\'' +
                 ", trim='" + car.getTrim() + '\'' +
                 "}";
         System.out.println(output);
     }

    //building custom method

    private static void exceptionDebugEx() {

        char[] chars = new char[0];
        try {
            String slogan = "Move forward to the future!";
            chars = slogan.toCharArray();
            char lastChar = chars[chars.length - 1];
            System.out.println("last character of the \"" + slogan + "\" is \"" + lastChar + "\".");

            //String nothing = null;
            //System.out.println(nothing.length());
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return;
        } catch (NullPointerException n) {
            n.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        for (char ch : chars) {
            System.out.println(ch);
        }
    }
}
