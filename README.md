**Description:**

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
