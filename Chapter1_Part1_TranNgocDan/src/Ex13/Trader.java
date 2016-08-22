/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex13;

/**
 * @author Tran Ngoc Dan
 * @Date: 23/08/2016
 * @Version: 1.0
 */
public class Trader extends Employee {

    private double businessWage; //mothly business wage
    private double businessWageRate;

    public Trader(double businessWage, double businessWageRate, String name, double coefficient, int subPeople, double bonus) {
        super(name, coefficient, subPeople, bonus);
        this.businessWage = businessWage;
        this.businessWageRate = businessWageRate;
    }

    @Override
    public double calPoundage() {
        return this.businessWage * this.businessWageRate;
    }
    
    public void showInfo(){
        System.out.println("\tName: "+this.name);
        System.out.println("\tCoefficient of Salary: "+this.coefficient);
        System.out.println("\tNumber of people who are subtracted: "+this.subPeople);
        System.out.println("\tBonus: "+this.bonus);
        System.out.println("\tBusiness Wage: "+this.businessWage);
        System.out.println("\tBusiness Wage Rate: "+this.businessWageRate);
        System.out.println("\tRevenue: "+this.calRevenue());
        System.out.println("\tTax Revenue: "+this.calTaxRevenue());
        System.out.println("\tPersonal Tax: "+this.calPersonalRevenueTax());
        System.out.println("\tReal Revene: "+this.calrealRevenue());
    }
}