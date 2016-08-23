/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex16;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class Ship extends Vehicle implements ISpeedUnderWater, IFuelConsumption {

    private double weight;
    private double capacity;// 
    private String trend;   //down - revert
    private String fuelType;

    public Ship(double weight, double capacity, String trend, String fuelType, String ID, String owner, String color, String publisher) {
        super(ID, owner, color, publisher);
        this.weight = weight;
        this.capacity = capacity;
        this.trend = trend;
        this.fuelType = fuelType;
    }

    @Override
    public void calSpeed(double distance, double time, double vWater) {
        if (trend.equalsIgnoreCase("down")) {
            this.vVehicle = distance / time + vWater;
        }
        if (trend.equalsIgnoreCase("reverse")) {
            this.vVehicle = distance / time - vWater;
        }
    }
    
    @Override
    public void calFuelConsumption(double distance, double spendingFuel, double wasteOfFuel) {
        if (spendingFuel - wasteOfFuel > 0) {
            this.fuelConsumptionRate = distance / (spendingFuel - wasteOfFuel);
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
        System.out.println("Weight: "+this.weight);
        System.out.println("Capacity: "+this.capacity);
        System.out.println("Trend: "+this.trend);
        System.out.println("Fuel type: "+this.fuelType);
        System.out.println("Speed: "+this.vVehicle+" km/h");
        System.out.println("Fuel consumption for total time: "+this.fuelConsumptionRate+" km/lit");
    }
}
