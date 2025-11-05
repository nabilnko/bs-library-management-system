package librarymanagement;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Library {
    private List<Book> books = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private static final String BOOK_FILE = "books.txt";
    private static final String MEMBER_FILE = "members.txt";

    public Library() {
        loadBooks();
        loadMembers();
    }

    // === Add or update book ===
    public void addBook(Book newBook) {
        Optional<Book> existing = books.stream()
                .filter(b -> b.getId().equals(newBook.getId()) && b.getTitle().equalsIgnoreCase(newBook.getTitle()))
                .findFirst();

        if (existing.isPresent()) {
            existing.get().increaseCount();
            System.out.println("Book already exists — increased copy count.");
        } else {
            books.add(newBook);
            System.out.println("New book added successfully.");
        }
        saveBooks();
    }

    public void addMember(Member m) {
        members.add(m);
        saveMembers();
    }

    // === Check out and return ===
    public void checkOutBook(String bookId, String membername) {
        Optional<Member> member = members.stream()
                .filter(m -> m.getName().equals(membername))
                .findFirst();

        if (member.isEmpty()) {
            System.out.println("Member ID not found. Cannot check out book.");
            return;
        }

        Member m = member.get();
        if (m.getBorrowedBookId() != null && !m.getBorrowedBookId().isEmpty()) {
            System.out.println("Member already has a checked-out book (" + m.getBorrowedBookId() + ").");
            return;
        }

        Optional<Book> book = books.stream()
                .filter(b -> b.getId().equals(bookId) && b.isAvailable())
                .findFirst();

        if (book.isEmpty()) {
            System.out.println("Book not found or no copies available.");
            return;
        }

        book.get().checkOut();
        m.setBorrowedBookId(bookId);

        System.out.println("Book checked out successfully to member: " + m.getName());
        saveBooks();
        saveMembers();
    }


    public void returnBook(String id) {
        Optional<Book> bookOpt = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();

        if (bookOpt.isEmpty()) {
            System.out.println("Book ID not found.");
            return;
        }

        Book book = bookOpt.get();
        book.returnItem();

        // Find member who borrowed it
        members.stream()
                .filter(m -> id.equals(m.getBorrowedBookId()))
                .findFirst()
                .ifPresent(m -> m.setBorrowedBookId(""));

        System.out.println("Book returned successfully!");
        saveBooks();
        saveMembers();
    }

    // === File handling ===
    private void saveBooks() {
        try (PrintWriter out = new PrintWriter(new FileWriter(BOOK_FILE))) {
            books.forEach(b -> out.println(b.toFileString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveMembers() {
        try (PrintWriter out = new PrintWriter(new FileWriter(MEMBER_FILE))) {
            members.forEach(m -> out.println(m.toFileString()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadBooks() {
        File f = new File(BOOK_FILE);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            books = br.lines().map(Book::fromFileString).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadMembers() {
        File f = new File(MEMBER_FILE);
        if (!f.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            members = br.lines().map(Member::fromFileString).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // === Display ===
    public void listBooks() {
        if (books.isEmpty()) System.out.println("No books available.");
        else books.forEach(System.out::println);
    }

    public void listMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        for (Member m : members) {
            String borrowedId = m.getBorrowedBookId();
            if (borrowedId == null || borrowedId.isEmpty()) {
                System.out.println(m.getId() + " - " + m.getName() + " | No book checked out");
            } else {
                String bookTitle = books.stream()
                        .filter(b -> b.getId().equals(borrowedId))
                        .map(Book::getTitle)
                        .findFirst()
                        .orElse("Unknown Title");
                System.out.println(m.getId() + " - " + m.getName() +
                        " | Checked out: [" + borrowedId + "] " + bookTitle);
            }
        }
    }
}
