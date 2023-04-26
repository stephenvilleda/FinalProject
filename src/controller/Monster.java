package controller;

public class Monster
{
    private int monsterID;
    private String monsterName;
    private String description;

    public Monster()
    {

    }

    public Monster(int monsterID, String monsterName, String description)
    {
        this.monsterID = monsterID;
        this.monsterName = monsterName;
        this.description = description;
    }

    //<editor-fold desc="Getters & Setters">
    public int getMonsterID(){ return this.monsterID; }
    public void setMonsterID(int monsterID){ this.monsterID = monsterID; }
    public String getMonsterName(){ return this.monsterName; }
    public void setMonsterName(String monsterName){ this.monsterName = monsterName; }
    public String getMonsterDescription(){ return this.description; }
    public void setMonsterDescription(String description){ this.description = description; }
    //</editor-fold>
}
