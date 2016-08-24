/**
 * This code manages vehicle
 */
package Ex16;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class VehicleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        VehicleCollection obj = new VehicleCollection();
        try {
            System.out.println("== VEHICLE ==");
            while (true) {
                while (true) {
                    System.out.println("Fill out information");
                    System.out.print("Distance: ");
                    double distance = Double.parseDouble(input.readLine());
                    System.out.print("Time: ");
                    double time = Double.parseDouble(input.readLine());
                    System.out.print("Fuel capacity: ");
                    double fuelCapacity = Double.parseDouble(input.readLine());
                    System.out.print("Vehicle registration plates: ");
                    String regisPlace = input.readLine();
                    System.out.print("Owner: ");
                    String owner = input.readLine();
                    System.out.print("Color: ");
                    String color = input.readLine();
                    System.out.print("Manufacturer: ");
                    String manuf = input.readLine();

                    int ans = 0;
                    while (true) {
                        System.out.print("It is a Car (1) or Ship(2): ");
                        ans = Integer.parseInt(input.readLine());
                        if (ans == 1 || ans == 2) {
                            break;
                        }
                    }
                    if (ans == 1) {//1. car
                        int ans1 = 0;
                        String gear = "";
                        while (true) {
                            System.out.print("It has a gear: taper sleeve(1), no taper sleeve(2): ");
                            ans1 = Integer.parseInt(input.readLine());
                            if (ans1 == 1) {
                                gear = "Taper sleeve";
                                break;
                            }
                            if (ans1 == 2) {
                                gear = "No taper sleeve";
                                break;
                            }
                        }
                        System.out.print("Car type: ");
                        String carType = input.readLine();
                        Car car = new Car(gear, carType, regisPlace, owner, color, manuf);
                        car.calSpeed(distance, time);
                        car.calFuelConsumption(distance, fuelCapacity, 0);
                        obj.addCar(car);
                        break;
                    }
                    if (ans == 2) {//2. Ship
                        double weight = 0;
                        double capacity = 0;
                        double vWater = 0;
                        double wasteOfFuel = 0;
                        String trend = "";
                        String fuelType = "";
                        while (true) {
                            System.out.print("Weight: ");
                            weight = Double.parseDouble(input.readLine());
                            if (weight > 0) {
                                break;
                            }
                        }
                        while (true) {
                            System.out.print("Speed of water: ");
                            vWater = Double.parseDouble(input.readLine());
                            if (vWater > 0) {
                                break;
                            }
                        }
                        while (true) {
                            System.out.print("Waste of fuel: ");
                            wasteOfFuel = Double.parseDouble(input.readLine());
                            if (wasteOfFuel > 0) {
                                break;
                            }
                        }
                        while (true) {
                            System.out.print("Trend of ship: follow trend of water (1)\n or DON'T follow trend of water(2): ");
                            int ans1 = Integer.parseInt(input.readLine());
                            if (ans1 == 1) {
                                trend = "down";
                                break;
                            }
                            if (ans1 == 2) {
                                trend = "reverse";
                                break;
                            }
                        }
                        System.out.print("Fuel type: ");
                        fuelType = input.readLine();
                        Ship ship = new Ship(weight, capacity, trend, fuelType, regisPlace, owner, color, manuf);
                        ship.calSpeed(distance, time, vWater);
                        ship.calFuelConsumption(distance, fuelCapacity, wasteOfFuel);
                        obj.addShip(ship);
                        break;
                    }
                }

                //Ask continue
                boolean flag = false;
                while (true) {
                    System.out.print("\n\nDo you want another operation (y/n): ");
                    String agr = input.readLine();
                    if (agr.equalsIgnoreCase("y")) {
                        break;
                    } else if (agr.equalsIgnoreCase("n")) {
                        flag = true;
                        break;
                    }
                }
                if (flag == true) {
                    break;
                }

            }
            //Show information
            obj.showInfo();

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
