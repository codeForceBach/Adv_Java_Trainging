package javaEssential.oop.abstraction;

import java.sql.Timestamp;

//public class AccountTransferEvent implements Event{
public class AccountTransferEvent extends AbstractEvent{


    public AccountTransferEvent(String id) {
        super(id);
    }

    @Override
    public void process() {
        System.out.println("Customer " + getId()+ " need to transfer\n Please reach out to CTF to remove service from old device \n and add service to new devise");
    }
}
