/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex13;

import java.util.ArrayList;

/**
 * @author Tran Ngoc Dan
 * @Date: 23/08/2016
 * @Version: 1.0
 */
public class Company {

    private ArrayList<Producer> prd;
    private ArrayList<Trader> trd;

    public Company() {
        this.prd = new ArrayList<Producer>();
        this.trd = new ArrayList<Trader>();
    }

    //add 1 producer
    public void addProducer(Producer prd) {
        this.prd.add(prd);
    }

    //add 1 trader
    public void addTrader(Trader trd) {
        this.trd.add(trd);
    }

    //calculate the average trading revenue
    public double avgTradingRevenue() {
        double sum = 0;
        if (trd.size() > 0) {
            for (int i = 0; i < trd.size(); i++) {
                sum += trd.get(i).calRevenue();
            }
            return sum / trd.size();
        } else {
            return 0;
        }
    }
    
    //calculate the average producing revenue
    public double avgProducingRevenue() {
        double sum = 0;
        if (prd.size() > 0) {
            for (int i = 0; i < prd.size(); i++) {
                sum += prd.get(i).calRevenue();
            }
            return sum / prd.size();
        } else {
            return 0;
        }
    }

    public void showInfo() {
        System.out.println("\n\n== SHOW INFORMATION ==");
        System.out.println("-- Producer --");
        for (int i = 0; i < prd.size(); i++) {
            System.out.println("Producer[" + (i + 1) + "]");
            prd.get(i).showInfo();
        }
        if (prd.size() > 0) {
            System.out.println("\nAverage Producing Revenue: " + this.avgProducingRevenue());
        }
        System.out.println("\n-- Trader --");
        for (int i = 0; i < trd.size(); i++) {
            System.out.println("Trader[" + (i + 1) + "]");
            trd.get(i).showInfo();
        }
        if (trd.size() > 0) {
            System.out.println("\nAverage Trading Revenue: " + this.avgTradingRevenue());
        }
    }
}
