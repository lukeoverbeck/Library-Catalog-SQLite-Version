import java.util.*;
import java.sql.Connection;

public class LibraryCatalogApp {

    public static void main(String[] args) {

        Database db = new Database();
        Connection connection = db.getConnection();

        // Initialize library catalog
        Library library = new Library(connection);

        // Main menu loop
        while (true) {
            displayMenu();
            int choice = getUserChoice();
            handleUserChoice(choice, library, db);
        } // end while loop

    } // end main

    // Display the menu options
    private static void displayMenu() {
        System.out.println("\nMain Menu: ");
        System.out.println("1. Display Entire Library Catalog");
        System.out.println("2. Display Books only");
        System.out.println("3. Display CDs only");
        System.out.println("4. Display DVDs only");
        System.out.println("5. Search by Title");
        System.out.println("6. Add a new item");
        System.out.println("7. Exit\n");
    } // end displayMenu

    // Get user's menu choice
    private static int getUserChoice() {
        try {
            Scanner scan = new Scanner(System.in);
            return scan.nextInt();
        } catch (InputMismatchException e) {
            return 0;
        }
    } // end getUserChoice

    // Uses an Integer, Runnable HashMap to handle user choice
    private static void handleUserChoice(int choice, Library library, Database db) {

        Map<Integer, Runnable> menu = new HashMap<>();

        menu.put(1, library::displayLibraryCatalog);
        menu.put(2, library::displayBooks);
        menu.put(3, library::displayCDs);
        menu.put(4, library::displayDVDs);
        menu.put(5, () -> {
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter the title: ");
            String title = scan.nextLine();
            library.searchByTitle(title);
        });
        menu.put(6, () -> {
            Scanner scan = new Scanner(System.in);
            System.out.println("""
                    Please enter the type of item you would like to add:\s
                    1. Book\s
                    2. CD\s
                    3. DVD""");
            int type = scan.nextInt();
            library.addItem(type);
        });
        menu.put(7, () -> {
            db.closeConnection();
            System.exit(0);
        });

        Runnable runnable = menu.get(choice);
        if (runnable != null) {
            runnable.run();
        } else {
            System.out.println("\nInvalid choice: please enter a number 1-7.");
        } // end else statement

    } // end handleUserChoice

} // end class
