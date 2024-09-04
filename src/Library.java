import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public Book searchByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public boolean borrowBook(String isbn, Member member) {
        Book book = searchByIsbn(isbn);
        if (book != null && !book.isBorrowed()) {
            book.borrowBook();
            return true;
        }
        return false;
    }

    public void returnBook(String isbn, Member member) {
        Book book = searchByIsbn(isbn);
        if (book != null && book.isBorrowed()) {
            book.returnBook();
        }
    }

    public List<Book> getBooks() {
        return books;
    }
}
