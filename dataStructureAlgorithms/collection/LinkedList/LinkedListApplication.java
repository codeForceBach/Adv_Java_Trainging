package dataStructureAlgorithms.collection.LinkedList;

import dataStructureAlgorithms.collection.Room;

public class LinkedListApplication {

    public static void main(String[] args) {

    Room cambridge = new Room("Cambridge", "Premiere Room", 4, 175.00);
    Room manchester = new Room("Manchester", "Suite", 5, 250.00);
    Room piccadilly = new Room("Piccadilly", "Guest Room", 3, 125.00);
    Room oxford = new Room("Oxford", "Suite", 5, 225.0);
    Room victoria = new Room("Victoria", "Suite", 5, 225.00);
    Room westminister = new Room("Westminister", "Premiere Room", 4, 200.00);

    LinkedRoomService linkedRoom = new LinkedRoomService();
    linkedRoom.insertAtHead(cambridge);
    linkedRoom.insertAtHead(manchester);
    linkedRoom.insertAtHead(piccadilly);
    linkedRoom.insertAtHead(oxford);
    linkedRoom.insertAtHead(victoria);
    linkedRoom.insertAtHead(westminister);

    System.out.println(linkedRoom.toSting());
    System.out.println(linkedRoom.length());

    linkedRoom.removeHead();;
    System.out.println(linkedRoom.toSting());

    System.out.println(linkedRoom.findNode(piccadilly).getRoom().toString());
    //System.out.println(linkedRoom.findNode(westminister));
/*

    linkedRoom.RateAscendOrder();
    System.out.println("Sorted : \n" + linkedRoom.toSting());
*/

        linkedRoom.insertElement(cambridge);
        linkedRoom.insertElement(manchester);
        linkedRoom.insertElement(piccadilly);
        linkedRoom.insertElement(oxford);
        linkedRoom.insertElement(victoria);
        linkedRoom.insertElement(westminister);

        System.out.println(linkedRoom.toStringForSync());
        System.out.println(linkedRoom.getAroom(3).toString());

    }//End main

}

