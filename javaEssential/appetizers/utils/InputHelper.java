package javaEssential.appetizers.utils;

import java.util.Scanner;

public class InputHelper {

    public String getInput(String prompt) throws NumberFormatException{
        System.out.print(prompt);
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        return input;
    }//end getInput

}
