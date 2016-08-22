/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex13;

import Ex6.TaxInfo;

/**
 * @author Tran Ngoc Dan
 * @Date: 23/08/2016
 * @Version: 1.0
 */
public class Producer extends Employee {

    private final static int normsQuantity = 1000;
    private final static double bonusRate = 0.05;
    private int quantity;

    public Producer(int quantity, String name, double coefficient, int subPeople, double bonus) {
        super(name, coefficient, subPeople, bonus);
        this.quantity = quantity;
    }

    //calculate Poundage for Producer
    @Override
    public double calPoundage() {
        return (this.quantity - Producer.normsQuantity) * Producer.bonusRate;
    }
    
    public void showInfo(){
        System.out.println("\tName: "+this.name);
        System.out.println("\tCoefficient of Salary: "+this.coefficient);
        System.out.println("\tNumber of people who are subtracted: "+this.subPeople);
        System.out.println("\tBonus: "+this.bonus);
        System.out.println("\tNumber of Products: "+this.quantity);
        System.out.println("\tRevenue: "+this.calRevenue());
        System.out.println("\tTax Revenue: "+this.calTaxRevenue());
        System.out.println("\tPersonal Tax: "+this.calPersonalRevenueTax());
        System.out.println("\tReal Revene: "+this.calrealRevenue());
        
    }
}
