package controller;

import java.util.ArrayList;
import java.util.Collection;

public class Player {
    private String name;
    private int curRoom;
    private Collection<ArrayList<Item>> inventory;
    public int getCurRoom() {
        return this.curRoom;
    }
    public void setCurRoom(int curRoom) {
        this.curRoom = curRoom;
    }
    public Collection<ArrayList<Item>> getInventory() {
        return this.inventory;
    }
    public void setInventory(Collection<ArrayList<Item>> inventory) {
        this.inventory = inventory;
    }
}
