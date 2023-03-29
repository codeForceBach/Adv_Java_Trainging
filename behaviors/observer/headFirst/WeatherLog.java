package designPatterns.behaviors.observer.headFirst;


import java.time.LocalDateTime;

public class WeatherLog {

    private LocalDateTime date;
    private double temperature;
    private double windSpeed;
    private double pressure;

    public WeatherLog(double temperature, double windSpeed, double pressure) {
        date = LocalDateTime.now();
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
    }

    public String toString(){
        return "[Datetime : " + date + ", Temperature : " + temperature + ", wind speed : " + windSpeed + ", pressure : " + pressure + "]";
    }
}
