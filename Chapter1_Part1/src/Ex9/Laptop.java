package Ex9;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class Laptop extends Computer {

    private double weight;
    private double batteryLife;
    private String monitorSize;

    public Laptop(double weight, double batteryLife, String monitorSize, String ID, double price, String manufacturer, int quantity) {

        this.ID = ID;
        this.price = price;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.weight = weight;
        this.batteryLife = batteryLife;
        this.monitorSize = monitorSize;
    }

    public void showLapInfo() {
        System.out.println(super.showInfo());
        System.out.println("Weight: " + this.weight);
        System.out.println("Battery Life: " + this.batteryLife);
        System.out.println("Monitor: " + this.monitorSize);
    }
}
