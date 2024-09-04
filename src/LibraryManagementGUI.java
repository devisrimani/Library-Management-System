import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibraryManagementGUI {
    private Library library;

    public LibraryManagementGUI() {
        library = new Library();
        initComponents();
    }

    private void initComponents() {
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel titleLabel = new JLabel("Library Management System");
        titleLabel.setBounds(200, 10, 200, 30);
        frame.add(titleLabel);

        JButton addBookButton = new JButton("Add Book");
        addBookButton.setBounds(50, 50, 150, 30);
        frame.add(addBookButton);

        JButton searchTitleButton = new JButton("Search by Title");
        searchTitleButton.setBounds(220, 50, 150, 30);
        frame.add(searchTitleButton);

        JButton searchIsbnButton = new JButton("Search by ISBN");
        searchIsbnButton.setBounds(390, 50, 150, 30);
        frame.add(searchIsbnButton);

        JButton borrowBookButton = new JButton("Borrow Book");
        borrowBookButton.setBounds(50, 100, 150, 30);
        frame.add(borrowBookButton);

        JButton returnBookButton = new JButton("Return Book");
        returnBookButton.setBounds(220, 100, 150, 30);
        frame.add(returnBookButton);

        JButton displayBooksButton = new JButton("Display All Books");
        displayBooksButton.setBounds(390, 100, 150, 30);
        frame.add(displayBooksButton);

        JTextArea displayArea = new JTextArea();
        displayArea.setBounds(50, 150, 490, 200);
        frame.add(displayArea);

        // Add action listeners
        addBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter title:");
                String author = JOptionPane.showInputDialog("Enter author:");
                String isbn = JOptionPane.showInputDialog("Enter ISBN:");
                library.addBook(new Book(title, author, isbn));
                JOptionPane.showMessageDialog(frame, "Book added successfully!");
            }
        });

        searchTitleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = JOptionPane.showInputDialog("Enter title:");
                Book book = library.searchByTitle(title);
                if (book != null) {
                    displayArea.setText(book.toString());
                } else {
                    displayArea.setText("Book not found.");
                }
            }
        });

        searchIsbnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = JOptionPane.showInputDialog("Enter ISBN:");
                Book book = library.searchByIsbn(isbn);
                if (book != null) {
                    displayArea.setText(book.toString());
                } else {
                    displayArea.setText("Book not found.");
                }
            }
        });

        borrowBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = JOptionPane.showInputDialog("Enter ISBN:");
                String memberName = JOptionPane.showInputDialog("Enter member name:");
                String memberId = JOptionPane.showInputDialog("Enter member ID:");
                Member member = new Member(memberName, memberId);
                if (library.borrowBook(isbn, member)) {
                    JOptionPane.showMessageDialog(frame, "Book borrowed successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Could not borrow the book.");
                }
            }
        });

        returnBookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String isbn = JOptionPane.showInputDialog("Enter ISBN:");
                String memberName = JOptionPane.showInputDialog("Enter member name:");
                String memberId = JOptionPane.showInputDialog("Enter member ID:");
                Member member = new Member(memberName, memberId);
                library.returnBook(isbn, member);
                JOptionPane.showMessageDialog(frame, "Book returned successfully!");
            }
        });

        displayBooksButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                StringBuilder booksDisplay = new StringBuilder();
                for (Book book : library.getBooks()) {
                    booksDisplay.append(book.toString()).append("\n");
                }
                displayArea.setText(booksDisplay.toString());
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new LibraryManagementGUI();
    }
}
