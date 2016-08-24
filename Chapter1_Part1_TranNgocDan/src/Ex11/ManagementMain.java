/**
 * This code manages Gold price & Money price
 */
package Ex11;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class ManagementMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("== Transaction Managerment ");
        TranCollection obj = new TranCollection();
        try {
            while (true) {
                System.out.println("-- Regular Information --");
                System.out.print("Code Transaction: ");
                String code = input.readLine();
                System.out.print("Date: ");
                String d = input.readLine();
                System.out.print("Quantity: ");
                int number = Integer.parseInt(input.readLine());
                while (true) {
                    System.out.print("Transaction Type - Gold(1) or Money(2): ");
                    int ans = Integer.parseInt(input.readLine());
                    if (ans == 1) {
                        while (true) {
                            System.out.print("Choose Gold Code - SJC9999(1) or GOLD24K(2): ");
                            int ans1 = Integer.parseInt(input.readLine());
                            if (ans1 == 1) {
                                GoldTransaction gt = new GoldTransaction(code, d, number);
                                gt.calPrice("SJC9999");
                                obj.addGoldTransaction(gt);
                                break;
                            }
                            if (ans1 == 2) {
                                GoldTransaction gt = new GoldTransaction(code, d, number);
                                gt.calPrice("GOLD24K");
                                obj.addGoldTransaction(gt);
                                break;
                            }
                        }
                        break;
                    }
                    if (ans == 2) {
                        while (true) {
                            System.out.print("Choose BUY(1) or SELL(2): ");
                            int ans1 = Integer.parseInt(input.readLine());
                            if (ans1 == 1) {
                                while (true) {
                                    System.out.print("Buy USD(1), Buy EUR(2), Buy AUD(3): ");
                                    int ans2 = Integer.parseInt(input.readLine());
                                    if (ans2 == 1) {
                                        MoneyTransaction mt = new MoneyTransaction(code, d, number);
                                        mt.calBuyPrice("USD");
                                        obj.addBuyTransaction(mt);
                                        break;
                                    }
                                    if (ans2 == 2) {
                                        MoneyTransaction mt = new MoneyTransaction(code, d, number);
                                        mt.calBuyPrice("EUR");
                                        obj.addBuyTransaction(mt);
                                        break;
                                    }
                                    if (ans2 == 3) {
                                        MoneyTransaction mt = new MoneyTransaction(code, d, number);
                                        mt.calBuyPrice("AUD");
                                        obj.addBuyTransaction(mt);
                                        break;
                                    }
                                }
                                break;
                            }
                            if (ans1 == 2) {
                                while (true) {
                                    System.out.print("Sell USD(1), Sell EUR(2), Sell AUD(3): ");
                                    int ans2 = Integer.parseInt(input.readLine());
                                    if (ans2 == 1) {
                                        MoneyTransaction mt = new MoneyTransaction(code, d, number);
                                        mt.calSellPrice("USD");
                                        obj.addSellTransaction(mt);
                                        break;
                                    }
                                    if (ans2 == 2) {
                                        MoneyTransaction mt = new MoneyTransaction(code, d, number);
                                        mt.calSellPrice("EUR");
                                        obj.addSellTransaction(mt);
                                        break;
                                    }
                                    if (ans2 == 3) {
                                        MoneyTransaction mt = new MoneyTransaction(code, d, number);
                                        mt.calSellPrice("AUD");
                                        obj.addSellTransaction(mt);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }

                //Ask continue
                boolean flag = false;
                while (true) {
                    System.out.print("Do you want to add another transaction into school (y/n): ");
                    String agr = input.readLine();
                    if (agr.equalsIgnoreCase("y")) {
                        break;
                    } else if (agr.equalsIgnoreCase("n")) {
                        flag = true;
                        break;
                    }
                }
                if (flag == true) {
                    break;
                }
            }

            //Show information
            obj.showInfo();
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
