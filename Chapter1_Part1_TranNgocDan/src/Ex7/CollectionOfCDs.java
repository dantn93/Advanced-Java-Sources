/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex7;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author snow
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
