package designPatterns.behaviors.observer.lynda;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class TrafficUpdate implements PropertyChangeListener {

    private ArrayList<String> updates = new ArrayList<>();

    public void getupdates(){
        for(String update : updates){
            System.out.println(update);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        updates.add((String) evt.getNewValue());
    }
}
