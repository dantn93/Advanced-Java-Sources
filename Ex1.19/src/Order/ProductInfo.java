//This is information of one items
package Order;

/**
 * 
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 29/08/2016
 */
public class ProductInfo {

    private String name;
    private double price;

    public ProductInfo(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
    
    public void showInfo(){
        System.out.print("[Name]: "+this.name);
        System.out.print("\n\t[Price]: "+this.price);
    }
}
