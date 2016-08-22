/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex9;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class Desktop extends Computer {

    private String CPU;
    private String RAM;

    public Desktop(String CPU, String RAM, String ID, double price, String manufacturer, int quantity) {
        this.ID = ID;
        this.price = price;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.CPU = CPU;
        this.RAM = RAM;
    }

    public void showDeskInfo() {
        System.out.println(super.showInfo());
        System.out.println("RAM: " + this.RAM);
        System.out.println("CPU: " + this.CPU);
    }
}
