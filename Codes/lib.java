import java.util.ArrayList;

class Book {
    String title;
    String author;
    String isbn;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public void displayBook() {
        System.out.println("Title: " + title + " | Author: " + author + " | ISBN: " + isbn);
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Added: " + book.title);
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        System.out.println("\n--- All Books ---");
        for (Book book : books) {
            book.displayBook();
        }
    }
}

public class lib {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "978-0061935466"));
        library.addBook(new Book("1984", "George Orwell", "978-0451524935"));

        library.displayAllBooks();

        Book found = library.searchByTitle("1984");
        if (found != null) { found.displayBook(); }
        else { System.out.println("Not found."); }
    }
}