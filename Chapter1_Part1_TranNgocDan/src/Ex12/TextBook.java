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
public class TextBook extends Book {

    private String state;
    private double totalprice;

    public TextBook(String state, String ID, String name, String date, double price, int quantity, String publisher) {
        super(ID, name, date, price, quantity, publisher);
        this.state = state;
        this.totalprice = 0;
        if (state.equalsIgnoreCase("new")) {
            this.totalprice = this.price * this.quantity;
        }
        if (state.equalsIgnoreCase("old")) {
            this.totalprice = this.price * this.quantity * 0.5;
        }
    }


    //get all price
    public double getTotalPrice() {
        return this.totalprice;
    }

    public void showInfo() {
        System.out.println("ID: " + this.ID);
        System.out.println("Book's name: " + this.name);
        System.out.println("Input Date: " + this.date);
        System.out.println("Price: " + this.price);
        System.out.println("Quantity: " + this.quantity);
        System.out.println("State: " + this.state);
        System.out.println("Total price: " + this.totalprice);

    }
}
