package javaEssential;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

//https://www.linkedin.com/learning/java-essential-training-syntax-and-structure/declare-and-initialize-string-objects?u=26281682
public class Je_SyntaxStructure {
    public String type;

    public static void main(String [] args){

        Je_SyntaxStructure echo = new Je_SyntaxStructure();
        echo.type = "Hat";
        //echo.displayItem();
        //echo.validateString();
        //echo.manualInterning();
        echo.stringCompare();
        echo.stringCompareG4g();
        //echo.formatNumeric();
        //echo.stringBuild();
        //echo.formatMsg();
        Scanner scan = new Scanner(System.in);
        //echo.calAdd();
        //covariant(scan);

        for(Mobile phone : Mobile.values()){
            System.out.println(phone + " costs " + phone.showPrice() + " dollars.");
        }
        

    }//end main


    //enum class sample
    //https://www.tutorialspoint.com/java/lang/enum_ordinal.htm
    private enum Mobile{
        //initialize enum
        Samsung(1200), Nokia(600), Motorola(400);
        int price;

        //enum class constructor
        Mobile(int price){
            this.price = price;
        }

        int showPrice(){
            return price;
        }

    }

    private static void covariant(Scanner scan) {
        //https://www.linkedin.com/learning/java-essential-training-syntax-and-structure/solution-a-more-complex-calculator?u=26281682
        System.out.println("This is simple calculation test!");
        System.out.print("please enter a (double) number :");
        String input1 = scan.nextLine();
        System.out.print("please enter another (double) number : ");
        String input2 = scan.nextLine();
        System.out.print("chose an operator in (+, -, *, / or % ) : ") ;
        String operator = scan.nextLine();

        double d1 = Double.parseDouble(input1);
        double d2 = Double.parseDouble(input2);

        switch (operator) {
            case "+":
                calAddtion(d1, d2);
                break;
            case "-" :
                calSubtraction(d1, d2);
                break;
            case "*" :
                calMultipication(d1, d2);
                break;
            case "/":
                calDivision(d1, d2);
                break;
            case "%":
                calMod(d1, d2);
                break;
            default:
                break;

        }

    }

    private static void calMod(double d1, double d2) {
        double result = d1 % d2;
        System.out.println("the mod of " + d1 + " and " + d2 +" is " + result);
    }

    private static void calDivision(double d1, double d2) {
        double result = d1 / d2;
        System.out.println("the division of " + d1 + " and " + d2 +" is " + result);
    }

    private static void calMultipication(double d1, double d2) {
        double result = d1 * d2;
        System.out.println("the multiplication of " + d1 + " and " + d2 +" is " + result);
    }

    private static void calSubtraction(double d1, double d2) {
        double result = d1 - d2;
        System.out.println("the subtraction  of " + d1 + " and " + d2 +" is " + result);
    }

    private static void calAddtion(double d1, double d2) {
        double result = d1 + d2;
        System.out.println("the sum of " + d1 + " and " + d2 +" is " + result);
    }

    private void calAdd() {

        Scanner scan = new Scanner(System.in);

        System.out.println("This is simple addition test.");
        System.out.print("Please enter a numberic value : ");
        String input1 = scan.nextLine();

        System.out.print("Please enter another value : ");
        String input2 = scan.nextLine();

        double d1 = Double.parseDouble(input1);
        double d2 = Double.parseDouble(input2);

        double result = d1 + d2;
        System.out.println("The sum of the two value you entered \"" + input1 + "\" and \"" + input2 + "\" equals " + result + ".");

    }

    private void formatMsg() {
        //https://docs.oracle.com/javase/8/docs/api/java/text/MessageFormat.html
        int planet = 7;
        String event = "a explosion in the force";
        String msg = MessageFormat.format("At {1, time} on {1, time}, there was {2} on planet {0,number,integer}.", planet, new Date(), event);
        System.out.println(msg);

        int fileCount = 1237;
        String holder = "flash Drive";
        Object[] testArgs = {new Long(fileCount), holder};

        MessageFormat form = new MessageFormat("The \"{1}\" contains {0} file(s).");
        System.out.println(form.format(testArgs));

    }


    private void formatNumeric() {
        //https://www.linkedin.com/learning/java-essential-training-syntax-and-structure/format-numeric-values-as-strings?u=26281682
        //https://www.baeldung.com/java-number-formatting
        
        double decimalValue = 1_234_567.89;

        NumberFormat numFormat = NumberFormat.getNumberInstance();
        System.out.println("Number format in : " + numFormat.format(decimalValue));

        NumberFormat intFormat = NumberFormat.getIntegerInstance();
        System.out.println("Number format in Integer truncate decimal value as : "  + intFormat.format(decimalValue));

        //remove seperator
        numFormat.setGroupingUsed(false);
        System.out.println("Number format without seperator : " + numFormat.format(decimalValue));

        //localize
        Locale localDe = new Locale("de", "DE");
        NumberFormat localDeFormat = NumberFormat.getNumberInstance(localDe);
        System.out.println("Local version numeric format : " + localDeFormat.format(decimalValue));

        //Local currency
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        System.out.println(Locale.getDefault() + " Currency conversion : " + currencyFormat.format(decimalValue));

        NumberFormat deCurrencyFormat = NumberFormat.getCurrencyInstance(localDe);
        System.out.println(localDe.toString() + " Currency conversion : " + deCurrencyFormat.format(decimalValue));


        //https://www.baeldung.com/java-decimalformat
        DecimalFormat deciFormat = new DecimalFormat("$##0.00#");
        System.out.println("decimal format as 1 as \"$##0.00#\" " + deciFormat.format(1));
        System.out.println("decimal format of 5.812 " + deciFormat.format(5.812));
    }

    //https://www.baeldung.com/java-compare-strings
    private void stringCompare() {
        //"=="- operator only check the referential equality of two String.
        //equals() method however compares two Strings character by character not the reference address
        System.out.println("String comparison sample");
        String comSt1 = "String Compare";
        String comSt2 = new String("String Compare");
        String comSt3 = "STRING COMPARE";
        String randomSt = "Ramdome String";
        System.out.println("The referential comparison result is " + (comSt1 == comSt2));//false
        System.out.println("However equals method comparison result is " + comSt1.equals(comSt2));//true
        System.out.println("The equalsignoreCase() method compare String regardless of case of each String which result : " + comSt1.equalsIgnoreCase(comSt3) + " and " + comSt2.equalsIgnoreCase(comSt3));//true and true

        //compareTo() method returns an int type value and compares two Strings character by character lexicographically.
        //it return 0 if two String are equals or if both values are null
        //negative value if the first String comes before the argument.
        //number greater than zero if the first String comes after the argument

        System.out.println("compare same String result in compareTo() as : " + comSt1.compareTo(comSt2));//0
        System.out.println("compare  two string result  : " + comSt1.compareTo(randomSt) + ", if the first String comes after the argument.");//1
        System.out.println("compare two string result : " + randomSt.compareTo(comSt1) + ", if the first String comes before the argument.");//-1

    }

    //https://www.geeksforgeeks.org/difference-equals-method-java/
    private void stringCompareG4g(){
        System.out.println("\nString comparison sample 2");
        String s1 = "HELLO";
        String s2 = "HELLO";
        String s3 =  new String("HELLO");
        System.out.println("== operator result of same object-> " + s1 == s2); // false
        System.out.println("== operator result of different object-> " + s1 == s3); // false
        System.out.println("equlas() method for same object -> " + s1.equals(s2)); // true
        System.out.println("equlas() method for different object -> " +s1.equals(s3)); // true
    }
    //https://www.linkedin.com/learning/java-essential-training-syntax-and-structure/build-a-string-from-multiple-values?u=26281682
    private void stringBuild() {
        /*StringBuilder sb = new StringBuilder("Welcome");
        sb.append (" to EDI!");
        String result = sb.toString();
        System.out.println("sample output for stringBuild method :" + result);
         */
        Scanner scan = new Scanner(System.in);
        System.out.print("please enter a value : ");
        String input1 = scan.nextLine();

        System.out.print("please enter another value : ");
        String input2 = scan.nextLine();

        StringBuilder stbd = new StringBuilder();
        stbd.append(input1).append(", ").append(input2);

        System.out.println(stbd.toString());
    }

    private void displayItem(){
        System.out.println("This is a " + this.type);
    }

    //https://www.baeldung.com/java-string-pool
    private void validateString(){
        String literalInst1 = "Java Syntax and Structure";
        String literalInst2 = "Java Syntax and Structure";
        System.out.println("Are Literal instance of String equals? " + (literalInst1 == literalInst2));

        String literalStr = "String intering";
        String objectStr = new String("String intering");

        System.out.println("Are literalStr and objectStr equals ? " + (literalStr == objectStr));
    }

    //https://www.baeldung.com/java-string-pool
    private void manualInterning(){
        String literalString = "Interned Java String";
        String objectString = new String("Interned Java String");

        System.out.println("Are literalString and objectString equals ? " +(literalString == objectString));

        //interning the objectString
        String internedString = objectString.intern();

        System.out.println("After interning objectString are these equals ? "+ (literalString == internedString));
    }


}//end class
