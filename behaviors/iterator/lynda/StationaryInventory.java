package designPatterns.behaviors.iterator.lynda;

//initialize collection from a class and call customize iterator class in iterator method that implements iterable
public class StationaryInventory implements Iterable {

    private StationaryItem[] items;

    public StationaryInventory(StationaryItem... items) {
        this.items = items;
    }

    public StationaryItem[] getItems() {
        return items;
    }

    @Override
    //return specific implementation of iterator and set class itself as the argument
    public InventoryIterator iterator() {
        return new InventoryIterator(this);
    }
}
