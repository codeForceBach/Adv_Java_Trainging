package javaEssential.oop.inherit;

public class SalesPerson extends  Employee{

    private double commissionPercentage;

    public SalesPerson(String name, int age, int salary, String location, double commission) {
        super(name, age, salary, location);
        this.commissionPercentage = commission;
    }

    public double getCommissionPercentage() {

        return this.commissionPercentage;
    }

    public void raiseCommission(){
        if (this.commissionPercentage < .30){
            this.commissionPercentage = this.commissionPercentage *1.2;
        }
        System.out.println("Raise " + getName() + "'s sales commission to " + this.commissionPercentage);
    }
}
