package controller;

public class Monster {
    private String monsterName;
    private String monsterDescription;

    public Monster(String monsterName, String monsterDescription) {
        this.monsterName = monsterName;
        this.monsterDescription = monsterDescription;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getMonsterDescription() {
        return monsterDescription;
    }

    public void setMonsterDescription(String monsterDescription) {
        this.monsterDescription = monsterDescription;
    }
}
