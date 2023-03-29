package dataStructureAlgorithms.collection.ArrayList;

import dataStructureAlgorithms.collection.Guest;
import dataStructureAlgorithms.collection.Room;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BookingService {

    private Map<Room, Guest> booking = new HashMap<>();

    /**
     * The Provided Guest is placed in the bookings Map and associated with the provided room,
     * Only if on other guest is associated with the room.
     * return a boolean that indicated if the Guest was successfully placed in the room
     */
    public boolean book(Room room, Guest guest){
        /*
        if(booking.containsKey(room)) {
            return false;
        } else{
            booking.putIfAbsent(room, guest);
            return true;
        }

         */
        //by evaluating the return value of putIfAbsent with null it genereate boolean value to return
        return booking.putIfAbsent(room, guest) == null;

    }

    /**
     * return a double value that the rate of each Room booked in the booking map.
     * @return
     */
    public double totalRevenue(){
        double totalRevenue = 0.0;
        //Set<Map.Entry<String, Integer>> lastName = orderedFamilyMap.entrySet();
        Set<Map.Entry<Room, Guest>> bookedRooms = booking.entrySet();
        //for(Map.Entry<String, Integer> name : orderedFamilyMap.entrySet()) {
        for(Map.Entry<Room, Guest> bRoom : bookedRooms){
            totalRevenue += bRoom.getKey().getRate();
        }
        return totalRevenue;
    }



}
