package designPatterns.behaviors.visitor.lynda;

import java.util.ArrayList;

public class StaffList implements Employee{

    ArrayList<Employee> staff = new ArrayList<Employee>();

    public void addEmployee(Employee employee){
        staff.add(employee);
    }
    @Override
    public double getSalary() {
        double sum = 0;
        for(Employee e : staff){
            sum += e.getSalary();
            System.out.println("Each employee Salary : " + e.getSalary());
        }
        return sum;
    }

    @Override
    public void adjustSalary(SalaryChange visitor) {
        for(Employee e : staff){
           e.adjustSalary(visitor);
            //System.out.println("Each employee Salary : " + e.getSalary());
        }
    }
}
