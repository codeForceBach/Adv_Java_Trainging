package dataStructureAlgorithms.collection;

public class RoomNode {

    private Room room;
    private RoomNode nextNode;

    public RoomNode(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public RoomNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(RoomNode nextNode) {
        this.nextNode = nextNode;
    }
}
