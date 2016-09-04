package Ex9;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class Computer {
    protected String ID;
    protected double price;
    protected String manufacturer;
    protected int quantity;

    public Computer() {
        
    }

    public Computer(String ID, double price, String manufacturer, int quantity) {
        this.ID = ID;
        this.price = price;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }

    public double charge() {
        return this.price * this.quantity;
    }
    
    public String showInfo(){
        return "ID: "+this.ID+"\n"+"Price: "+this.price+"\nManufacturer: "
                +this.manufacturer+"\n"+"Quantity: "+this.quantity;
    }
}
