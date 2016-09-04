/**
 * This code manages staff in a company
 */
package Ex13;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Tran Ngoc Dan
 * @Date: 23/08/2016
 * @Version: 1.0
 */
public class ManagementMain {

    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Company obj = new Company();
        try {
            while (true) {
                System.out.println("==Calculating Revenue==");
                System.out.println("Fill out information");
                System.out.print("Name: ");
                String name = input.readLine();
                System.out.print("Coefficient of Salary: ");
                double coeff = Double.parseDouble(input.readLine());
                System.out.print("The number of people who are subtracted: ");
                int num = Integer.parseInt(input.readLine());
                System.out.print("Mothly bonus: ");
                double bonus = Double.parseDouble(input.readLine());

                while (true) {
                    System.out.print("He/She is a Trader(1) or Producer(2): ");
                    int ans = Integer.parseInt(input.readLine());
                    if (ans == 1) {
                        double businessWage = 0;
                        while (true) {
                            System.out.print("Business Wage: ");
                            businessWage = Double.parseDouble(input.readLine());
                            if (businessWage >= 0) {
                                break;
                            }
                        }

                        double businessWageRate = 0;
                        while (true) {
                            System.out.print("Business Wage Rate: ");
                            businessWageRate = Double.parseDouble(input.readLine());
                            if (businessWageRate >= 0) {
                                break;
                            }
                        }
                        obj.addTrader(new Trader(businessWage, businessWageRate, name, coeff, num, bonus));
                        break;
                    }
                    if (ans == 2) {
                        int quantity = 0;
                        while (true) {
                            System.out.print("The quantity of products: ");
                            quantity = Integer.parseInt(input.readLine());
                            if (quantity >= 0) {
                                break;
                            }
                        }
                        obj.addProducer(new Producer(quantity, name, coeff, num, bonus));
                        break;
                    }
                }

                //Ask continue
                boolean flag = false;
                while (true) {
                    System.out.print("Do you want to add another employee into school (y/n): ");
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
