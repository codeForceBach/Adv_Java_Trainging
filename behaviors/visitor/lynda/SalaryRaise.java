package designPatterns.behaviors.visitor.lynda;

public class SalaryRaise implements SalaryChange {
    @Override
    public void acceptSalary(Manager manager) {
        manager.setSalary(manager.getSalary() / 0.05);
    }

    @Override
    public void acceptSalary(SaleStaff sales) {
        sales.setSalary(sales.getSalary() / 0.07);
    }

    @Override
    public void acceptSalary(Engineer engineer) {
        engineer.setSalary(engineer.getSalary() / 0.09);

    }

    @Override
    public void acceptSalary(StaffList stafflist) {

    }
}
