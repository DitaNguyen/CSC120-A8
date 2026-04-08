/**
 * Represents a general Building with basic navigation functionality.
 * This serves as the parent class for specific building types like House, Library, and Cafe.
 */
public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building

    /**
     * Default constructor: initializes with unknown values and 1 floor.
     */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /**
     * Overloaded constructor with address only.
     * @param address The physical location of the building.
     */
    public Building(String address) {
        this(); 
        this.address = address; 
    }

    /**
     * Overloaded constructor with name and address.
     * @param name The name of the building.
     * @param address The physical location.
     */
    public Building(String name, String address) {
        this(name, address, 1); 
    }

    /**
     * Full constructor: sets all attributes.
     * @param name The name of the building.
     * @param address The physical location.
     * @param nFloors The total number of floors.
     * @throws RuntimeException if nFloors is less than 1.
     */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /* Accessors */

    /** @return The name of the building */
    public String getName() {
        return this.name;
    }

    /** @return The address of the building */
    public String getAddress() {
        return this.address;
    }

    /** @return Total number of floors */
    public int getFloors() {
        return this.nFloors;
    }

    /* Navigation methods */

    /**
     * Sets the active floor to 1 (ground floor).
     * @return The current Building instance.
     */
    public Building enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside " + this.name);
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this;
    }

    /**
     * Resets the active floor to -1.
     * @return null, indicating the user is now outside.
     */
    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside " + this.name);
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" + this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1;
        return null; 
    }

    /**
     * Moves the user to a specific floor.
     * @param floorNum The target floor number.
     */
    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You must enter the building first.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor. Range: 1-" + this.nFloors);
        }
        System.out.println("Moving to floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /** Moves the user up one floor. */
    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    /** Moves the user down one floor. */
    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    /** Prints a list of available interaction methods. */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    /** @return A string representation of the building's details. */
    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    /**
     * Main method for testing Building functionality.
     */
    public static void main(String[] args) {
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.enter();
        fordHall.goToFloor(3);
        fordHall.exit(); // This will throw an error because user is on floor 3!
    }
}