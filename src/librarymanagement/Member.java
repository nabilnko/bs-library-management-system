package librarymanagement;

import java.util.HashSet;
import java.util.Set;

class Member {
    private static int nextId = 1;
    private final String id;
    private String name;
    private String borrowedBookId; // new field

    public Member(String name) {
        this.id = "M" + nextId++;
        this.name = name;
        this.borrowedBookId = ""; // initially none
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getBorrowedBookId() { return borrowedBookId; }
    public void setBorrowedBookId(String bookId) { this.borrowedBookId = bookId; }

    @Override
    public String toString() {
        if (borrowedBookId == null || borrowedBookId.isEmpty())
            return id + " - " + name + " | No book checked out";
        else
            return id + " - " + name + " | Checked out: " + borrowedBookId;
    }

    public String toFileString() {
        return id + "," + name + "," + (borrowedBookId == null ? "" : borrowedBookId);
    }

    public static Member fromFileString(String line) {
        if (line == null || line.trim().isEmpty()) return null;
        String[] parts = line.split(",");
        if (parts.length < 2) return null;

        Member m = new Member(parts[1]);
        // manually set ID to preserve from file
        try {
            java.lang.reflect.Field idField = Member.class.getDeclaredField("id");
            idField.setAccessible(true);
            idField.set(m, parts[0]);
        } catch (Exception ignored) {}

        if (parts.length >= 3)
            m.borrowedBookId = parts[2];

        return m;
    }
}
