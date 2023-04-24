package Updating;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Connection connection;

    public Game() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:game.db");
        createTables();
    }

    private void createTables() throws SQLException {
        try (Statement stmt = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS room (\n"
                    + " id INTEGER PRIMARY KEY,\n"
                    + " name TEXT NOT NULL\n"
                    + ");";
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS exit (\n"
                    + " id INTEGER PRIMARY KEY,\n"
                    + " direction TEXT NOT NULL,\n"
                    + " source_id INTEGER NOT NULL,\n"
                    + " destination_id INTEGER NOT NULL,\n"
                    + " FOREIGN KEY (source_id) REFERENCES room(id),\n"
                    + " FOREIGN KEY (destination_id) REFERENCES room(id)\n"
                    + ");";
            stmt.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS item (\n"
                    + " id INTEGER PRIMARY KEY,\n"
                    + " name TEXT NOT NULL,\n"
                    + " room_id INTEGER NOT NULL,\n"
                    + " FOREIGN KEY (room_id) REFERENCES room(id)\n"
                    + ");";
            stmt.execute(sql);
        }
    }

    public List<Room> getAllRooms() throws SQLException {
        List<Room> rooms = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            String sql = "SELECT * FROM room";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                rooms.add(room);
            }
        }
        return rooms;
    }

    public List<Exit> getAllExits() throws SQLException {
        List<Exit> exits = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            String sql = "SELECT * FROM exit";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Exit exit = new Exit();
                exit.setId(rs.getInt("id"));
                exit.setDirection(rs.getString("direction"));

                int sourceId = rs.getInt("source_id");
                Room source = getRoomById(sourceId);
                exit.setSource(source);

                int destinationId = rs.getInt("destination_id");
                Room destination = getRoomById(destinationId);
                exit.setDestination(destination);

                exits.add(exit);
            }
        }
        return exits;
    }

    public List<Item> getAllItems() throws SQLException {
        List<Item> items = new ArrayList<>();
        try (Statement stmt = connection.createStatement()) {
            String sql = "SELECT * FROM item";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setName(rs.getString("name"));

                int roomId = rs.getInt("room_id");
                Room room = getRoomById(roomId);
                item.setRoom(room);

                items.add(item);
            }
        }
        return items;
    }

    public Room getRoomById(int id) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM room WHERE id = ?")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Room room = new Room();
                room.setId(rs.getInt("id"));
                room.setName(rs.getString("name"));
                return room;
            }
        }
        return null;
    }

    public void addRoom(Room room) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO room (name) VALUES (?)")) {
            pstmt.setString(1, room.getName());
            pstmt.executeUpdate();
        }
    }

}