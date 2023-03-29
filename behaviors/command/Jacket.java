package designPatterns.behaviors.command;

public class Jacket {

    private int jacketCnt = 0;

    public Jacket(int inventory) {
        this.jacketCnt = inventory;
    }

    public void placeOrder(int qty){
        if (this.jacketCnt > qty){
            this.jacketCnt -=qty;
            System.out.println("the order has been made! \n*Inventory : " + jacketCnt);

        } else {
            System.out.println(" the inventory of the Jacket is low so the order can't be fulfilled !- \n*Inventory : " + jacketCnt);
        }

    }

    public void returnOrder(int qty){
        this.jacketCnt+=qty;
        System.out.println("the return request has been completed... \n*Inventory : " + jacketCnt);

    }
}
