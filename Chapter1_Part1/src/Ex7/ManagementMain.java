/**
 * This code manages CD collection
 */
package Ex7;

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
            System.out.println("== CDs Managerment Program ==");
            System.out.println("Please provide the information of your CD");
            CollectionOfCDs obj = new CollectionOfCDs();
            while (true) {
                System.out.print("ID: ");
                String id = input.readLine();
                System.out.print("Name of CD: ");
                String name = input.readLine();
                System.out.print("Single: ");
                String singer = input.readLine();
                System.out.print("Number of songs: ");
                int numOfSongs = Integer.parseInt(input.readLine());
                System.out.print("Price: ");
                double price = Double.parseDouble(input.readLine());

                CD cd = new CD(id, name, singer, numOfSongs, price);
                obj.addCD(cd);
                System.out.println("I have just added your CD into the Collection");
                System.out.print("Do you want to continue add CDs into Collection (y/n)? ");
                String ans = input.readLine();
                if (ans.equalsIgnoreCase("y")) {
                    continue;
                }

                //Print Information and Price
                System.out.println("\n== Show all information in Collection ==");
                obj.calPriceOfAllCDs();
                System.exit(0);
            }
        } catch (Exception ex) {

        }
    }

}
