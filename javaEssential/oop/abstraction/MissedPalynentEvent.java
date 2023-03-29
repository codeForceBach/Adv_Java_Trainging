package javaEssential.oop.abstraction;

import java.sql.Timestamp;

//public class MissedPalynentEvent implements Event{
public class MissedPalynentEvent extends AbstractEvent{

    public MissedPalynentEvent(String id) {
        super(id);
    }

    @Override
    public void process() {
        System.out.println("Customer " + getId() + " missed their payment, " +
                "Please send a bill to the customer.");
    }
}
