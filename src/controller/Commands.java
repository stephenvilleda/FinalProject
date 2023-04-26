package controller;

public class Commands {

    private Player player;

    Commands() {
        this.player = new Player();
    }

    protected  String excuteCommand(String cmd) {
        return cmd;
    }

    private String move(String cmdRoom) {

        return cmdRoom;
    }
}
