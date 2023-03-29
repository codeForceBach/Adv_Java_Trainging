package functionalWtStream;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {

    private String Name;
    private Integer age;
    private Double salary;
    private Address address;
    private String location;

    public Employee(String name, int age, Double salary, String location) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void raiseSalary(double raise){
        Double currentSalary = getSalary();
        //http://blog.vanillajava.blog/2011/08/double-your-money-again.html
        //https://stackoverflow.com/questions/8148684/what-data-type-to-use-for-money-in-java#:~:text=Java%20has%20Currency%20class%20that,for%20representing%20currency%20decimal%20values.
        //option - https://www.joda.org/joda-money/
        Double newSalary = (Math.round(currentSalary + (currentSalary * raise)) /100.0);
        setSalary((Double)newSalary);
        System.out.println("raised salary for " + this.Name + " by " + raise + "% is " + newSalary + " from " + currentSalary);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getAge() == employee.getAge() && getSalary() == employee.getSalary() && getName().equals(employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getSalary());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                '}';
    }
}
