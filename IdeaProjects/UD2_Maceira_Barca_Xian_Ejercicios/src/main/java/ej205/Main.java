package ej205;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String engine = "mysql";
//        String engine = "sqlite";
        String url = "localhost:3306";
        String user = "root";
        String password = "abc123.";

        DatabaseConnection databaseConnection = new DatabaseConnection(engine, url, user, password);

        Database database = new Database(databaseConnection);
        database.createDatabase();

        TableCreation tableCreation = new TableCreation(databaseConnection);
        tableCreation.createTables();

        FillDatabase fillDatabase = new FillDatabase(databaseConnection);
        fillDatabase.insertData();

        Book bookQueries = new Book(databaseConnection);
        Author authorQueries = new Author(databaseConnection);

        System.out.println("Todos los libros:");
        bookQueries.getAllBooks();

        System.out.println("\nLibros de un autor/a:");
        bookQueries.getBooksByAuthor("Autor1", "Apellido1");

        System.out.println("\nTodos los autores y autoras:");
        authorQueries.getAllAuthors();

        System.out.println("\nAutores y autoras con la cantidad de libros que publicaron:");
        authorQueries.getAuthorsWithBookCount();

        ClearDatabase clearDatabase = new ClearDatabase(databaseConnection);
        clearDatabase.clearData();

        databaseConnection.closeConnection();
    }
}