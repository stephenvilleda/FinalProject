package controller;

import java.util.ArrayList;

public class Player
{
    private Room curRoom;
    private ArrayList<Item> inventory;

    //<editor-fold desc="Getters & Setters">
    public Room getCurRoom() { return curRoom; }
    public void setCurRoom(Room curRoom) { this.curRoom = curRoom; }
    public ArrayList<Item> getInventory() { return inventory; }
    public void setInventory(ArrayList<Item> inventory) { this.inventory = inventory; }
    //</editor-fold>
}
