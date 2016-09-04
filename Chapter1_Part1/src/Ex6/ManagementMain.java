/**
 * This code manages staff in a company
 */
package Ex6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 */
public class ManagementMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("==Calculate Revenue==");
                System.out.print("Name: ");
                String name = input.readLine();
                System.out.print("Coefficient of Salary: ");
                double coeff = Double.parseDouble(input.readLine());
                System.out.print("The number of people who are subtracted: ");
                int num = Integer.parseInt(input.readLine());
                System.out.print("Mothly bonus: ");
                double bonus = Double.parseDouble(input.readLine());

                Employee person = new Employee(name, coeff, num, bonus);
                System.out.println("Revenue: " + String.format("%.2f",person.calRevenue()));
                System.out.println("Tax Revenue: " + String.format("%.2f",person.calTaxRevenue()));
                System.out.println("Personal tax Revenue: " + String.format("%.2f",person.calPersonalRevenueTax()));
                System.out.println("Real Revenue: " + String.format("%.2f",person.calrealRevenue()));

                //ask for continution
                System.out.print("Do you want to continue (y/n)? ");
                String ans;
                while (true) {
                    ans = input.readLine();
                    if (ans.equalsIgnoreCase("y")) {
                        break;
                    } else {
                        System.exit(0);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }
}
