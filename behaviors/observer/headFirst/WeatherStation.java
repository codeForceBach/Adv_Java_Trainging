package designPatterns.behaviors.observer.headFirst;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Weather{

    private double temperature;
    private double windSpeed;
    private double pressure;
    private List<Subscriber> observerList;

    public WeatherStation(double temp, double wins, double pressure) {
        this.temperature = temp;
        this.windSpeed = wins;
        this.pressure = pressure;
        this.observerList = new ArrayList<>();

    }

    @Override
    public void addObserver(Subscriber subscriber) {
        if(!observerList.contains(subscriber)) {
            observerList.add(subscriber);
        } else {
            System.out.println("The " + subscriber + " is already in our subscriber list!");
        }
    }

    @Override
    public void removeObserver(Subscriber subscriber) {
        if (observerList.contains(subscriber)){
            observerList.remove(subscriber);
        } else {
            System.out.println("The " + subscriber + " is not on our subscriber list. \n would you like to be added?");
        }
    }

    @Override
    public void notifyObserver() {
        for(Subscriber sub: observerList){
            sub.update(temperature, windSpeed, pressure);
        }

    }
}
