/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex8_1_6;

/**
 * @author Tran Ngoc Dan
 * @since 17/09/2016
 * @version 1.0
 */
public class Product {

    private int id;
    private String name;
    private double price;
    private int amount;
    private int categoryid;

    public Product() {
    }

    public Product(int id, String name, double price, int amount, int categoryid) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.categoryid = categoryid;
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

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
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

    public int getCategoryid() {
        return categoryid;
    }

    //show all of information
    public void showInfo() {
        System.out.println("[id] " + this.id);
        System.out.println("[name] " + this.name);
        System.out.println("[price] " + this.price);
        System.out.println("[amount] " + this.amount);
        System.out.println("[category id] " + this.categoryid);
        System.out.println("");
    }

}
