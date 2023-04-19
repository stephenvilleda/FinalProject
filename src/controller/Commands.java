package controller;

import java.util.Arrays;
import java.util.List;

public class Commands
{
    protected static final List<Character> VALID_DIRECTIONS = Arrays.asList('W', 'N', 'S', 'E', 'U', 'D');
    protected static final List<Character> ITEM_COMMANDS = Arrays.asList('I', 'R', 'G');

    private Player player;

    public Commands(){ this.player = new Player(); }

    public Player getPlayer(){ return this.player; }
}
