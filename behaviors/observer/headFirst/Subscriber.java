package designPatterns.behaviors.observer.headFirst;

public interface Subscriber {

    void update(double temperature, double windSpeed, double pressure);
}
