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
public enum MoneyPriceEnum {
    USD(22000),
    EUR(25000),
    AUD(17000);

    private double moneyPrice;

    private MoneyPriceEnum(double moneyPrice) {
        this.moneyPrice = moneyPrice;
    }

    public double getMoneyPrice() {
        return this.moneyPrice;
    }
}
