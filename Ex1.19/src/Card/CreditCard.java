/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

/**
 * 
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 29/08/2016
 */
public class CreditCard extends Card {

    final double maxDebt = 50000000;
    private String expirationDate;
    private double debt;
    private String type;

    public CreditCard(String expirationDate, String type, String cardID, String confirmationMethod) {
        super(cardID, confirmationMethod);
        this.expirationDate = expirationDate;
        this.debt = 0;
        this.type = type;
    }

    //the expiration date is the day which limit the valid day
    public String getExpirationDate() {
        return expirationDate;
    }

    //maximum debt in Credit card
    public double getMaxDebt() {
        return maxDebt;
    }

    public String getType() {
        return type;
    }

    //If you buy something, the credit card will record a debt
    public int debit(double sub) {
        if ((this.debt + sub) <= maxDebt) {
            this.debt += sub;
            System.out.println("Pay successfully");
            return 1;
        } else {
            System.out.println("Can't pay");
            return 0;
        }
    }

    //Show debt
    public void showInfo() {
        System.out.println("Debt: " + String.format("%.2f", this.debt));
    }
}
