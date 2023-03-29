package dataStructureAlgorithms.collection.ArrayList;

import dataStructureAlgorithms.collection.Guest;
import dataStructureAlgorithms.collection.Room;

import java.util.ArrayList;
import java.util.List;

public class GuestService {
    private List<Guest> checkinList = new ArrayList<>(100);

    /*
     *  1. Returns a new collection that contains guests from the provided collection
     *  who have indicated the provided room as the first preference in their preferred
     *  room list.
     */
    public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {
        List<Guest> preferRoomGuest = new ArrayList<>();
        for(Guest chgt : guests){
            if(chgt.getPreferredRooms().contains(room)){
                preferRoomGuest.add(chgt);
            }
        }
        return preferRoomGuest;
    }

    /*
     *  2. Adds a guest to the checkinList, placing members of the loyalty program
     *  ahead of those guests not in the program. Otherwise, guests are arranged in the
     *  order they were inserted.
     */
    public void checkIn(Guest guest) {
        //if there is no guest exist, add to the list
            if(checkinList.isEmpty()){
                checkinList.add(guest);
            //if there are someone ahead of this guest...
            } else {
                //and if the guest is not loyalProgram member add to the list (at the end)
                if(!guest.isLoyaltyProgramMember()) {
                    checkinList.add(guest);
                    //if the guest is loydlprogram member...
                } else{
                    //traverse over the checkinlist until find first non loyan program member
                    for (Guest chG : checkinList) {
                        if (!chG.isLoyaltyProgramMember()) {
                            this.swapPosition(chG, guest);
                            break;
                        }//if statement
                    }//for loop
                }//nested if else
            }//if else

    }

    /*
     *  3.  Swaps the position of the two provided guests within the checkinList.
     *  (br - modified to add default action for checkIn method with ) If guests are not currently in the list no action is required.
     * guest1 - first non loyal Program member
     * guest2 - current loyan program member guest
     */
    private void swapPosition(Guest guest1, Guest guest2) {
            System.out.format("swapping %s at %d with %s%n", guest1.getFirstName(), checkinList.indexOf(guest1), guest2.getFirstName());
            int currentIndex = checkinList.indexOf(guest1);
            checkinList.add(currentIndex, guest2);
    }

    public List<Guest> getCheckInList() {
        //return List.copyOf(this.checkinList);
        return this.checkinList;
    }
}
