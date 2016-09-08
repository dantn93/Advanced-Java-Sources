package Card;

import Customer.Information;

/**
 * 
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 29/08/2016
 */
public class Card {

    protected String cardID;
    protected String confirmationMethod;

    public Card(String cardID, String confirmationMethod) {
        this.cardID = cardID;
        this.confirmationMethod = confirmationMethod;
    }

    public String getCardID() {
        return cardID;
    }

    public String getConfirmationMethod() {
        return confirmationMethod;
    }
}
