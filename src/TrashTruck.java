/**
 * Represents a TrashTruck with various attributes and methods to manage its operations.
 * A TrashTruck can pick up trash, compress it, drive, and offload trash.
 * @author Matthew Gerboth
 * @version 1.0
 * 11/17/2025
 */
public class TrashTruck {

    public static void main(String[] args) {
        Driver driver = new Driver("Jalyn Alexander", 35);
        TrashTruck truck = new TrashTruck("Recycling", driver, 50.0, 100.0, "ABC-123");

        truck.pickUpTrash(30);
        truck.compress();
        truck.drive(100);
        truck.offload();
    }

    private String truckType;
    private Driver driver;
    private double gasInTank;
    private double capacity;
    private double currentTrash;
    private int smellFactor;
    private String licensePlate;

    /**
     * Constructs a TrashTruck with specified attributes.
     * @param truckType   The type of the trash truck.
     * @param driver      The driver of the trash truck.
     * @param gasInTank   The amount of gas in the tank.
     * @param capacity    The maximum trash capacity of the truck.
     * @param licensePlate The license plate of the truck.
     */
    public TrashTruck(String truckType, Driver driver, double gasInTank, double capacity, String licensePlate) {
        this.truckType = truckType;
        this.driver = driver;
        this.gasInTank = gasInTank;
        this.capacity = capacity;
        this.currentTrash = 0;
        this.smellFactor = 0;
        this.licensePlate = licensePlate;
    }

    /**
     * Constructs a basic TrashTruck with default values.
     */
    public TrashTruck() {
        this.truckType = "Basic";
        this.driver = new Driver("Default Driver", 30); // Default driver
        this.gasInTank = 50.0;
        this.capacity = 100.0;
        this.currentTrash = 0;
        this.smellFactor = 0;
        this.licensePlate = "DEFAULT-000";
    }

    /**
     * Offloads all the trash from the truck and resets the smell factor.
     */
    public void offload() {
        System.out.println("Offloading trash...");
        currentTrash = 0;
        smellFactor = 0;
    }

    /**
     * Picks up a specified amount of trash, increasing the current trash and smell factor.
     * Ensures the truck does not exceed its capacity.
     * @param amount The amount of trash to pick up.
     */
    public void pickUpTrash(double amount) {
        if (currentTrash + amount > capacity) {
            System.out.println("Cannot pick up trash. Exceeds capacity!");
        } else {
            currentTrash += amount;
            smellFactor += 2;
            System.out.println("Picked up " + amount + " units of trash.");
        }
    }

    /**
     * Compresses the trash in the truck, reducing the current trash by 10 units.
     * If there is less than 10 units of trash, no compression occurs.
     * @return The current amount of trash after compression.
     */
    public double compress() {
        System.out.println("Compressing trash...");
        if (currentTrash > 10) {
            currentTrash -= 10;
        } else {
            System.out.println("Not enough trash to compress.");
        }
        return currentTrash;
    }

    /**
     * Drives the truck a specified distance, reducing the gas in the tank.
     * Ensures there is enough gas to complete the trip.
     * @param distance The distance to drive in miles.
     */
    public void drive(double distance) {
        double gasNeeded = distance * 0.1;
        if (gasInTank >= gasNeeded) {
            gasInTank -= gasNeeded;
            System.out.println("Drove " + distance + " miles. Gas left: " + gasInTank + " gallons");
        } else {
            System.out.println("Not enough gas to drive there.");
        }
    }

    /**
     * Prints the current smell factor of the truck.
     */
    public void sniff() {
        System.out.println("Sniffing the trash... Smell factor is " + smellFactor + ".");
    }

    /**
     * Gets the driver of the truck.
     * @return The driver of the truck.
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * Sets the driver of the truck.
     * @param driver The new driver of the truck.
     */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    /**
     * Gets the amount of gas in the tank.
     * @return The amount of gas in the tank.
     */
    public double getGasInTank() {
        return gasInTank;
    }

    /**
     * Sets the amount of gas in the tank.
     *
     * @param gasInTank The new amount of gas in the tank.
     */
    public void setGasInTank(double gasInTank) {
        this.gasInTank = gasInTank;
    }

    /**
     * Gets the maximum capacity of the truck.
     *
     * @return The maximum capacity of the truck.
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * Sets the maximum capacity of the truck.
     *
     * @param capacity The new maximum capacity of the truck.
     */
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    /**
     * Gets the current amount of trash in the truck.
     *
     * @return The current amount of trash in the truck.
     */
    public double getCurrentTrash() {
        return currentTrash;
    }

    /**
     * Represents the driver of the TrashTruck.
     */
    public static class Driver {
        private String name;
        private int age;

        /**
         * Constructs a Driver with a specified name and age.
         *
         * @param name The name of the driver.
         * @param age  The age of the driver.
         */
        public Driver(String name, int age) {
            this.name = name;
            this.age = age;
        }

        /**
         * Gets the name of the driver.
         *
         * @return The name of the driver.
         */
        public String getName() {
            return name;
        }

        /**
         * Gets the age of the driver.
         *
         * @return The age of the driver.
         */
        public int getAge() {
            return age;
        }
    }
}