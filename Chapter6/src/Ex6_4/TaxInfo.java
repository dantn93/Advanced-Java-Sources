package Ex6_4;

/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 15/09/2016
 */
public enum TaxInfo {

    LEVEL1(5, 0.05, 250000), LEVEL2(10, 0.1, 500000), LEVEL3(18, 0.15, 1200000),
    LEVEL4(32, 0.2, 2800000), LEVEL5(52, 0.25, 5000000), LEVEL6(80, 0.3, 8400000),
    LEVEL7(0, 0.35, 0);
    
    private double maxRevenue;
    private double tax;
    private double maxTaxMoney;

    private TaxInfo(double maxRevenue, double tax, double maxTaxMoney) {
        double UNIT = 1000000;
        this.maxRevenue = maxRevenue * UNIT;
        this.tax = tax;
        this.maxTaxMoney = maxTaxMoney;
    }

    public double getMaxRevenue() {
        return maxRevenue;
    }
    
    
    
    //get revenueTax
    public double calPersonalRevenueTax(double revenueTax) {
        double result = 0;
        switch (this) {
            case LEVEL1:
                result = revenueTax * LEVEL1.tax;
                break;
            case LEVEL2:
                result = (revenueTax - LEVEL1.maxRevenue) * LEVEL2.tax
                        + LEVEL1.maxTaxMoney;
                break;
            case LEVEL3:
                result = (revenueTax - LEVEL2.maxRevenue) * LEVEL3.tax
                        + LEVEL2.maxTaxMoney + LEVEL1.maxTaxMoney;
                break;
            case LEVEL4:
                result = (revenueTax - LEVEL3.maxRevenue) * LEVEL4.tax
                        + LEVEL3.maxTaxMoney + LEVEL2.maxTaxMoney + LEVEL1.maxTaxMoney;
                break;
            case LEVEL5:
                result = (revenueTax - LEVEL4.maxRevenue) * LEVEL5.tax
                        + LEVEL4.maxTaxMoney + LEVEL3.maxTaxMoney + LEVEL2.maxTaxMoney
                        + LEVEL1.maxTaxMoney;
                break;
            case LEVEL6:
                result = (revenueTax - LEVEL5.maxRevenue) * LEVEL6.tax
                        + LEVEL5.maxTaxMoney + LEVEL4.maxTaxMoney + LEVEL3.maxTaxMoney
                        + LEVEL2.maxTaxMoney + LEVEL1.maxTaxMoney;
                break;
            case LEVEL7:
                result = (revenueTax - LEVEL6.maxRevenue) * LEVEL7.tax
                        + LEVEL6.maxTaxMoney + LEVEL5.maxTaxMoney + LEVEL4.maxTaxMoney
                        + LEVEL3.maxTaxMoney + LEVEL2.maxTaxMoney + LEVEL1.maxTaxMoney;
                break;
        }
        return result;
    }
}