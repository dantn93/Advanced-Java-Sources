
package Ex6;
/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 */
public class Employee {

    private String name;
    private double coefSalary;//coefficient
    private int sub_num;//number of people which subtracted depend on circumstances
    private double bonus;//weekly bonus
    private double baseSalary;

    public Employee(String name, double coefSalary, int sub_num, double bonus) {
        this.name = name;
        this.coefSalary = coefSalary;
        this.sub_num = sub_num;
        this.bonus = bonus;
        this.baseSalary = 1260000;
    }
    
    //Calculate full revenue
    public double calRevenue() {
        return this.coefSalary * baseSalary + bonus;
    }
    
    //Calculate revenue which has tax
    public double calTaxRevenue() {
        double taxRevenue = calRevenue() - 9000000 - this.sub_num * 3600000;
        if (taxRevenue > 0) {
            return taxRevenue;
        } else {
            return 0;
        }
    }

    public int getSub_num() {
        return sub_num;
    }

    
    //Calculate personal tax revenue
    public double calPersonalRevenueTax() {
        double taxRevenue = calTaxRevenue();
        //LEVEL1
        if (taxRevenue >= TaxInfo.LEVEL1.getMinRevenue() && taxRevenue < TaxInfo.LEVEL1.getMaxRevenue()) {
            return taxRevenue * TaxInfo.LEVEL1.getTax();
        }
        //LEVEL2
        if (taxRevenue >= TaxInfo.LEVEL2.getMinRevenue() && taxRevenue < TaxInfo.LEVEL2.getMaxRevenue()) {
            return (taxRevenue - TaxInfo.LEVEL1.getMaxRevenue()) * TaxInfo.LEVEL2.getTax() + TaxInfo.LEVEL1.getMaxTaxMoney();
        }

        //LEVEL3
        if (taxRevenue >= TaxInfo.LEVEL3.getMinRevenue() && taxRevenue < TaxInfo.LEVEL3.getMaxRevenue()) {
            return (taxRevenue - TaxInfo.LEVEL2.getMaxRevenue()) * TaxInfo.LEVEL3.getTax()
                    + TaxInfo.LEVEL2.getMaxTaxMoney() + TaxInfo.LEVEL1.getMaxTaxMoney();
        }

        //LEVEL4
        if (taxRevenue >= TaxInfo.LEVEL4.getMinRevenue() && taxRevenue < TaxInfo.LEVEL4.getMaxRevenue()) {
            return (taxRevenue - TaxInfo.LEVEL3.getMaxRevenue()) * TaxInfo.LEVEL4.getTax()
                    + TaxInfo.LEVEL3.getMaxTaxMoney() + TaxInfo.LEVEL2.getMaxTaxMoney() + TaxInfo.LEVEL1.getMaxTaxMoney();
        }

        //LEVEL5
        if (taxRevenue >= TaxInfo.LEVEL5.getMinRevenue() && taxRevenue < TaxInfo.LEVEL5.getMaxRevenue()) {
            return (taxRevenue - TaxInfo.LEVEL4.getMaxRevenue()) * TaxInfo.LEVEL5.getTax()
                    + TaxInfo.LEVEL4.getMaxTaxMoney() + TaxInfo.LEVEL3.getMaxTaxMoney()
                    + TaxInfo.LEVEL2.getMaxTaxMoney() + TaxInfo.LEVEL1.getMaxTaxMoney();
        }

        //LEVEL6
        if (taxRevenue >= TaxInfo.LEVEL6.getMinRevenue() && taxRevenue < TaxInfo.LEVEL6.getMaxRevenue()) {
            return (taxRevenue - TaxInfo.LEVEL5.getMaxRevenue()) * TaxInfo.LEVEL6.getTax()
                    + TaxInfo.LEVEL5.getMaxTaxMoney()
                    + TaxInfo.LEVEL4.getMaxTaxMoney() + TaxInfo.LEVEL3.getMaxTaxMoney()
                    + TaxInfo.LEVEL2.getMaxTaxMoney() + TaxInfo.LEVEL1.getMaxTaxMoney();
        }

        //LEVEL7
        if (taxRevenue >= TaxInfo.LEVEL7.getMinRevenue() && taxRevenue < TaxInfo.LEVEL7.getMaxRevenue()) {
            return (taxRevenue - TaxInfo.LEVEL6.getMaxRevenue()) * TaxInfo.LEVEL7.getTax()
                    + TaxInfo.LEVEL6.getMaxTaxMoney() + TaxInfo.LEVEL5.getMaxTaxMoney()
                    + TaxInfo.LEVEL4.getMaxTaxMoney() + TaxInfo.LEVEL3.getMaxTaxMoney()
                    + TaxInfo.LEVEL2.getMaxTaxMoney() + TaxInfo.LEVEL1.getMaxTaxMoney();
        }
        return 0;
    }
    
    
    public double calrealRevenue(){
        return calRevenue() - calPersonalRevenueTax();
    }
    
}
