package ej205;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = new DatabaseConnection("mysql", "localhost:3306/biblioteca", "root", "abc123.");

        Database database = new Database(dbConnection);
        database.createDatabase(true);

        TableCreation tableCreation = new TableCreation(dbConnection);
        tableCreation.createTables();

        FillDatabase fillDatabase = new FillDatabase(dbConnection);
        fillDatabase.fillData();

        Book book = new Book(dbConnection);
        Author author = new Author(dbConnection);
        ClearDatabase clearDatabase = new ClearDatabase(dbConnection);

        System.out.println("Todos los libros:");
        book.getAllBooks();

        System.out.println("\nLibros de un autor/a:");
        book.getBooksByAuthor("Autor1", "Apellido1");

        System.out.println("\nTodos los autores y autoras:");
        author.getAllAuthors();

        System.out.println("\nAutores y autoras con cantidad de libros publicados:");
        author.getAuthorsWithBookCount();

        clearDatabase.clearData();

        dbConnection.closeConnection();
    }
}
