/**
 * Represents a Cafe building that manages inventory and sells coffee.
 * Access is restricted to the ground floor for customers.
 */
public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;

    /**
     * Constructor for Cafe
     * @param name The name of the cafe
     * @param address The address of the cafe
     */
    public Cafe(String name, String address) {
        super(name, address, 1); // Cafes are 1 floor by default
        this.nCoffeeOunces = 100;
        this.nSugarPackets = 50;
        this.nCreams = 50;
        this.nCups = 50;
    }

    /**
     * Overridden to prevent customers from leaving the 1st floor.
     * @param n The target floor
     */
    @Override
    public void goToFloor(int n) {
        if (n != 1) {
            throw new RuntimeException("Sorry, floors above the 1st are for employees only.");
        }
        super.goToFloor(n);
    }

    /**
     * Overloaded sellCoffee for A8 (Standard black coffee)
     * @param size Ounces of coffee requested
     */
    public void sellCoffee(int size) {
        this.sellCoffee(size, 0, 0);
    }
    
    /**
     * Full sellCoffee method (Original from A7)
     * @param size Ounces of coffee
     * @param sugar Number of sugar packets
     * @param cream Number of cream splashes
     */
    public void sellCoffee(int size, int sugar, int cream) {
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= sugar;
        this.nCreams -= cream;
        this.nCups -= 1;
        
        // This line now "uses" every single field, which clears all warnings:
        System.out.println("Brewed " + size + "oz coffee with " + sugar + " sugar and " + cream + " cream.");
        System.out.println("Inventory: " + this.nCoffeeOunces + "oz left, " + 
                           this.nSugarPackets + " sugars left, " + 
                           this.nCreams + " creams left, " + 
                           this.nCups + " cups left.");
    }

    /**
     * Displays the unique options available at the Cafe.
     */
    @Override
    public void showOptions() {
        super.showOptions();
        System.out.println(" + sellCoffee(size)\n + sellCoffee(size, sugar, cream)");
    }
}