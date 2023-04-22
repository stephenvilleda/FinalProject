package controller;

import gameExceptions.GameException;

public class Room<String> {

    private int roomId;
    private String roomName;

    private String roomdescription;

    private ArrayList<interger> items;

    private boolean  roomvisited;


    public Room() throws GameException {
        roomId = 1;
        roomName = "";
        roomdescription = "";
    }




    public Room(int id) {
        roomId = id;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomName() {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setRoomdescription(String roomdescription) {
        this.roomdescription = roomdescription;
    }

    public String getDescription()
    {
        return this.description;
    }

    public ArrayList<Integer> getItems()
    {
        return this.items;
    }

    public void setItems(ArrayList<Integer> items)
    {
        this.items = items;
    }

    public boolean isRoomvisitedVisited()
    {
        return this.rvisited;
    }

    public void setRoomvisitedVisited(boolean roomvisited) {
        this.roomvisited = roomvisited;
    }



    public <String> String display() throws GameException
    {
        return buildDescription() + buildItems() + displayExits();
    }

    private String buildDescription()
    {
        StringBuilder sb = new StringBuilder();
        if (! isVisited())
            if (roomID == 1)
                sb.append("You find yourself in the ");
            else
                sb.append("You enter into into the ");
        else
            sb.append("You return to the ");

        sb.append(getRoomName()).append(".\n");
        sb.append(getDescription());
        return sb.toString();
    }
     


}
