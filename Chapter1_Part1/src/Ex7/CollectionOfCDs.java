package Ex7;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 */
public class CollectionOfCDs {

    private ArrayList<CD> collection;

    public CollectionOfCDs() {
        this.collection = new ArrayList<CD>();
    }
    //Add new CD into Collection of CDs
    public void addCD(CD src) {
        this.collection.add(src);
    }

    public void calPriceOfAllCDs() {
        double price = 0;
        for (int i = 0; i < this.collection.size(); i++) {
            System.out.println("[CD No "+i+"]:");
            this.collection.get(i).toString();
            price += this.collection.get(i).getPrice();
        }
        System.out.println("Total Price: "+String.format("%.2f", price));
    }
}
