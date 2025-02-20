import java.sql.*;

public class Database {

    private static final String URL = "jdbc:sqlite:library_catalog.db";

    private Connection connection;

    public Database() {
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Connected to database");
            createTables();
        } catch (SQLException e) {
            System.out.println("Failed to connect to database" + e.getMessage());
        } // end catch block
    } // end constructor

    public Connection getConnection() {
        return connection;
    } // end getConnection();

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Connection closed");
            } // end if statement
        } catch (SQLException e) {
            System.out.println("Failed to close connection" + e.getMessage());
        } // end catch block
    } // end closeConnection

    public void createTables() {
        String createTableSQLBooks = "CREATE TABLE IF NOT EXISTS books (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "year INTEGER NOT NULL," +
                "author TEXT NOT NULL," +
                "isbn TEXT NOT NULL" +
                ");";
        String createTableSQLCDs = "CREATE TABLE IF NOT EXISTS cds (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "year INTEGER NOT NULL," +
                "artist TEXT NOT NULL," +
                "numOfTracks INTEGER NOT NULL" +
                ");";
        String createTableSQLDVDs = "CREATE TABLE IF NOT EXISTS dvds (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT NOT NULL," +
                "year INTEGER NOT NULL," +
                "director TEXT NOT NULL," +
                "duration INTEGER NOT NULL" +
                ");";

        try {
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQLBooks)) {
                preparedStatement.executeUpdate();
            } // end try block

            // Create the CDs table
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQLCDs)) {
                preparedStatement.executeUpdate();
            } // end try block

            // Create the DVDs table
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQLDVDs)) {
                preparedStatement.executeUpdate();
            } // end try block


        } catch (SQLException e) {
            System.out.println("Failed to create tables" + e.getMessage());
        } // end catch block
    } // end createTables

} // end class
