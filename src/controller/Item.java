package controller;

public class Item
{
    private int id;
    private int roomID;
    private String name;
    private String description;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getRoomID() { return roomID; }
    public void setRoomID(int roomID) { this.roomID = roomID; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
