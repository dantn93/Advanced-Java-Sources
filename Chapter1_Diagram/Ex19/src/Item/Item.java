//This is collection of items in supermarket
package Item;

/**
 * 
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 29/08/2016
 */
public enum Item {
    MILK(4000), BREAD(2000), NOODLE(6000), VEGATABLE(1000), RICE(12000);
    private double price;

    private Item(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
}
