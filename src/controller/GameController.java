package controller;

public class GameController
{
    private Commands commands;

    public GameController(){ this.commands = new Commands(); }

    public Commands getCommands(){ return this.commands; }
}
