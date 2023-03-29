package designPatterns.behaviors.observer.headFirst;

public class userInterface implements Subscriber{

    private double temperature;
    private double windSpeed;
    private double pressure;
    public userInterface(WeatherStation station) {
        station.addObserver(this);
    }

    public void display(){
        System.out.println("Weather update ! ");
        System.out.println("Temperature : " + temperature + ", Wind speed : " + windSpeed + ", Pressure : " + pressure + "!");
    }

    @Override
    public void update(double temperature, double windSpeed, double pressure) {
        this.pressure = pressure;
        this.temperature = temperature;
        this.windSpeed = windSpeed;

    }

}
