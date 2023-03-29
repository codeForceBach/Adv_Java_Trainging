package dataStructureAlgorithms.collection;

import java.util.Objects;

public class Room implements Comparable<Room>{

	private String name;
	private String type;
	private int capacity;
	private double rate;
	private boolean isPetFriendly = false;

	public Room(String name, String type, int capacity, double rate) {
		this.name = name;
		this.type = type;
		this.capacity = capacity;
		this.rate = rate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public void setPetFriendly(boolean b){
		isPetFriendly = b;
	}

	public Room(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "Room [name=" + name + ", type=" + type + ", capacity=" + capacity + ", rate=" + rate + "]";
	}

	public boolean isPetFriendly() {
		return isPetFriendly;
	}

	@Override
	public boolean equals(Object o) {

		System.out.format("Comparing %s with %s%n", this.name, ((Room)o).name);
		if (this == o) return true;
		if (!(o instanceof Room)) return false;
		Room room = (Room) o;
		return getName().equals(room.getName()) && getType().equals(room.getType());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getType());
	}

	@Override
	public int compareTo(Room o) {
		int compareResult = this.getName().compareTo(o.getName());
		if(compareResult == 0){
			return this.getType().compareTo(o.getType());
		}else {
			return compareResult;
		}

	}
}
