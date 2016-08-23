/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex16;

import java.util.ArrayList;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class VehicleCollection {

    private ArrayList<Car> carCll;
    private ArrayList<Ship> shipCll;

    public VehicleCollection() {
        this.carCll = new ArrayList<Car>();
        this.shipCll = new ArrayList<Ship>();
    }

    public void addCar(Car car) {
        carCll.add(car);
    }

    public void addShip(Ship ship) {
        shipCll.add(ship);
    }

    public void showInfo() {
        System.out.println("\n\n== SHOW INFORMATION ==");
        if (carCll.size() > 0) {
            for (int i = 0; i < carCll.size(); i++) {
                System.out.println("-- Car["+(i+1)+"] --");
                carCll.get(i).showInfo();
                System.out.println("");
            }
        }
        System.out.println("");
        if (shipCll.size() > 0) {
            for (int i = 0; i < shipCll.size(); i++) {
                System.out.println("-- Ship["+(i+1)+"] --");
                shipCll.get(i).showInfo();
                System.out.println("");
            }
        }
    }
}
