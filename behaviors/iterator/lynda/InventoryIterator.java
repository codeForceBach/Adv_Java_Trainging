package designPatterns.behaviors.iterator.lynda;

import java.util.Iterator;

public class InventoryIterator implements Iterator {

    private StationaryInventory inventory;
    private int index;

    public InventoryIterator (StationaryInventory inventory) {
        this.inventory = inventory;
        this.index = 0;
    }

    @Override
    //initialize StationaryItem and if there is more item return true otherwise return false
    public boolean hasNext() {
        StationaryItem [] items = inventory.getItems();
        if (index < items.length){
            return true;
        } else {
            return false;
        }
    }

    @Override
    //initialize StationaryItem array and check if there is next item and so increment index
    //also if quantity is greater than zero return the item.
    public StationaryItem next() {
        StationaryItem [] items = inventory.getItems();
        if(hasNext()) {
            StationaryItem item = items[index++];
            if (item.getPrice() > 4.00 && items[index] != null) {
                return item;
            } else {
                return next();
            }//end if else
        }
            return null;

    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }
}
