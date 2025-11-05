package librarymanagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Library library = new Library();
    Scanner sc = new Scanner(System.in);
    int choice;

    do {
        System.out.println("\nLibrary Management System");
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Check Out Book");
        System.out.println("4. Return Book");
        System.out.println("5. List Books");
        System.out.println("6. List Members");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1 -> {
                System.out.print("Enter book ID: ");
                String id = sc.nextLine();
                System.out.print("Enter title: ");
                String title = sc.nextLine();
                library.addBook(new Book(id, title));
            }
            case 2 -> {
                System.out.print("Enter member name: ");
                String name = sc.nextLine();
                library.addMember(new Member(name));
            }
            case 3 -> {
                System.out.print("Enter book ID: ");
                String bookId = sc.nextLine();
                System.out.print("Enter member Name: ");
                String membername = sc.nextLine();
                library.checkOutBook(bookId, membername);
            }

            case 4 -> {
                System.out.print("Enter book ID: ");
                library.returnBook(sc.nextLine());
            }
            case 5 -> library.listBooks();
            case 6 -> library.listMembers();
        }
    } while (choice != 0);

    System.out.println("Exiting system...");
    sc.close();
}
}