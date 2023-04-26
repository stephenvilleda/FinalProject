package model;

import controller.Room;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class : RoomDB.java
 * This class handles all of the DB interactions for Rooms
 */
public class RoomDB
{
    private static RoomDB instance;

    public static RoomDB getInstance()
    {
        if(instance == null)
        {
            instance = new RoomDB();
        }

        return instance;
    }

    /**
     * Method: getNextRoomID
     * Purpose: gets the next ID for a room
     *
     * @return int
     */
    public int getNextRoomID() throws SQLException
    {
        SQLiteDB sdb = null;

        try
        {
            sdb = new SQLiteDB();
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

        //Get the next room ID
        //This is the max value of the roomNumber column in the Room table plus 1
        //This is the same as the number of rows in the table plus 1
        int next = sdb.getMaxValue("roomNumber", "room") + 1;

        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();

        return next;
    }

    /**
     * Method: getRoom
     * Purpose: Gets a room based upon the supplied ID
     *
     * @param id
     * @return Room
     * @throws SQLException
     */
    public Room getRoom(int id) throws SQLException, ClassNotFoundException
    {
        SQLiteDB sdb = new SQLiteDB();
        Room rm = new Room();
        String sql = "Select * from Room WHERE roomNumber = " + id;
        ResultSet rs = sdb.queryDB(sql);
        if (rs.next())
        {
            System.out.println(rs.getInt("roomNumber"));
            rm.setID(rs.getInt("roomNumber"));
            rm.setName(rs.getString("roomName"));
            rm.setDescription(rs.getString("roomDescription"));
            //rm.setExits(rs.getString("exits"));
        }
        else
        {
            throw new SQLException("Room " + id + " not found");
        }
        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
        return rm;
    }

    /**
     * Method: getAllRooms
     * Purpose: gets all rooms
     *
     * @return ArrayList<Room>
     * @throws SQLException
     */
    public ArrayList<Room> getAllRooms() throws SQLException, ClassNotFoundException
    {
        ArrayList<Room> rooms = new ArrayList<Room>();
        SQLiteDB sdb = new SQLiteDB();
        String sql = "Select * from Room";

        ResultSet rs = sdb.queryDB(sql);

        while (rs.next())
        {
            Room rm = new Room();
            rm.setID(rs.getInt("roomNumber"));
            rm.setName(rs.getString("roomName"));
            rm.setDescription(rs.getString("roomDescription"));
            //rm.setExits(rs.getString("Exits"));
            rooms.add(rm);
        }

        //Close the SQLiteDB connection since SQLite only allows one updater
        sdb.close();
        return rooms;
    }
}
