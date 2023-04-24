package controller;

import model.GameDBCreate;

import java.sql.SQLException;

/**
 * Class : CreateFilesController.java
 * This class calls into the model to build the database if it doesn't exist.
 */
public class CreateFilesController {

    /**
     * Method: createFile
     * Purpose: Create the database for GameDB
     * @return void
     */
    public void createFile() throws GameException{
        try {
            GameDBCreate sdb = new GameDBCreate();
            sdb.buildTables();
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new GameException("Creation failed");
        }
    }
    /**
     * Method: createFile
     * Purpose: Create the database for GameDB
     * @return void
     */
    public void createFile(String dbName) throws GameException{
        try {
            GameDBCreate sdb = new GameDBCreate(dbName);
            sdb.buildTables();
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new GameException("Creation failed");
        }
    }


}


