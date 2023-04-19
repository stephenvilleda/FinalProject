package controller;

public class Exit {
    private String direction;
    private int destination;

    public Exit(String direction, int destination) {
        this.direction = direction;
        this.destination = destination;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getDestination() {
        return destination;
    }

    public void setDestination(int destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "Exit{" +
                "direction='" + direction + '\'' +
                ", destination=" + destination +
                '}';
    }
}
