/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex28;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author snow
 */
public class ObserverMain {
    
    final static double BALANCE = 1000000;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                Account account = new Account(BALANCE);
                new EmailObserver(account);
                new MobiObserver(account);

                //fill in number of money
                double amount = 0;
                while (true) {
                    System.out.print("Please fill in number of money: ");
                    amount = Double.parseDouble(input.readLine());
                    if (amount > 0) {
                        break;
                    }
                }
                
                if (amount > account.getState()) {
                    System.out.println("You can't tranfer money");
                    account.notifyAllObservers();
                } else {
                    System.out.println("You can tranfer money");
                    account.setState(account.getState() - amount);
                }
                //Ask continue
                boolean flag = false;
                while (true) {
                    System.out.print("\n\nDo you want another operation (y/n): ");
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
            
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }
}
