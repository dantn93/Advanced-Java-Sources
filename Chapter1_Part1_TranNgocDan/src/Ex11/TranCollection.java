
package Ex11;

import java.util.ArrayList;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class TranCollection {

    private ArrayList<GoldTransaction> gTransac;
    private ArrayList<MoneyTransaction> mBTransac;//buying money transaction
    private ArrayList<MoneyTransaction> mSTransac;//selling money transaction

    public TranCollection() {
        this.gTransac = new ArrayList<GoldTransaction>();
        this.mBTransac = new ArrayList<MoneyTransaction>();
        this.mSTransac = new ArrayList<MoneyTransaction>();
    }

    //Add transaction in to list
    public void addGoldTransaction(GoldTransaction src) {
        this.gTransac.add(src);
    }

    //Add transaction in to list  
    public void addBuyTransaction(MoneyTransaction src) {
        this.mBTransac.add(src);
    }

    //Add transaction in to list
    public void addSellTransaction(MoneyTransaction src) {
        this.mSTransac.add(src);
    }

    //Average of gold transaction
    public double avgOfgTransac() {
        double sum = 0;
        for (int i = 0; i < gTransac.size(); i++) {
            sum += gTransac.get(i).getPrice();
        }
        if (gTransac.size() > 0) {
            return sum / gTransac.size();
        } else {
            return 0;
        }
    }

    //Average of money buy transaction
    public double avgOfmBTransac() {
        double sum = 0;
        for (int i = 0; i < mBTransac.size(); i++) {
            sum += mBTransac.get(i).getPrice();
        }
        if (mBTransac.size() > 0) {
            return sum / mBTransac.size();
        } else {
            return 0;
        }
    }

    //Average of money sell transaction
    public double avgOfmSTransac() {
        double sum = 0;
        for (int i = 0; i < mSTransac.size(); i++) {
            sum += mSTransac.get(i).getPrice();
        }
        if (mSTransac.size() > 0) {
            return sum / mSTransac.size();
        } else {
            return 0;
        }
    }

    public void showInfo() {
        System.out.println("\n\n\n== GOLD TRANSACTION == ");
        for (int i = 0; i < gTransac.size(); i++) {
            System.out.println("-- Gold Transaction [" + (i + 1) + "]--");
            gTransac.get(i).showInfo();
        }
        System.out.println("=> Number of Transaction: " + gTransac.size());
        System.out.println("=> Average of Transaction: " + avgOfgTransac());

        System.out.println("\n\n\n== MONEY TRANSACTION == ");
        for (int i = 0; i < mBTransac.size(); i++) {
            System.out.println("-- Buy money transaction[" + (i + 1) + "] --");
            this.mBTransac.get(i).showInfo();
        }
        System.out.println("=> Number of Transaction: " + mBTransac.size());
        System.out.println("=> Average of Transaction: " + avgOfmBTransac());
        System.out.println("\n");
        for (int i = 0; i < mSTransac.size(); i++) {
            System.out.println("-- Sell money transaction[" + (i + 1) + "] --");
            this.mSTransac.get(i).showInfo();
        }
        System.out.println("=> Number of Transaction: " + mSTransac.size());
        System.out.println("=> Average of Transaction: " + avgOfmSTransac());
    }
}
