import java.util.ArrayList;

/**
 * Aggregates various Building types into a single map representation.
 * Manages the directory of buildings on campus.
 */
public class CampusMap {

    ArrayList<Building> buildings;

    /**
     * Default constructor, initializes empty ArrayList.
     */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map.
     * @param b the Building to add.
     */
    public void addBuilding(Building b) {
        buildings.add(b);
    }

    /**
     * Removes a Building from the map.
     * @param b the Building to remove.
     * @return the removed Building.
     */
    public Building removeBuilding(Building b) {
        buildings.remove(b);
        return b;
    }

    /**
     * Returns a formatted directory of all buildings in the map.
     * @return String representation of the map.
     */
    @Override
    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";
        for (int i = 0; i < this.buildings.size(); i++) {
            mapString += "\n  " + (i + 1) + ". " + this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    /**
     * Main execution point to demonstrate map functionality and overloaded methods.
     */
    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();

        // Adding 11 Buildings (Mix of types to meet rubric requirements)
        
        // 1-4: Generic Buildings
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court", 4));
        myMap.addBuilding(new Building("Sabin-Reed Hall", "44 College Lane", 4));
        myMap.addBuilding(new Building("McConnell Hall", "78 Elm Street", 4));

        // 5-6: Libraries
        Library neilson = new Library("Neilson Library", "7 Neilson Drive", 4);
        Library hillyer = new Library("Hillyer Art Library", "20 Elm Street", 2);
        myMap.addBuilding(neilson);
        myMap.addBuilding(hillyer);

        // 7-8: Cafes
        Cafe compass = new Cafe("Compass Cafe", "Neilson Library Ground Floor");
        Cafe ccCafe = new Cafe("Campus Center Cafe", "100 Elm Street");
        myMap.addBuilding(compass);
        myMap.addBuilding(ccCafe);

        // 9-11: Houses
        House king = new House("King House", "180 Elm Street", 3, false);
        House scales = new House("Scales House", "170 Elm Street", 3, true);
        House northrop = new House("Northrop House", "10 Prospect St", 3, false);
        myMap.addBuilding(king);
        myMap.addBuilding(scales);
        myMap.addBuilding(northrop);

        // Display the directory
        System.out.println(myMap);
        System.out.println("\n--- DEMONSTRATING OVERLOADED METHODS ---");

        // House Overload Demo (name vs. name + floor)
        System.out.println("Testing House Overloads:");
        king.moveIn("Miu");
        king.moveIn("Katie", 2);

        // Library Overload Demo (title vs. title + duration)
        System.out.println("\nTesting Library Overloads:");
        neilson.addTitle("The Great Gatsby");
        neilson.checkOut("The Great Gatsby", 21);

        // Cafe Overload Demo (standard vs. customized)
        System.out.println("\nTesting Cafe Overloads:");
        compass.sellCoffee(12); // Standard
        compass.sellCoffee(16, 2, 1); // Large with sugar/cream
    }
}