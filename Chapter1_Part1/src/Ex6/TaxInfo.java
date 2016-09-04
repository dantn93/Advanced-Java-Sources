package Ex6;
/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 */
//Enum about information of tax
public enum TaxInfo {
    LEVEL1(0, 5, 0.05, 250000), LEVEL2(5, 10, 0.1, 500000), LEVEL3(10, 18, 0.15, 1200000),
    LEVEL4(18, 32, 0.2, 2800000), LEVEL5(32, 52, 0.25, 5000000), LEVEL6(52, 80, 0.3, 8400000),
    LEVEL7(80, Double.POSITIVE_INFINITY, 0.35, 0);

    private double minRevenue;
    private double maxRevenue;
    private double tax;
    private double maxTaxMoney;

    private TaxInfo(double minRevenue, double maxRevenue, double tax, double maxTaxMoney) {
        double UNIT = 1000000;
        this.minRevenue = minRevenue * UNIT;
        this.maxRevenue = maxRevenue * UNIT;
        this.tax = tax;
        this.maxTaxMoney = maxTaxMoney;
    }

    public double getMinRevenue() {
        return minRevenue;
    }

    public double getMaxRevenue() {
        return maxRevenue;
    }

    public double getTax() {
        return tax;
    }

    public double getMaxTaxMoney() {
        return maxTaxMoney;
    }
}
