package Ex13;

/**
 * @author Tran Ngoc Dan
 * @Date: 23/08/2016
 * @Version: 1.0
 */
public class Employee {
    protected String name;
    protected double coefficient;
    protected int subPeople; //number of people who are subtracted based on circumstance
    protected double bonus; //mothly bonus
    protected final static double baseSalary = 1260000;

    public Employee(String name, double coefficient, int subPeople, double bonus) {
        this.name = name;
        this.coefficient = coefficient;
        this.subPeople = subPeople;
        this.bonus = bonus;
    }
    
    
    //Calculate Poundate (It can be overrided in Producer & Trader class)
    public double calPoundage() {
        return 0;
    }

    //Calculate full revenue
    public double calRevenue() {
        return this.coefficient * baseSalary + this.bonus + this.calPoundage();
    }
    
    //Calculate revenue which has tax
    public double calTaxRevenue() {
        double taxRevenue = calRevenue() - 9000000 - this.subPeople * 3600000;
        if (taxRevenue > 0) {
            return taxRevenue;
        } else {
            return 0;
        }
    }

    //Calculate personal tax revenue
    public double calPersonalRevenueTax() {
        double taxRevenue = calTaxRevenue();
        //LEVEL1
        if (taxRevenue >= Ex6.TaxInfo.LEVEL1.getMinRevenue() && taxRevenue < Ex6.TaxInfo.LEVEL1.getMaxRevenue()) {
            return taxRevenue * Ex6.TaxInfo.LEVEL1.getTax();
        }
        //LEVEL2
        if (taxRevenue >= Ex6.TaxInfo.LEVEL2.getMinRevenue() && taxRevenue < Ex6.TaxInfo.LEVEL2.getMaxRevenue()) {
            return (taxRevenue - Ex6.TaxInfo.LEVEL1.getMaxRevenue()) * Ex6.TaxInfo.LEVEL2.getTax() + Ex6.TaxInfo.LEVEL1.getMaxTaxMoney();
        }

        //LEVEL3
        if (taxRevenue >= Ex6.TaxInfo.LEVEL3.getMinRevenue() && taxRevenue < Ex6.TaxInfo.LEVEL3.getMaxRevenue()) {
            return (taxRevenue - Ex6.TaxInfo.LEVEL2.getMaxRevenue()) * Ex6.TaxInfo.LEVEL3.getTax()
                    + Ex6.TaxInfo.LEVEL2.getMaxTaxMoney() + Ex6.TaxInfo.LEVEL1.getMaxTaxMoney();
        }

        //LEVEL4
        if (taxRevenue >= Ex6.TaxInfo.LEVEL4.getMinRevenue() && taxRevenue < Ex6.TaxInfo.LEVEL4.getMaxRevenue()) {
            return (taxRevenue - Ex6.TaxInfo.LEVEL3.getMaxRevenue()) * Ex6.TaxInfo.LEVEL4.getTax()
                    + Ex6.TaxInfo.LEVEL3.getMaxTaxMoney() + Ex6.TaxInfo.LEVEL2.getMaxTaxMoney() + Ex6.TaxInfo.LEVEL1.getMaxTaxMoney();
        }

        //LEVEL5
        if (taxRevenue >= Ex6.TaxInfo.LEVEL5.getMinRevenue() && taxRevenue < Ex6.TaxInfo.LEVEL5.getMaxRevenue()) {
            return (taxRevenue - Ex6.TaxInfo.LEVEL4.getMaxRevenue()) * Ex6.TaxInfo.LEVEL5.getTax()
                    + Ex6.TaxInfo.LEVEL4.getMaxTaxMoney() + Ex6.TaxInfo.LEVEL3.getMaxTaxMoney()
                    + Ex6.TaxInfo.LEVEL2.getMaxTaxMoney() + Ex6.TaxInfo.LEVEL1.getMaxTaxMoney();
        }

        //LEVEL6
        if (taxRevenue >= Ex6.TaxInfo.LEVEL6.getMinRevenue() && taxRevenue < Ex6.TaxInfo.LEVEL6.getMaxRevenue()) {
            return (taxRevenue - Ex6.TaxInfo.LEVEL5.getMaxRevenue()) * Ex6.TaxInfo.LEVEL6.getTax()
                    + Ex6.TaxInfo.LEVEL5.getMaxTaxMoney()
                    + Ex6.TaxInfo.LEVEL4.getMaxTaxMoney() + Ex6.TaxInfo.LEVEL3.getMaxTaxMoney()
                    + Ex6.TaxInfo.LEVEL2.getMaxTaxMoney() + Ex6.TaxInfo.LEVEL1.getMaxTaxMoney();
        }

        //LEVEL7
        if (taxRevenue >= Ex6.TaxInfo.LEVEL7.getMinRevenue() && taxRevenue < Ex6.TaxInfo.LEVEL7.getMaxRevenue()) {
            return (taxRevenue - Ex6.TaxInfo.LEVEL6.getMaxRevenue()) * Ex6.TaxInfo.LEVEL7.getTax()
                    + Ex6.TaxInfo.LEVEL6.getMaxTaxMoney() + Ex6.TaxInfo.LEVEL5.getMaxTaxMoney()
                    + Ex6.TaxInfo.LEVEL4.getMaxTaxMoney() + Ex6.TaxInfo.LEVEL3.getMaxTaxMoney()
                    + Ex6.TaxInfo.LEVEL2.getMaxTaxMoney() + Ex6.TaxInfo.LEVEL1.getMaxTaxMoney();
        }
        return 0;
    }
    
    //Calculate real revenue
    public double calrealRevenue(){
        return calRevenue() - calPersonalRevenueTax();
    }
}
