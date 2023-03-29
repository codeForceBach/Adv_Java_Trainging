package designPatterns.behaviors.visitor.lynda;

public class Manager implements Employee{

    double salary = 78000.00;

    public void setSalary(double salary){
        this.salary = salary;

    }

    @Override
    public double getSalary() {
        return salary;
    }

    @Override
    public void adjustSalary(SalaryChange visitor) {
        visitor.acceptSalary(this);
    }
}
