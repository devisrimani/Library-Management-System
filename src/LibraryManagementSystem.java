public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        // Add some initial books
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565"));
        library.addBook(new Book("1984", "George Orwell", "9780451524935"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "9780061120084"));

        // Display all books
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }

        // Simulate borrowing a book
        Member member = new Member("John Doe", "M001");
        if (library.borrowBook("9780451524935", member)) {
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Could not borrow the book.");
        }

        // Display all books after borrowing
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }

        // Return the borrowed book
        library.returnBook("9780451524935", member);

        // Display all books after returning
        for (Book book : library.getBooks()) {
            System.out.println(book);
        }
    }
}
