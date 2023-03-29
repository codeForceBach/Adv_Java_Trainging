package designPatterns.behaviors.iterator.lynda;

import java.util.Iterator;

public class StaffList implements Iterable{

    private Employee [] employee ;

    public StaffList(Employee...employee) {
        this.employee = employee;
    }
    //return array of employee
    public Employee[] getEmployee() {
        return employee;
    }

    @Override
    //return customized iterator with class as argument.
    public StaffIterator iterator() {
        return new StaffIterator(this);
    }
}
