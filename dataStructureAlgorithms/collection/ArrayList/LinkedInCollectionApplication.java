package dataStructureAlgorithms.collection.ArrayList;

import dataStructureAlgorithms.collection.Guest;
import dataStructureAlgorithms.collection.Room;

import java.util.*;

public class LinkedInCollectionApplication {

    /*
    Arraylist
     */
    public static void main(String[] args) {

        Room westminster = new Room("Westminster", "Premiere Room", 4, 200.00);
        Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
        Room manchester = new Room("Manchester", "Suite", 5, 250.00);
        Room piccadillyPremie = new Room("Piccadilly", "Premiere Room", 3, 125.00);
        Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
        Room piccadillyCabin = new Room("Piccadilly", "Cabin", 7, 299.00);
        Room victoria = new Room("Victoria", "Suite", 5, 225.00);
        Room oxford = new Room("Oxford", "Suite", 5, 225.0);

        List<Room> rooms = new ArrayList<>(Arrays.asList(piccadillyCabin, westminster, cambridge, manchester, victoria, piccadilly, oxford, piccadillyPremie));

        System.out.println(" - - - - Rooms in the order it entered - - - - - " );
        for(Room list : rooms){
            System.out.println(list.toString());
        }
        Collections.sort(rooms);

        System.out.println(" - - - - Rooms after order by  - - - - - " );
        for(Room list : rooms){
            System.out.println(list.toString());
        }

/*
        ArrayRoomService roomService =  new ArrayRoomService();
        //pass list of room as argument to an overroded method
        roomService.createRooms(rooms);


        Collection <Room> asList = roomService.getInventory();
        //Collections.sort(asList);
        System.out.println("order : " );
        for(Room list : asList){
            System.out.println(list.toString());
        }
        /*
        Collection<Room> premiereRoom = roomService.getByType("Premiere Room");
        System.out.println("-------------------Premiere Room List -------------");
        for(Room preRoom : premiereRoom){
            System.out.println(preRoom.toString());
        }

        Collection<Room> roomsWithRateAndType = roomService.getRoomByRateAndType(190.00, "Premiere Room");
        System.out.println("-------------------Room by Premiere and 190  -------------");
        for(Room rRateType : roomsWithRateAndType){
            System.out.println(rRateType.toString());
        }


        oxford.setPetFriendly(true);
        victoria.setPetFriendly(true);

        Room buckingham = new Room("Buckingham", "Premiere Room", 5, 220.0);
        Room lancaster = new Room("Lancaster", "Guest Room", 4, 185.0);
        */
/*
        //5. List
        Guest john = new Guest("John", "Doe", false);
        Guest maria = new Guest("Maria", "Smith", false);
        Guest sonia = new Guest("Sonia", "Coot", true);
        Guest alexa = new Guest("Alexa", "Amazon", true);
        Guest jane = new Guest("Jane", "Austin", false);

        //List<Guest> checkinList = new ArrayList<>();
        GuestService guestService = new GuestService();
        guestService.checkIn(john);
        guestService.checkIn(maria);
        guestService.checkIn(sonia);
        guestService.checkIn(alexa);
        guestService.checkIn(jane);

        Collection<Guest> guestList = guestService.getCheckInList();
        for(Guest g : guestList){
            System.out.println(g.toString());
        }

        //iterating collection elements

        /*
        3.1 - Iterables - Several approaches for iterating collection  rely upon objects implementing the iterable interface.
        Iterator only provides forward traversal
        mostly paired with basic loops hasNext() , next()

        Streams - Provides a sequence of elements from a source collection taht can have one or more operations applied
        uses a functional programming style
        Does not modify source collection
        Divided into intermediate and terminal operations
        Operations frequently accept lambda expression
         */

        //3.2 this factory method return a new instance of an iterator
        /*
        Iterator<Room> iterator = rooms.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }

        */

        //3.3 - functional programming pattern
        /*
        System.out.println(roomService.toString());
        roomService.orderByNameType();
        System.out.println("Ordered by name and type : ");
        System.out.println(roomService.toString());
*/
         //Collections.sort(rooms);
        /*
        for (Room r : rooms) {
            System.out.println(r.getName());
            //this throw concurrent medication exception due to the underlying collection is modified while iterate through it.
            //this exception protect the collection from being changed by another thread while we are iteration through it.
            if(r.isPetFriendly()){
                rooms.remove(r);
            }
        }

         */

        /*
        //in order to avoid unintended exception or modification of underlying collection,
        //create new collection to store filtered element in the new collection
        Collection<Room> petFriendlyRooms = new ArrayList<>();

        for (Room r : rooms) {
            System.out.println(r.getName());

            if(r.isPetFriendly()){
                petFriendlyRooms.add(r);
            }
        }
        rooms.removeAll(petFriendlyRooms);
        System.out.println("Non Pet Friendly room");
        rooms.stream().forEach(r -> System.out.println(r.getName()));
        */

        /*
        Iterator<Room> iterator = rooms.iterator();
        while(iterator.hasNext()){
            Room iroom = iterator.next();
            if(iroom.isPetFriendly()){
                rooms.remove(iroom);
            }
        }
        rooms.stream().forEach(r -> System.out.println(r.getName()));
        */

        //3.4 accessing elements with stream with anonymous class
        /*
        rooms.stream()
                .filter(new Predicate<Room>() {
                    @Override
                    public boolean test(Room room) {
                        System.out.format("Testing %s with result %b%n ", room.getName(), room.isPetFriendly());
                        return room.isPetFriendly();
                    }
                }).forEach(new Consumer<Room>() {
                    @Override
                    public void accept(Room room) {
                        System.out.println(room.getName());
                    }
                });
         */

        //3.5 Stream with lambda expression progress
        /* 1
        rooms.stream()
                .filter(room-> room.isPetFriendly())
                .forEach(new Consumer<Room>() {
            @Override
            public void accept(Room room) {
                System.out.println(room.getName());
            }
        });
         */
        /* 2
        rooms.stream()
                .filter(room-> room.isPetFriendly())
                .forEach(room -> System.out.println(room.getName()));
        */
        /*
        rooms.stream()
                .filter(Room::isPetFriendly)
                .forEach(room -> System.out.println(room.getName()));

         */

        //3.6 Stream operation
        //Collection<Room> petFriendlyRooms = new ArrayList<>();
        /*
        rooms.stream()
                .filter(Room::isPetFriendly)
                .forEach(room -> petFriendlyRooms.add(room));

         //to be more like below ->
        rooms.stream()
                .filter(Room::isPetFriendly)
                .forEach(petFriendlyRooms::add);
        //as to ->
        rooms.stream()
                .filter(Room::isPetFriendly)
                .collect(Collectors.toList());
        //as to ->

        Collection<Room> petFriendlyRooms = rooms.stream()
                .filter(Room::isPetFriendly)
                .collect(Collectors.toList());


        //to be more like below
        petFriendlyRooms.stream()
                .map(r -> r.getName())
                .forEach(System.out::println);


        double total = petFriendlyRooms.stream()
                .mapToDouble(Room::getRate)
                .sum();
        System.out.println(total);

         */

        /*
        //https://www.linkedin.com/learning/learning-java-collections/creating-a-collection?autoAdvance=true&autoSkip=true&autoplay=true&resume=false&u=26281682
        Collection <String> col = new ArrayList<String>();
        col.add("Design Pattern");
        col.add("Hibernate");
        col.add("Spring Framework");
        col.add("Collection Interface");
        col.add("Design Pattern");

        System.out.println(col);

        Collection<String> topic = new HashSet<>(col);
        System.out.println(topic);
        Collection<String> topicQueue = new ArrayDeque<>(col);
        System.out.println(topicQueue);
         */

    }
}
