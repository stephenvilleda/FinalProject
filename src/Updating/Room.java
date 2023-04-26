package Updating;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private int id;
    private String name;
    private List<Item> items = new ArrayList<>();
    private List<Exit> exits = new ArrayList<>();

    public Room() {}

    public Room(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
        item.setRoom(this);
    }

    public void removeItem(Item item) {
        items.remove(item);
        item.setRoom(null);
    }

    public List<Exit> getExits() {
        return exits;
    }

    public void addExit(Exit exit) {
        exits.add(exit);
        exit.setSource(this);
    }

    public void removeExit(Exit exit) {
        exits.remove(exit);
        exit.setSource(null);
    }
}
