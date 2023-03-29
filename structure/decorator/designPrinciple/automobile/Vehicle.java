package designPatterns.structure.decorator.designPrinciple.automobile;

import javaEssential.oop.inherit.Trim;

public interface Vehicle {
    int getYear() ;
    String getManufacture() ;
    String getName();
    Trim getTrim();
}
