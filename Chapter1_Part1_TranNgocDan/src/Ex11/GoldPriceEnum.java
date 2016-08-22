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
public enum GoldPriceEnum {
    SJC9999(3500000),
    GOLD24K(3514100);
    private double goldPrice;
    private GoldPriceEnum(double goldPrice){
        this.goldPrice = goldPrice;
    }
    
    public double getPrice(){
        return this.goldPrice;
    }
}
