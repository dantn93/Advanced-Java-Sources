/**
 * This code implement inner class
 */
package Ex18;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Tran Ngoc Dan
 * @version 1.0
 * @date 24/08/2016
 */
public class OrderMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("== ORDERS INFORMATION ==");
            while (true) {
                while (true) {
                    System.out.print("Name: ");
                    String name = input.readLine();
                    System.out.print("Shape: ");
                    String shape = input.readLine();
                    System.out.print("Color: ");
                    String color = input.readLine();
                    double weight = 0;
                    while (true) {
                        System.out.print("Weight: ");
                        weight = Double.parseDouble(input.readLine());
                        if (weight > 0) {
                            break;
                        }
                    }

                    GiftBox box = new GiftBox(shape, color);
                    GiftBox.Gift gift = box.new Gift(name, weight);
                    System.out.println("Fee: "+gift.calFee());
                    break;
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
