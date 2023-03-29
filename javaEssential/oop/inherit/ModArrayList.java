package javaEssential.oop.inherit;

import java.util.ArrayList;

public class ModArrayList<D> extends ArrayList<D> {

    public D getUsingMod(int index){
       int modIndex = Math.abs(index) % this.size();
       return this.get(modIndex);

    }
}
