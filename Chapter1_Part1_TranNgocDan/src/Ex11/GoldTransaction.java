/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex11;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class GoldTransaction extends Transaction {

    private double price;
    private String goldType;
    private GoldPriceEnum priceMenu;

    public GoldTransaction(String ID, String date, int number) {
        super(ID, date, number);
        this.price = 0;
    }

    public double getPrice() {
        return this.price;
    }

    //Calculate all gold price
    public void calPrice(String goldCode) {
        if (goldCode.equalsIgnoreCase("SJC9999")) {
            this.price = this.number * priceMenu.SJC9999.getPrice();
            this.goldType = "SJC9999";
        }
        if (goldCode.equalsIgnoreCase("GOLD24K")) {
            this.price = this.number * priceMenu.GOLD24K.getPrice();
            this.goldType = "GOLD24K";
        }
    }
    
    public void showInfo(){
        System.out.println("Transaction Code: "+this.ID);
        System.out.println("Date: "+this.date);
        System.out.println("GoldType: "+this.goldType);
        System.out.println("Quantity: "+this.number);
        System.out.println("Price: "+this.price);
    }

}
