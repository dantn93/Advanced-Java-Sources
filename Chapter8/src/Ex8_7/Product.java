/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex8_7;

import java.sql.Date;

/**
 * @author Tran Ngoc Dan
 * @since 19/09/2016
 * @version 1.0
 */
public class Product {

    private int id;
    private String name;
    private double price;
    private int amount;
    private String image;
    private int category;
    private String createDate;
    private int display;

    public Product() {
    }

    public Product(int id, String name, double price, int amount, String image, int category, String createDate, int display) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.image = image;
        this.category = category;
        this.createDate = createDate;
        this.display = display;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCategory(int category) {
        this.category = category;
    }


    public void setDisplay(int display) {
        this.display = display;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public String getImage() {
        return image;
    }

    public int getCategory() {
        return category;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public int getDisplay() {
        return display;
    }

    public void showInfo() {
        System.out.println("\t[id] " + this.id);
        System.out.println("\t[name] " + this.name);
        System.out.println("\t[price] " + this.price);
        System.out.println("\t[amount] " + this.amount);
        System.out.println("\t[image] " + this.image);
        System.out.println("\t[category] " + this.category);
        System.out.println("\t[createDate] " + this.createDate);
        System.out.println("\t[display] " + this.display);
        System.out.println("");
    }

}
