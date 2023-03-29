package javaEssential.oop.inherit;

public class BankAccount {

    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = Math.max(balance, 0);
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
    if(amount > 0.0){
        double currentBalance = getBalance();
        double newBalance = currentBalance+=amount;
        setBalance(newBalance);
        System.out.println("the new balance is : " + getBalance());

        } else {
        System.out.println("The deposit amount can't be zero nor negative!");

            }// end else

        }//end doposit

    public void withdraw (double amount){

        if (amount < getBalance()){
            double currentVBalance = getBalance();
            double newBalance = currentVBalance -= amount;
            setBalance(newBalance);
            System.out.println("the new balnce is : " + getBalance());
        }
        else {
            System.out.println("the amount to withdraw can't be exceed current balance!");
        }
    }//end withdraw
}
