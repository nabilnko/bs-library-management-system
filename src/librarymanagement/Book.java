package librarymanagement;

public class Book extends LibraryItem implements Borrowable {
    private boolean available = true;
    private int count; // number of copies

    public Book(String id, String title) {
        super(id, title);
        this.count = 1;
    }

    public Book(String id, String title, boolean available, int count) {
        super(id, title);
        this.available = available;
        this.count = count;
    }

    @Override
    public void checkOut() {
        if (available && count > 0) {
            count--;
            if (count == 0) available = false;
        }
    }

    @Override
    public void returnItem() {
        count++;
        available = true;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        count++;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s (%s) - Copies: %d",
                id, title, available ? "Available" : "Checked out", count);
    }

    @Override
    public String toFileString() {
        return id + "," + title + "," + available + "," + count;
    }

    public static Book fromFileString(String line) {
        String[] parts = line.split(",");
        String id = parts[0];
        String title = parts[1];
        boolean available = Boolean.parseBoolean(parts[2]);
        int count = Integer.parseInt(parts[3]);
        return new Book(id, title, available, count);
    }
}
