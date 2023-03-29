package dataStructureAlgorithms.collection.LinkedList;

import dataStructureAlgorithms.collection.Room;
import dataStructureAlgorithms.collection.RoomNode;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LinkedRoomService {
    private RoomNode head;
    private Collection <Room> rooms;
    private List<Room> syncRooms;

    public LinkedRoomService() {
        rooms = new LinkedList();
        syncRooms = Collections.synchronizedList(new LinkedList());
    }

    public void insertAtHead(Room aRoom){
        //instantiate a new node
        RoomNode newNode = new RoomNode(aRoom);
        //set current node as old Node(figuratively)
        newNode.setNextNode(this.head);
        //and link to new node as head of the list
        this.head = newNode;

    }//end insertAtHead

/*

    public void RateAscendOrder(){

        RoomNode current = this.head;
        while(current != null){
            RoomNode nextNode = current.getNextNode();
            if(nextNode != null) {
                //nextNode = current.getNextNode();
                double currentRate = current.getRoom().getRate();
                double nextRate = nextNode.getRoom().getRate();
                //double nextRate = current.getNextNode().getRoom().getRate();
                //if current room rate is bigger than next
                if (currentRate > nextRate) {
                    //store the current room in temp
                    Room tempRoom = current.getRoom();
                    //Swap - store the nextRoom as head
                    current.setRoom(nextNode.getRoom());
                    current.getNextNode().setRoom(tempRoom);
                }
            }
            current = current.getNextNode();
        }

    }

*/

    public void removeHead(){
        //by point to next node the current head lost link to next node and get garbage collection
        this.head = this.head.getNextNode();
    }

    public int length(){
        int length = 0;
        RoomNode current = this.head;
        while(current != null){
            current = current.getNextNode();
            length++;
        }
        return length;
    }

    public RoomNode findNode(Room aroom){
        RoomNode current = this.head;
        while(current != null){
            if(current.getRoom() == aroom){
                return current;
            }
            current = current.getNextNode();
        }
        return null;
    }

    public String toSting(){
        String result = "";
        RoomNode current = this.head;
        while (current != null){
            result +=current.getRoom().toString() + ",\n";
            current = current.getNextNode();
        }
        return result;
    }//end toSTring

    //linkedlist API implementation samples
    public void insertElement(Room aroom){
        syncRooms.add(aroom);
    }

    public Room getAroom(int index){
        return syncRooms.get(index);
    }

    public String toStringForSync(){
        String s = "Syncronized LinkedList : \n";
        s+= syncRooms.toString();
        return s;
    }//

}
