package controller;

import gameExceptions.GameException;

public class Room<String> {

    private int roomId;
    private String roomName;

    private String roomdescription;

    private ArrayList<interger> items;

    private boolean roomvisited;


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

    public String getDescription() {
        return this.description;
    }

    public ArrayList<Integer> getItems() {
        return this.items;
    }

    public void setItems(ArrayList<Integer> items) {
        this.items = items;
    }

    public boolean isRoomvisitedVisited() {
        return this.roomvisited;
    }

    public void setRoomvisitedVisited(boolean roomvisited) {
        this.roomvisited = roomvisited;
    }


    public <String> String display() throws GameException {
        return buildDescription() + buildItems() + displayExits();
    }

    private String buildDescription() {
        StringBuilder sb = new StringBuilder();
        if (!isVisited())
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

    private String buildItems() throws GameException {
        StringBuilder sb = new StringBuilder();
        if (items.isEmpty())
            return "";
        sb.append("\n").append("You notice");
        int count = 1;
        for (int i : items) {
            if (items.size() != 1 && count == items.size())
                sb.append(" and");

            if ("AEIOUaeiou".indexOf(
                    idb.getItem(i).getItemName().charAt(0)) != -1) //checks if the item starts with a vowel
                sb.append(" an ");
            else
                sb.append(" a ");

            sb.append(idb.getItem(i).getItemName());

            if (items.size() != 1 && count != items.size())
                sb.append(",");

            count++;
        }
        sb.append(" in this room.\n");
        return sb.toString();
    }

    private String displayExits() {
        ArrayList<Exit> exitList = exits.iterator().next();
        if (exitList.isEmpty())
            return "";
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("You can go ");
        int count = 1;
        for (Exit exit : exitList) {
            sb.append(exit.getDirection());
            if (exitList.size() > 1 && count != exitList.size())
                if (count < exitList.size() - 1)
                    sb.append(", ");
                else
                    sb.append(", and ");
            count++;
        }
        sb.append(".");
        return sb.toString();
    }

    public void dropItem(Item item) throws GameException {
        items.add(item.getItemID());
        updateRoom();
    }

    public void removeItem(Item item) throws GameException {
        for (int j = 0; j < items.size(); j++)
            if (idb.getItem(items.get(j)) == item) {
                items.remove(j);
                break;
            }
        updateRoom();
    }

    public void updateRoom() throws GameException {
        RoomDB.getInstance().updateRoom(this);
    }

    public Room retrieveByID(int roomNum) throws GameException {
        return rdb.getRoom(roomNum);
    }

    public int validDirection(String cmd) throws GameException {
        for (ArrayList<Exit> exitList : exits)
            for (Exit exit : exitList)
                if (exit.getDirection().substring(0, 1).equalsIgnoreCase(cmd))
                    return exit.getDestination();
        throw new GameException();
    }

    @Override()
    public String toString() {
        return "Room{" +
                "roomID=" + roomId +
                ", name='" + roomName + '\'' +
                ", description='" + roomdescription + '\'' +
                ", items=" + items +
                ", visited=" + roomvisited +
                ", exits=" + exits +
                '}';


    }

}
