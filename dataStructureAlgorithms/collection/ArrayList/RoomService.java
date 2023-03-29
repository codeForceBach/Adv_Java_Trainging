package dataStructureAlgorithms.collection.ArrayList;

import dataStructureAlgorithms.collection.Room;

import java.util.*;

public class RoomService {
	// 1. Declare a Collection to store Room Inventory
	private Collection <Room> rooms;

	// 2. Initialize Collection and assign it to the Room Inventory
	public RoomService() {
		//rooms = new HashSet<>();
		//in order to keep the order of room inserted to the Collection
		//utilize one of subset of Collection that guarantee the order of insertion
		rooms = new LinkedHashSet<>();
	}

	/**
	 *
	 * @return List <Room>
	 */
	//3. Return the Room Inventory
	public Collection<Room> getInventory(){
		//collection is mutable so if you just returned internal collection,
		//someone could modify the elements within it
		//by creating defensive copy, you protect against modification
		//return new ArrayList<>(this.rooms);
		return new HashSet<>(this.rooms);
	}
	
	public void createRoom(String name, String type, int capacity, double rate) {
	// 4. Add a new Room to the Room Inventory using the provided parameters
		rooms.add(new Room(name, type, capacity, rate));
	}

	public void createRooms(Room[] rooms) {
	// 5. Add the Rooms provided in the Array to the Room Inventory
		this.rooms.addAll(Arrays.asList(rooms));
	}

	public void createRooms(Collection<Room> rooms) {
		// 5. Add the Rooms provided in the Array to the Room Inventory
		this.rooms.addAll(rooms);
	}
	
	public void removeRoom(Room room) {
	// 6. Remove the provided Room from the Room Inventory
		rooms.remove(room);
	}

	public boolean hasRoom(Room room){
		//returns a boolean that indicates if the Room Inventory contains a Room.
		//return false;
		return this.rooms.contains(room);
	}

	//returns all Rooms as an Array of Rooms in the **order** they were added.
	public Room[] asArray(){
		//return roomAsArray;
		return (Room[]) rooms.toArray(new Room[0]);
	}

	/**
	 * apply discount on the rate of each room provided discount amount
	 * @param rate
	 */
	public void applyDiscount(final double rate){
		for(Room r : rooms){
			r.setRate(r.getRate() - (r.getRate()*rate));
		}
	}

	public Collection<Room> getRoomsByCapacity(final int requiredCapacity){
		Collection<Room> equalCapacityRooms = new HashSet<>();
		for(Room r : rooms){
			if(r.getCapacity() >= requiredCapacity){
				equalCapacityRooms.add(r);
			}
		}
		return equalCapacityRooms;
	}

	public Collection<Room> getRoomByRateAndType(final double rate, final String type){
		Collection<Room> matchingRooms = new HashSet<>();
		for(Room r : rooms){
			if((r.getRate() < rate) && (r.getType().equals(type))){
				matchingRooms.add(r);
			}
		}
		return matchingRooms;
	}

	//return a new Collection of Rooms where Room#type matches the provided String.
	//the original Room Inventory collection MUST NOT BE MODIFIED;
	public Collection<Room> getByType(String type){
		Collection<Room> sameTypeRoom = new ArrayList<>();
		for(Room r : rooms){
			if((r.getType().equals(type))){
				sameTypeRoom.add(r);
			}
		}
		return sameTypeRoom;
	}

	public String toString(){
		StringBuilder roomlist = new StringBuilder("");
		for(Room r : rooms){
			roomlist.append(r.toString() + "\n");
		}
		return roomlist.toString();
	}

}
