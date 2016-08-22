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
public class Book {
    protected String ID;
    protected String name;
    protected String date;
    protected double price;
    protected int quantity;
    protected String publisher;

    public Book(String ID, String name, String date, double price, int quantity, String publisher) {
        this.ID = ID;
        this.name = name;
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.publisher = publisher;
    }
    
}
