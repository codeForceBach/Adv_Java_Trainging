package designPatterns.behaviors.observer.lynda;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class SocialMedia implements PropertyChangeListener {
    private ArrayList<String> statuses = new ArrayList<>();

    public void printStatuses(){
        for(String status : statuses){
            System.out.println(status);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        statuses.add((String) evt.getNewValue());
    }
}
