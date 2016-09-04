/**
 * This code manages computers in a store
 */
package Ex9;

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
        System.out.println("== Computer Managerment ");
        Collection obj = new Collection();
        try {
            while (true) {
                System.out.println("-- Regular Information --");
                System.out.print("ID: ");
                String ID = input.readLine();
                System.out.print("Price: ");
                double price = Double.parseDouble(input.readLine());
                System.out.print("Manufacturer: ");
                String manufacturer = input.readLine();
                System.out.print("Quantity: ");
                int quantity = Integer.parseInt(input.readLine());

                //Choose computer type
                System.out.println("Do you want LAPTOP (1) or DESTOP (2)");
                int ans = Integer.parseInt(input.readLine());
                if (ans == 1) {
                    System.out.print("Weight: ");
                    double weight = Double.parseDouble(input.readLine());
                    System.out.print("Battery Life: ");
                    double batteryLife = Double.parseDouble(input.readLine());
                    System.out.print("Monitor Size: ");
                    String monitorSize = input.readLine();
                    obj.addLaptop(new Laptop(weight, batteryLife, monitorSize, ID, price, manufacturer, quantity));
                }
                if (ans == 2) {
                    System.out.print("CPU: ");
                    String CPU = input.readLine();
                    System.out.print("RAM: ");
                    String RAM = input.readLine();
                    obj.addDesktop(new Desktop(CPU, RAM, ID, price, manufacturer, quantity));
                }

                boolean flag = false;
                while (true) {
                    System.out.println("Do you want to add another computer into collection (y/n): ");
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
            System.out.println("-- Desktop Information --");
            obj.showInfoAllDesk();
            System.out.println("-- Total Price -- ");
            obj.showDesktopCharg();
            System.out.println("\n\n-- Laptop Information --");
            obj.showInfoAllLap();
            System.out.println("-- Total Price -- ");
            obj.showLaptopCharge();
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }
}
