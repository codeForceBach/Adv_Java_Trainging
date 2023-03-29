package javaEssential.classMethods;

public class proofByCode {
    /*
    1) the "new" operator dynamically allocates memory for an object and returns a reference to it.
    This reference is address in memory of the object allocated by new.

    2)Whe we assign an object to another object of same type,
    all the element of right side of object get copied to the object on the left side
     */

    public static void main(String[] args) {
        Box obj = new Box();
        obj.height = 1;
        obj.length = 5;
        obj.width = 5;
        //System.out.println(obj.height + ", " + obj.length + ", " + obj.width);
        obj.volume(3,2, 1);
        System.out.println(obj.volume);// 6
    }//end main method

    static class Box{
        int height;
        int width;
        int length;
        int volume;

        void volume(int height, int width, int length){
            volume = height*width*length;
        }
    }//end inner class



}//End class
