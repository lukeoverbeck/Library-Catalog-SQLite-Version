Features:

Display Catalog: View the entire library collection or filter by Books, CDs, or DVDs. Search by Title: Find specific items by entering a title. Add New Items: Supports Books, CDs, or DVDs. CSV Import/Export: Load items from an existing CSV file or export the current catalog to a new or existing CSV file. User-Friendly Interface: Simple menu-based system for easy navigation.

How It Works:

Load Data: The program loads the catalog from an input CSV file (if available). Menu Navigation: Several different options to interact with the library. Add Items: The program prompts for relevant details based on the item type. Search & Display: Can view categorized lists or search by title. Export Data: The catalog can be saved to a CSV file for future use.

File Structure:

LibraryCatalogApp.java: Main entry point for the application. Library.java: Handles catalog management, including adding, searching, and exporting items. LibraryItem.java: Interface for all library items. Book.java, CD.java, DVD.java: Individual item classes with specific attributes.

Library Catalog System

Description:

Java-based application that allows users to manage a collection of books, CDs, and DVDs. The system uses a SQLite database to store and retrieve catalog entries, ensuring data persistence.

Features:

Add books, CDs, and DVDs to the library catalog.

Search for items in the catalog.

Store and retrieve catalog data using a SQLite database.

Separate classes for database management, library operations, and user interface.

Project Structure:

LibraryCatalogApp.java  - Main menu interface for the application.
Library.java            - Handles catalog operations.
Database.java           - Manages SQLite database connection and table creation.

Database Schema:

The application creates three tables: books, cds, and dvds.
Each table has the following structure:

Books Table:

id INTEGER PRIMARY KEY AUTOINCREMENT,
title TEXT NOT NULL,
author TEXT NOT NULL,
year INTEGER NOT NULL

CDs Table:

id INTEGER PRIMARY KEY AUTOINCREMENT,
title TEXT NOT NULL,
artist TEXT NOT NULL,
year INTEGER NOT NULL

DVDs Table:

id INTEGER PRIMARY KEY AUTOINCREMENT,
title TEXT NOT NULL,
director TEXT NOT NULL,
year INTEGER NOT NULL

Setup and Installation:

Install Java (JDK 11 or later).

Install SQLite if not already installed.

Clone the repository:

git clone https://github.com/your-repo/library-catalog.git

Compile the Java files:

javac *.java

Run the application:

java LibraryCatalogApp

Future Enhancements:

I plan on adding a delete function, as well as a graphical user interface (GUI).
