package javaEssential.oop.inherit;

public class Employee {

    private String Name;
    private int age;
    private int salary;
    private String location;

    public Employee(String name, int age, int salary, String location) {
        Name = name;
        this.age = age;
        this.salary = salary;
        this.location = location;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void raiseSalary(double raise){
        int currentSalary = getSalary();
        int newSalary = (int) (Math.round(currentSalary + (currentSalary * raise)));
        setSalary((int)newSalary);
        System.out.println("raised salary for " + this.Name + " by " + raise + "% is " + newSalary + " from " + currentSalary);
    }
}
