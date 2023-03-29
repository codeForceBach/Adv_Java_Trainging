package genric.genericWildcard;

public class House extends Building{

    public int numberOfRoom = 10;

    public int getNumberOfRoom (){

        return numberOfRoom;
    }

    public void setNumberOfRoom(int roomCtn){

        this.numberOfRoom = roomCtn;
    }

    public String toString(){

        return ("House");
    }
}
