package controller;

public class Room {

    private int roomId;
    private String roomName;


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
}
