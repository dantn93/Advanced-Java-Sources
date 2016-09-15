package Ex6_4;

import java.io.Serializable;
import java.text.DecimalFormat;

/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 15/09/2016
 */
public class Employee implements Serializable {

    private String name;
    private double coefSalary;//coefficient
    private int sub_num;//number of people which subtracted depend on circumstances
    private double bonus;//weekly bonus
    private double baseSalary;
    final double DEFAULT_SALARY_1 = 9000000;
    final double DEFAULT_SALARY_2 = 3600000;

    public Employee(String name, double coefSalary, int sub_num, double bonus) {
        this.name = name;
        this.coefSalary = coefSalary;
        this.sub_num = sub_num;
        this.bonus = bonus;
        this.baseSalary = 1260000;
    }

    public String getName() {
        return name;
    }

    public double getCoefSalary() {
        return coefSalary;
    }

    public int getSub_num() {
        return sub_num;
    }

    public double getBonus() {
        return bonus;
    }

    //Calculate full revenue
    public double calRevenue() {

        double salary = this.coefSalary * baseSalary + this.bonus;
        if (salary > 0) {
            return salary;
        } else {
            return 0;
        }
    }

    //Calculate personal tax revenue
    public double calTaxRevenue() {
        double salaryTax = this.calRevenue() - DEFAULT_SALARY_1 - this.getSub_num() * DEFAULT_SALARY_2;
        if (salaryTax > 0) {
            return salaryTax;
        } else {
            return 0;
        }
    }

    //Calculate personal revenue tax
    public double calPersonalRevenueTax() {
        double result = 0;
        double taxRevenue = this.calTaxRevenue();
        if (taxRevenue < TaxInfo.LEVEL1.getMaxRevenue()) {
            result = TaxInfo.LEVEL1.calPersonalRevenueTax(taxRevenue);
        } else if (taxRevenue < TaxInfo.LEVEL2.getMaxRevenue()) {
            result = TaxInfo.LEVEL2.calPersonalRevenueTax(taxRevenue);
        } else if (taxRevenue < TaxInfo.LEVEL3.getMaxRevenue()) {
            result = TaxInfo.LEVEL3.calPersonalRevenueTax(taxRevenue);
        } else if (taxRevenue < TaxInfo.LEVEL4.getMaxRevenue()) {
            result = TaxInfo.LEVEL4.calPersonalRevenueTax(taxRevenue);
        } else if (taxRevenue < TaxInfo.LEVEL5.getMaxRevenue()) {
            result = TaxInfo.LEVEL5.calPersonalRevenueTax(taxRevenue);
        } else if (taxRevenue < TaxInfo.LEVEL6.getMaxRevenue()) {
            result = TaxInfo.LEVEL6.calPersonalRevenueTax(taxRevenue);
        } else {
            result = TaxInfo.LEVEL7.calPersonalRevenueTax(taxRevenue);
        }
        return result;
    }

    //real revenue
    public double calrealRevenue() {
        double result = this.calRevenue() - this.calPersonalRevenueTax();
        if (result > 0) {
            return result;
        } else {
            return 0;
        }
    }

    //show employee's information
    public void showInfo() {
        System.out.println("[Name]: " + this.name);
        System.out.println("[Coeficient Salary]: " + this.coefSalary);
        System.out.println("[Number of people which subtracted]: " + this.sub_num);
        System.out.println("[Bonus]: " + this.bonus);
        System.out.println("[BaseSalary]: " + this.baseSalary);
        System.out.println("[Full revenue]: " + this.calRevenue());
        System.out.println("[Tax revenue]: " + this.calTaxRevenue());
        System.out.println("[Personal Revenue Tax]: " + this.calPersonalRevenueTax());
        System.out.println("[Real Revenue]: " + this.calrealRevenue());
        System.out.println("");

    }
}
