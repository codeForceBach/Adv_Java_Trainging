package designPatterns.behaviors.observer.headFirst;

import java.util.ArrayList;
import java.util.List;

public class Logger implements Subscriber{

    private List<WeatherLog> weatherLog = new ArrayList<>();

    public Logger(WeatherStation station) {
        station.addObserver(this);
    }

    public void log(double temperature, double windSpeed, double pressure) {
        weatherLog.add(new WeatherLog(temperature, windSpeed, pressure));

        for(WeatherLog weather: weatherLog){
            System.out.println(weatherLog.toString());
        }
    }

    @Override
    public void update(double temperature, double windSpeed, double pressure) {
        log(temperature, windSpeed, pressure);
        System.out.println("the latest data has been logged.");
    }
}
