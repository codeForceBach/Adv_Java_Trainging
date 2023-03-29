package javaEssential.oop.abstraction;

import java.sql.Timestamp;

//public class PasswordChangeEvent implements Event{
public class PasswordChangeEvent extends AbstractEvent{

    public PasswordChangeEvent(String id) {
        super(id);
    }

    @Override
    public void process() {
        System.out.println("Customer " + getId() + " Changed their password." +
                "Please send a confirmation email to customer.");
    }
}
