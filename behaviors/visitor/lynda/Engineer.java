package designPatterns.behaviors.visitor.lynda;

public class Engineer implements Employee{

    double salary = 70000.00;

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
