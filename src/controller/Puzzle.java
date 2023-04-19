package controller;

public class Puzzle
{
    private int roomID;
    private String prompt;
    private String answer;

    public Puzzle(int roomID, String prompt, String answer)
    {
        this.roomID = roomID;
        this.prompt = prompt;
        this.answer = answer;
    }

    public String getPrompt(){ return this.prompt; }
    public void setPrompt(String prompt){ this.prompt = prompt; }
    public String getAnswer(){ return this.answer; }
    public void setAnswer(String answer){ this.answer = answer; }
}
