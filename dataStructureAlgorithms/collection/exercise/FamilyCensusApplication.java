package dataStructureAlgorithms.collection.exercise;

import org.junit.jupiter.params.shadow.com.univocity.parsers.csv.CsvFormat;

import java.util.*;

public class FamilyCensusApplication {

    public static void main(String[] args) {

        FamilyMember daveSmith = new FamilyMember("Dave","Smith","123 main st.","seattle","wa","43");
        FamilyMember aliceSmith = new FamilyMember("Alice","Smith","123 Main St.","Seattle","WA","45");
        FamilyMember bobWilliams = new FamilyMember("Bob","Williams","234 2nd Ave.","Tacoma","WA","26");
        FamilyMember carolJohnson = new FamilyMember("Carol","Johnson","234 2nd Ave","Seattle","WA","67");
        FamilyMember eveSmith = new FamilyMember("Eve","Smith","234 2nd Ave.","Tacoma","WA","25");
        FamilyMember frankJones = new FamilyMember("Frank","Jones","234 2nd Ave.","Tacoma","FL","23");
        FamilyMember goergeBrown = new FamilyMember("George","Brown","345 3rd Blvd., Apt. 200","Seattle","WA","18");
        FamilyMember halenBrown = new FamilyMember("Helen","Brown","345 3rd Blvd. Apt. 200","Seattle","WA","18");
        FamilyMember ianSmith = new FamilyMember("Ian","Smith","123 main st ","Seattle","Wa","18");
        FamilyMember janeSmith = new FamilyMember("Jane","Smith","123 Main St.","Seattle","WA","13");

        FamilyCensusService censusService = new FamilyCensusService();

        censusService.addFamilyMember(daveSmith);
        censusService.addFamilyMember(carolJohnson);
        censusService.addFamilyMember(bobWilliams);
        censusService.addFamilyMember(aliceSmith);
        censusService.addFamilyMember(eveSmith);
        censusService.addFamilyMember(frankJones);
        censusService.addFamilyMember(goergeBrown);
        censusService.addFamilyMember(halenBrown);
        censusService.addFamilyMember(ianSmith);
        censusService.addFamilyMember(janeSmith);


        List<FamilyMember> unSortedFamily = censusService.getMemberAsList();
        /*
        int count = 0;
        System.out.println("----------- UnOrder family as set --------------");
        System.out.println(censusService.toString());

        //censusService.filterByAge(18);
        //System.out.println("\nAfter filtered by age :\n" + censusService.toString());
        //Collection<FamilyMember> list = censusService.getCensusList();


        System.out.println(" - - - - - - - un sorted list in main- - - - - - ");
        count = 0;
        for(FamilyMember fm : unSortedFamily) {
            System.out.format("%d) %s is in index %d%n", ++count, fm.toString(), unSortedFamily.indexOf(fm));
            //System.out.println(fm.toString());
        }


        //Collections.sort(unSortedFamily);
        unSortedFamily.sort(Comparator.naturalOrder());
        //unSortedFamily.sort(Comparator.reverseOrder());
        System.out.println(" - - - - - - - After sort list in main- - - - - - ");
        int count = 0;
        for(FamilyMember fm : unSortedFamily) {
            System.out.format("%d) %s in %d%n", ++count, fm.toString(), unSortedFamily.indexOf(fm));
        }
        */

        censusService.printHouseholdMap();





    }
}
