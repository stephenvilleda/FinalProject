package controller;

import gameExceptions.GameException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Commands
{
    protected static final List<Character> VALID_DIRECTIONS = Arrays.asList('W', 'N', 'S', 'E', 'U', 'D');
    protected static final List<Character> ITEM_COMMANDS = Arrays.asList('I', 'R', 'G');

    private Player player;

    public Commands(){ this.player = new Player(); }

    public Player getPlayer(){ return this.player; }

    // Checks whether the player's command matches the string (compare)
    // Can be used for multiple situations if needed
   //
    private boolean commandMatches(String cmd, String compare)
    {
        String letter = String.valueOf(cmd.charAt(0));
        // If the player enters the appropriate command or first letter of the command, return true
        return cmd.length() > 1 && cmd.equalsIgnoreCase(compare) || cmd.length() == 1 && letter.equalsIgnoreCase(String.valueOf(compare));
    }

    public void move(String cmd) throws SQLException, ClassNotFoundException, GameException
    {
        for(Exit e : player.getCurRoom().getExits())
        {
            if(commandMatches(cmd, e.getDirection()))
            {
                player.setCurRoom(player.getCurRoom().retrieveByID(e.getDestination()));
                break;
            }
        }

        player.getCurRoom().display();
    }

    public void pickup()
    {

    }

    public void drop()
    {

    }
}
