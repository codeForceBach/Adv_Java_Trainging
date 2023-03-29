package designPatterns.behaviors.observer.headFirst;

public interface Weather {

    public void addObserver(Subscriber sub);
    public void removeObserver(Subscriber sub);
    public void notifyObserver();
}
