package designPatterns.behaviors.visitor.lynda;

public interface Employee {
    double getSalary();
    void adjustSalary(SalaryChange visitor);
}
