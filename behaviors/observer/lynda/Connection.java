package designPatterns.behaviors.observer.lynda;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Connection {

    private String status = "";
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    /**
     * @param status
     * update new status and notify to PropertyChangeSupport that status has changed.
     */
    public void setStatus(String status) {
        support.firePropertyChange("status", this.status, status);
        this.status = status;
    }

    public void addPropertyChangeListener (PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }
}
