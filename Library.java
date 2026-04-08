import java.util.Hashtable;

/**
 * Represents a library with a searchable collection.
 */
public class Library extends Building {

    private Hashtable<String, Boolean> collection;

    public Library(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.collection = new Hashtable<String, Boolean>();
    }

    /**
     * Overridden to allow jumping between any floors (elevator is standard).
     */
    @Override
    public void goToFloor(int n) {
        System.out.println("Zipping to floor " + n + " via the library elevator.");
        super.goToFloor(n);
    }

    public void addTitle(String title) {
        this.collection.put(title, true);
    }

    /**
     * Standard checkOut (The "Base" method)
     * @param title Book title
     */
    public void checkOut(String title) {
        if (this.collection.containsKey(title)) {
            this.collection.replace(title, false);
            System.out.println("Successfully checked out: " + title);
        } else {
            System.out.println("Error: " + title + " is not in the collection.");
        }
    }

    /**
     * Overloaded checkOut for A8 (The "Extra" method)
     * @param title Book title
     * @param days Number of days until due
     */
    public void checkOut(String title, int days) {
        this.checkOut(title); // This now works because the method above exists!
        System.out.println("--> Reminder: This book is due in " + days + " days.");
    }
    
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + addTitle(t)\n + checkOut(t)\n + checkOut(t, days)");
    }
}