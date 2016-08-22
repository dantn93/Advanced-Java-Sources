/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex12;
/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class ReferenceBook extends Book {

    private double tax;
    private double totalPrice;

    public ReferenceBook(double tax, String ID, String name, String date, double price, int quantity, String publisher) {
        super(ID, name, date, price, quantity, publisher);
        this.tax = tax;
        this.totalPrice = this.quantity * this.price * (1 + tax);
    }

    //get all price
    public double getTotalPrice() {
        return this.totalPrice;
    }

    public void showInfo() {
        System.out.println("ID: " + this.ID);
        System.out.println("Book's name: " + this.name);
        System.out.println("Input Date: " + this.date);
        System.out.println("Price: " + this.price);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("Tax: " + this.tax);
        System.out.println("Total price: " + this.totalPrice);

    }

}
