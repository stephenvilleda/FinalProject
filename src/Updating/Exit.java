package Updating;

public class Exit {
    private int id;
    private String direction;
    private Room source;
    private Room destination;

    public Exit() {}

    public Exit(int id, String direction, Room source, Room destination) {
        this.id = id;
        this.direction = direction;
        this.source = source;
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Room getSource() {
        return source;
    }

    public void setSource(Room source) {
        this.source = source;
    }

    public Room getDestination() {
        return destination;
    }

    public void setDestination(Room destination) {
        this.destination = destination;
    }
}
