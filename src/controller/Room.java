package controller;

import java.util.ArrayList;
import java.util.Collection;

public class Room
{
    private int id;
    private String name;
    private String description;
    private ArrayList<Item> items;
    private boolean visited;
    private ArrayList<Exit> exits;

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
}
