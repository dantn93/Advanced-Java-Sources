package Ex16;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class Car extends Vehicle implements IFuelConsumption, ISpeedUpperWater {

    private String gear;
    private String carType;

    public Car(String gear, String carType, String ID, String owner, String color, String publisher) {
        super(ID, owner, color, publisher);
        this.gear = gear;
        this.carType = carType;
    }
    
    //Calculate speed of car
    public void calSpeed(double distance, double time) {
        if (time > 0) {
            this.vVehicle = distance / time;
        } else {
            this.vVehicle = 0;
        }
    }

    //fuel consumption for total time
    @Override
    public void calFuelConsumption(double distance, double spendingFuel, double wasteOfFuel) {
        if (spendingFuel > 0) {
            this.fuelConsumptionRate = distance / spendingFuel;
        } else {
            this.fuelConsumptionRate = 0;
        }
    }
    
    @Override
    public void showInfo(){
        System.out.println("Vehicle registration plates: "+this.ID);
        System.out.println("Owner: "+this.owner);
        System.out.println("Color: "+this.color);
        System.out.println("Publisher: "+this.publisher);
        System.out.println("Type of Car: "+this.carType);
        System.out.println("Speed: "+this.vVehicle+" km/h");
        System.out.println("Fuel consumption for total time: "+this.fuelConsumptionRate+" km/lit");
    }
}
