package genric.genericWildcard;

import java.util.ArrayList;
import java.util.List;

public class SubstituteMain {

    public static void main(String [] args){
        Building building = new Building();
        Office office = new Office();
        build(building);
        build(office);

        List<Building> buildings = new ArrayList();
        buildings.add(new Building());
        buildings.add(new Office());
        printBuilding(buildings);

        List<House> houses = new ArrayList<>();
        houses.add(new House());
        houses.add(new House());
        //printBuilding(offices); //class cast error without wildcard argument in method

        List<Office> offices = new ArrayList();
        offices.add(new Office());
        offices.add(new Office());
        printBuilding(offices); //class cast error without wildcard argument in method

        //super class wild card allows call super class to be a generic type for the method
        addHouseToList(houses);
        addHouseToList(buildings);
    }//End main

    public static void build(Building building){
        System.out.println("Constructing a new " + building.toString());
    }

    //use wild card argument<? extends [super class type]> allow the method with subclass type parameter
    public static void printBuilding(List<? extends Building> buildings){
        for(int i = 0 ; i < buildings.size() ; i++){
            System.out.println(i + 1 + " : " + buildings.get(i).toString());
        }
        System.out.println();
    }//end

    public static void addHouseToList(List <? super House> buildings){
        buildings.add(new House());
        System.out.println();

    }
}
