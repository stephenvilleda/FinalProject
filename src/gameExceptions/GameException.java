package gameExceptions;

import java.io.IOException;

public class GameException extends IOException
{
    public GameException(){ super(); }
    public GameException(String message){ super(message); }
}
