package controller;

import gameExceptions.GameException;
import model.RoomDB;

public class Commands {
//added for practice
    public static final int EXIT_COMMAND = 5;
    protected static final List<Character> VALID_DIRECTIONS = Arrays.asList('W', 'N', 'S', 'E', 'U', 'D');
    protected static final List<String> VALID_DIRECTIONS_LONG = Arrays.asList("WEST", "NORTH", "SOUTH",
            "EAST", "UP", "DOWN");
    protected static final List<Character> ITEM_COMMANDS = Arrays.asList('I', 'R', 'G');
    protected static final List<String> ITEM_COMMANDS_LONG = Arrays.asList("INSPECT", "REMOVE", "GRAB");
    private final Player player;
    private boolean endGame;

    Commands() {
        this.player = new Player();
    }

    Commands(Player player)
    {
        this.player = player;
        player.setCurRoom(1);
    }

    private int validateCommand(String cmdLine) throws GameException
    {
        String[] tokens = cmdLine.split(" ");
        String command = tokens[0];
        if (cmdLine.isEmpty())
            throw new GameException("Please enter a valid command.");
        char cmdChar = ' ';
        if (command.length() == 1)
            cmdChar = Character.toUpperCase(command.charAt(0));

        if (VALID_DIRECTIONS.contains(cmdChar) || VALID_DIRECTIONS_LONG.contains(command.toUpperCase()))
            return 1;
        else if (ITEM_COMMANDS.contains(cmdChar) || ITEM_COMMANDS_LONG.contains(command.toUpperCase()))
            return 2;
        else if (cmdChar == 'L' || command.equalsIgnoreCase("Look"))
            return 3;
        else if (cmdChar == 'B' || command.equalsIgnoreCase("Backpack"))
            return 4;
        else if (cmdChar == 'X')
            return EXIT_COMMAND;
        else
            throw new GameException(command + " is not a valid command");
    }



    protected String executeCommand(String cmd) throws GameException
    {
        int cmdType = validateCommand(cmd);
        switch (cmdType)
        {
            case 1:
                return move(cmd.toLowerCase());
            case 2:
                return itemCommand(cmd.toLowerCase());
            case 3:
                return RoomDB.getInstance().getRoom(player.getCurRoom()).display();
            case 4:
                return player.printInventory();
            case EXIT_COMMAND:
                return "Exiting game...";
            default:
                throw new GameException(cmd + " is not a valid command.");
        }
    }



    private String move(String cmdRoom) throws GameException
    {
        Room currentRoom = RoomDB.getInstance().getRoom(player.getCurRoom());
        String[] parts = cmdRoom.split(" ");
//        String direction = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase();
        String dir = parts[0].substring(0, 1);
        String roomString;
        try
        {
            int nextRoomID = currentRoom.validDirection(dir);
            player.setCurRoom(nextRoomID);
            Room nextRoom = RoomDB.getInstance().getRoom(player.getCurRoom());
            roomString = nextRoom.display();
            if (nextRoom.getExits().iterator().next().isEmpty())
                setEndGame(true);
            nextRoom.setVisited(true);
        } catch (GameException ge)
        {
            throw new GameException("You cannot go that way.");
        }
        return roomString;
    }


    private String itemCommand(String cmd) throws GameException {
        // split the command into command and argument
        String[] parts = cmd.split(" ");
        String command = parts[0].toUpperCase(); //this is more efficient than substring
        String argument = "";
        if (parts.length > 1) {
            argument = String.join(" ", Arrays.copyOfRange(parts, 1, parts.length)).toUpperCase();
        }
        // perform the appropriate action based on the command
        Room room = RoomDB.getInstance().getRoom(player.getCurRoom());
        switch (command) {
            case "G":
                return grab(argument, room);
            case "R":
                return remove(argument, room);
            case "I":
                return inspectItem(argument, room);
            default:
                throw new GameException(command + " is not a valid command");
        }
    }

    private String remove(String cmd, Room room) throws GameException
    {
        // TODO - cmd is a String. You need to extract the Item from the String before having the player drop it.

        for (Item item : player.getInventory().iterator().next())
            if (item.getItemName().equalsIgnoreCase(cmd))
            {
                player.removeItem(item);
                room.dropItem(item);
                return "You have dropped " + item.getItemName() + "\n";
            }
        throw new GameException("You do not have " + cmd + " in your inventory.");
    }

    private String inspectItem(String cmd, Room room) throws GameException
    {
        for (Item item : room.getRoomItems())
            if (item.getItemName().equalsIgnoreCase(cmd))
                return item.display();
        if (room.getDescription().toLowerCase().contains(cmd.toLowerCase()))
            return "You see a " + cmd + "\n";
        throw new GameException("You don't see " + cmd);
    }


}
