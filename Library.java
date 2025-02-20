import java.sql.*;
import java.util.Scanner;
import java.sql.SQLException;

public class Library {

    private final Connection connection;

    public Library(Connection connection) {
        this.connection = connection;
    } // end constructor

    // Print out the catalog
    public void displayLibraryCatalog() {

        displayBooks();
        displayCDs();
        displayDVDs();

    } // end displayLibraryCatalog

    // Print out books only
    public void displayBooks() {

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM books");
            bookSearchShortcut(rs);
        } catch (SQLException e) {
            System.err.println("Error loading book catalog: " + e.getMessage());
        } // end catch block

    } // end displayBooks

    // Print out CDs only
    public void displayCDs() {

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM cds");
            CDSearchShortcut(rs);
        } catch (SQLException e) {
            System.err.println("Error loading CD catalog: " + e.getMessage());
        } // end catch block

    } // end displayCDs

    // Print out DVDs only
    public void displayDVDs() {

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM dvds");
            DVDSearchShortcut(rs);
        } catch (SQLException e) {
            System.err.println("Error loading DVD catalog: " + e.getMessage());
        } // end catch block

    } // end displayDVDs

    public void searchByTitle(String entryTitle) {

        bookByTitle(entryTitle);
        CDByTitle(entryTitle);
        DVDByTitle(entryTitle);

    } // end searchByTitle

    public void bookByTitle(String entryTitle) {

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM books WHERE title LIKE ?");
            stmt.setString(1, entryTitle);
            ResultSet rs = stmt.executeQuery();
            bookSearchShortcut(rs);
        } catch (SQLException e) {
            System.err.println("Error loading book catalog: " + e.getMessage());
        } // end catch block
    } // end bookByTitle

    private void bookSearchShortcut(ResultSet rs) throws SQLException {

        boolean found = false;

        while (rs.next()) {
            found = true;
            String id = rs.getString(1);
            String title = rs.getString(2);
            int year = rs.getInt(3);
            String author = rs.getString(4);
            String isbn = rs.getString(5);
            System.out.println("\nID: " + id + "\nTitle: " + title + "\nYear: " + year
                    + "\nAuthor: " + author + "\nISBN: " + isbn);
        } // end while loop
        if (!found) {
            System.out.println("\nNo books found.");
        } // end if statement
    } // end bookSearchShortcut

    public void CDByTitle(String entryTitle) {

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM cds WHERE title LIKE ?");
            stmt.setString(1, entryTitle);
            ResultSet rs = stmt.executeQuery();
            CDSearchShortcut(rs);
        } catch (SQLException e) {
            System.err.println("Error loading book catalog: " + e.getMessage());
        } // end catch block
    } // end CDByTitle

    private void CDSearchShortcut(ResultSet rs) throws SQLException {

        boolean found = false;

        while (rs.next()) {
            found = true;
            String id = rs.getString(1);
            String title = rs.getString(2);
            int year = rs.getInt(3);
            String artist = rs.getString(4);
            int numOfTracks = rs.getInt(5);
            System.out.println("\nID: " + id + "\nTitle: " + title + "\nYear: " + year
                    + "\nArtist: " + artist + "\nnumOfTracks: " + numOfTracks);
        } // end while loop
        if (!found) {
            System.out.println("\nNo CDs found.");
        } // end if statement
    } // end CDSearchShortcut

    public void DVDByTitle(String entryTitle) {

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM dvds WHERE title LIKE ?");
            stmt.setString(1, entryTitle);
            ResultSet rs = stmt.executeQuery();
            DVDSearchShortcut(rs);
        } catch (SQLException e) {
            System.err.println("Error loading book catalog: " + e.getMessage());
        } // end catch block
    } // end DVDByTitle

    private void DVDSearchShortcut(ResultSet rs) throws SQLException {

        boolean found = false;

        while (rs.next()) {
            found = true;
            String id = rs.getString(1);
            String title = rs.getString(2);
            int year = rs.getInt(3);
            String director = rs.getString(4);
            int duration = rs.getInt(5);
            System.out.println("\nID: " + id + "\nTitle: " + title + "\nYear: " + year
                    + "\nDirector: " + director + "\nDuration: " + duration);
        } // end while loop
        if (!found) {
            System.out.println("\nNo DVDs found.");
        } // end if statement
    } // end DVDSearchShortcut

    // Add a library item to the catalog
    public void addItem(int itemType) {

        switch (itemType) {
            case 1:
                addBook();
                break;
            case 2:
                addCD();
                break;
            case 3:
                addDVD();
                break;
            default:
                System.out.println("Invalid item type.");
                break;
        } // end switch

    } // end addItem

    // Add a book to the catalog
    private void addBook() {

        try {
            Scanner scan = new Scanner(System.in);
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO books (title, year, author, isbn) " +
                    "VALUES (?,?,?,?)");
            titleAndYear(scan, stmt);

            System.out.print("Enter author: ");
            String author = scan.nextLine();
            stmt.setString(3, author);

            System.out.print("Enter ISBN: ");
            String isbn = scan.nextLine();
            stmt.setString(4, isbn);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding a book: " + e.getMessage());
        } // end catch block

    } // end addBook

    // Add a CD to the catalog
    private void addCD() {

        try {
            Scanner scan = new Scanner(System.in);
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO cds (title, year, artist, numOfTracks) " +
                    "VALUES (?,?,?,?)");
            titleAndYear(scan, stmt);

            System.out.print("Enter artist: ");
            String artist = scan.nextLine();
            stmt.setString(3, artist);

            System.out.print("Enter number of tracks: ");
            int numOfTracks = scan.nextInt();
            stmt.setInt(4, numOfTracks);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding a book: " + e.getMessage());
        } // end catch block

    } // end addCD

    // Add a DVD to the catalog
    private void addDVD() {

        try {
            Scanner scan = new Scanner(System.in);
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO dvds (title, year, director, duration) " +
                    "VALUES (?,?,?,?)");
            titleAndYear(scan, stmt);

            System.out.print("Enter director: ");
            String director = scan.nextLine();
            stmt.setString(3, director);

            System.out.print("Enter duration: ");
            int duration = scan.nextInt();
            stmt.setInt(4, duration);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error adding a book: " + e.getMessage());
        } // end catch block

    } // end addDVD

    private void titleAndYear(Scanner scan, PreparedStatement stmt) throws SQLException {
        System.out.print("Enter title: ");
        String title = scan.nextLine();
        stmt.setString(1, title);

        System.out.print("Enter year: ");
        int year = scan.nextInt();
        scan.nextLine();
        stmt.setInt(2, year);
    } // end titleAndYear

} // end class
