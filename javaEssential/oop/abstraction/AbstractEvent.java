package javaEssential.oop.abstraction;

import java.sql.Timestamp;

public abstract class AbstractEvent {

    private final Long createTimeStamp;
    protected String Id;

    public AbstractEvent(String id) {
        this.Id = id;
        this.createTimeStamp = new Timestamp(System.currentTimeMillis()).getTime();
    }

    public String getId() {
        return Id;
    }

    public Long getTimeStamp() {
        return this.createTimeStamp;
    }

    public abstract void process();

}
