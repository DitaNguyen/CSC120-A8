import java.util.ArrayList;

/**
 * Represents a residential building with a list of residents.
 */
public class House extends Building {

    private ArrayList<String> residents;
    private boolean hasElevator;

    /**
     * Full constructor for House.
     */
    public House(String name, String address, int nFloors, boolean hasElevator) {
        super(name, address, nFloors);
        this.residents = new ArrayList<String>();
        this.hasElevator = hasElevator;
    }

    /**
     * Accessor for elevator status.
     * @return true if house has an elevator.
     */
    public boolean hasElevator() {
        return this.hasElevator;
    }

    /**
     * Overridden to restrict movement if no elevator is present.
     */
    @Override
    public void goToFloor(int n) {
        if (!this.hasElevator && Math.abs(n - this.activeFloor) > 1) {
            throw new RuntimeException("This house has no elevator. You must use the stairs one floor at a time.");
        }
        super.goToFloor(n);
    }

    /**
     * Overloaded method 1: Move in by name.
     */
    public void moveIn(String name) {
        this.residents.add(name);
        System.out.println(name + " has moved into " + this.name);
    }

    /**
     * Overloaded method 2: Move in with a specific floor assignment.
     */
    public void moveIn(String name, int floor) {
        this.moveIn(name);
        System.out.println("Assigned to room on floor #" + floor);
    }

    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + moveIn(name)\n + moveIn(name, floor)");
    }
}