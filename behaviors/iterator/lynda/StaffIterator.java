package designPatterns.behaviors.iterator.lynda;

import java.util.Iterator;

public class StaffIterator implements Iterator {

    private StaffList staffList;
    private int index;

    public StaffIterator(StaffList staffList) {
        this.staffList = staffList;
        this.index = 0;
    }

    //create new Employee array and extract item from the iterable class's method call to validate next item
    @Override
    public boolean hasNext() {
        //retrieve all the employee from the iterable class of StaffList.getEmployee method that return collection of employee

        Employee [] employee = staffList.getEmployee();
        if(employee.length > index){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Employee next() {
        Employee[] employees = staffList.getEmployee();
        if (hasNext()){
            return employees[index++];
        } else {
            return next();
        }
    }
}
