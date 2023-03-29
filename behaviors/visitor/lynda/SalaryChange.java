package designPatterns.behaviors.visitor.lynda;

public interface SalaryChange {

    void acceptSalary(Manager manager);
    void acceptSalary(SaleStaff sales);
    void acceptSalary(Engineer engineer);
    void acceptSalary(StaffList stafflist);
}
