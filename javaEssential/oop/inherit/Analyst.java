package javaEssential.oop.inherit;

public class Analyst extends Employee{

    public Analyst(String name, int age, int salary, String location) {

        super(name, age, salary, location);
    }

    public void getAnnualBonus(){
        int bonus = (int) (getSalary() * 0.05);
        System.out.println(" with bonus this year, " + getName() + "'s salary is " + (getSalary() + bonus));
    }
}
