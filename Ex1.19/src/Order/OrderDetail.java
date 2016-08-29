//One product category, you can buy one, two, three...or many items.
package Order;

/**
 *
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 29/08/2016
 */
public class OrderDetail {

    private int quantity;
    private ProductInfo detail;

    public OrderDetail(int quantity, String name, double price) {
        this.quantity = quantity;
        this.detail = new ProductInfo(name, price);
    }

    public int getQuantity() {
        return quantity;
    }

    //calculate total amount in a product category
    public double getTotalAmount() {
        return this.quantity * this.detail.getPrice();
    }

    public void showInfo() {
        this.detail.showInfo();
        System.out.println("\n\t[Quantity]: " + this.quantity);
    }

}
