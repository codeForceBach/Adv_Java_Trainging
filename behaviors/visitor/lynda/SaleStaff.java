package designPatterns.behaviors.visitor.lynda;

public class SaleStaff implements Employee{

    double salary = 55000.00;

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
