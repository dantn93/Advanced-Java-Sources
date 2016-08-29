
package Card;

/**
 * 
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 29/08/2016
 */
public class ATM extends Card {

    private double balances;

    public ATM(double balances, String cardID, String confirmationMethod) {
        super(cardID, confirmationMethod);
        this.balances = balances;
    }

    public double getBalances() {
        return balances;
    }

    //If you buy something, you will pay then the balance is decreased
    public int subBalances(double sub) {
        if (sub <= this.balances) {
            this.balances -= sub;
            System.out.println("Pay successfully");
            return 1;
        } else {
            System.out.println("Can't pay");
            return 0;
        }
    }

    //Show the balance of ATM card
    public void showInfo() {
        System.out.println("Balances: " + String.format("%.2f", this.balances));
    }
}
