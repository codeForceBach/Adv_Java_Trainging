package dataStructureAlgorithms;

import java.awt.*;
import java.util.Objects;

public class Car {

	private String manufacture;
	private String model;
	private String trim;
	private int mileage;
	private int mpgRateCity;
	private int mpgRateHwy;
	private Color color;

	public Car(String make, String model, int mileage) {
		super();
		this.manufacture = make;
		this.model = model;
		this.mileage = mileage;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Car car = (Car) o;
		return manufacture.equals(car.manufacture) && model.equals(car.model);
	}

	@Override
	public int hashCode() {
		return Objects.hash(manufacture, model);
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	@Override
	public String toString() {
		return "Car [make=" + manufacture + ", model=" + model + "]";
	}
	
}
