package librarymanagement;

public interface Borrowable {
    void checkOut();
    void returnItem();
    boolean isAvailable();
}
