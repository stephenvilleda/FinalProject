package controller;

import interfaces.IDisplay;

import java.util.ArrayList;

public class Player implements IDisplay
{
    private Room curRoom;
    private ArrayList<Item> inventory;

    //<editor-fold desc="Getters & Setters">
    public Room getCurRoom() { return curRoom; }
    public void setCurRoom(Room curRoom) { this.curRoom = curRoom; }
    public ArrayList<Item> getInventory() { return inventory; }
    public void setInventory(ArrayList<Item> inventory) { this.inventory = inventory; }
    //</editor-fold>

    public void addItem(Item item){ this.inventory.add(item); }

    // Used to display the player's inventory
    @Override
    public void display()
    {
        if(inventory.size() > 0)
        {
            int count = 1;

            for(int i = 0; i < inventory.size(); i++)
            {
                System.out.println(count + ". " + inventory.get(i).getName());

                count++;
            }
        }
        else
        {
            System.out.println("You have no items in your inventory");
        }
    }
}
