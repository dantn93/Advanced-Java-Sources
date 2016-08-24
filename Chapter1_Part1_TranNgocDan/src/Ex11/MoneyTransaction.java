
package Ex11;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class MoneyTransaction extends Transaction {

    private double price;
    private String moneyType;
    private MoneyPriceEnum exchangeRate;

    public MoneyTransaction() {

    }

    public MoneyTransaction(String ID, String date, int number) {
        super(ID, date, number);
        this.price = 0;
        this.moneyType ="";
    }

    //Calculate price of purchase
    public void calBuyPrice(String moneyCode) {
        if (moneyCode.equalsIgnoreCase("USD")) {
            this.price = this.number * exchangeRate.USD.getMoneyPrice();
            this.moneyType = "USD";
        }

        if (moneyCode.equalsIgnoreCase("EUR")) {
            this.price = this.number * exchangeRate.EUR.getMoneyPrice();
            this.moneyType = "EUR";
        }

        if (moneyCode.equalsIgnoreCase("AUD")) {
            this.price = this.number * exchangeRate.AUD.getMoneyPrice();
            this.moneyType = "AUD";
        }
    }

    //Calculate price of selling
    public void calSellPrice(String moneyCode) {
        if (moneyCode.equalsIgnoreCase("USD")) {
            this.price = (this.number * exchangeRate.USD.getMoneyPrice()) * 1.001;
            this.moneyType = "USD";
        }

        if (moneyCode.equalsIgnoreCase("EUR")) {
            this.price = (this.number * exchangeRate.EUR.getMoneyPrice()) * 1.001;
            this.moneyType = "EUR";
        }

        if (moneyCode.equalsIgnoreCase("AUD")) {
            this.price = (this.number * exchangeRate.AUD.getMoneyPrice()) * 1.001;
            this.moneyType = "AUD";
        }
    }

    public void showInfo() {
        System.out.println("Transaction Code: " + this.ID);
        System.out.println("Date: " + this.date);
        System.out.println("MoneyType: " + this.moneyType);
        System.out.println("Quantity: " + this.number);
        System.out.println("Price: " + this.price);
    }

    //Get total price in this transaction
    public double getPrice() {
        return this.price;
    }

}
