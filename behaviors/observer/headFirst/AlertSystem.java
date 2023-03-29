package designPatterns.behaviors.observer.headFirst;

public class AlertSystem implements Subscriber{

    private double currentTemperature = 67.0;
    private double previousTemperature;
    private double currentWindSpeed = 5.3;
    private double previousWindSpeed;
    private double currentPressure = 23.1;
    private double previousPressure;


    public AlertSystem(WeatherStation station) {
        station.addObserver(this);
    }

    @Override
    public void update(double temperature, double windSpeed, double pressure) {
            previousTemperature = currentTemperature;
            currentTemperature = temperature;
            previousWindSpeed = currentWindSpeed;
            currentWindSpeed = windSpeed;
            previousPressure = currentPressure;
            currentPressure = pressure;

        alert();
    }

    private void alert() {
        System.out.println("Alert!");
        if (currentPressure > previousPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == previousPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < previousPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }

    }
}
