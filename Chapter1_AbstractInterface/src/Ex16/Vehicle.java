package Ex16;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public abstract class Vehicle {

    protected String ID;
    protected String owner;
    protected String color;
    protected String publisher;
    protected double vVehicle;
    protected double fuelConsumptionRate;

    public Vehicle(String ID, String owner, String color, String publisher) {
        this.ID = ID;
        this.owner = owner;
        this.color = color;
        this.publisher = publisher;
        this.vVehicle = 0;
        this.fuelConsumptionRate = 0;
    }

    public void showInfo() {
    }
}
