package controller;

import gameExceptions.GameException;
import interfaces.IDisplay;
import model.RoomDB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class Room implements IDisplay
{
    private int id;
    private String name;
    private String description;
    private ArrayList<Item> items;
    private boolean visited;
    private ArrayList<Exit> exits;
    private RoomDB rdb;

    //<editor-fold desc="Getters & Setters">
    public int getID() { return id; }
    public void setID(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public ArrayList<Item> getItems() { return items; }
    public void setItems(ArrayList<Item> items) { this.items = items; }
    public void addItem(Item item) { items.add(item); }
    public boolean hasVisited() { return visited; }
    public void setVisited(boolean visited) { this.visited = visited; }
    public Collection<Exit> getExits() { return exits; }
    public void setExits(ArrayList<Exit> exits) { this.exits = exits; }
    public void addExit(Exit exit) { this.exits.add(exit); }
    //</editor-fold>

    public Room getRoom(int id) throws SQLException, ClassNotFoundException
    {
        rdb = RoomDB.getInstance();
        return rdb.getRoom(id);
    }

    public ArrayList<Room> getAllRooms() throws SQLException, ClassNotFoundException
    {
        RoomDB rdb = RoomDB.getInstance();
        return rdb.getAllRooms();
    }

    @Override
    public void display()
    {
        System.out.println(name + " - " + description);

        if(visited)
        {
            System.out.println("You have already visited this area.");
        }
        else
        {
            System.out.println("This is your first time visiting this area");
        }

        System.out.println("There are " + exits.size() + " exits available. You can go: ");

        for(Exit e : exits)
        {
            System.out.println(e.getDirection());
        }
    }

    public Room retrieveByID(int id) throws GameException, SQLException, ClassNotFoundException { return rdb.getRoom(id); }

    public void setRoomID(int roomNumber) {
    }
}
