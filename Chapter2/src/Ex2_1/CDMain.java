
package Ex2_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 08/09/2016
 */
public class CDMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            ArrayList<CD> list = new ArrayList<CD>() {
            };
            while (true) {
                System.out.println("1. Add a CD");
                System.out.println("2. Show list of CDs");
                System.out.println("3. Sort list of CDs");
                System.out.println("4. Quit");
                int ans = 0;
                while (true) {
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 4) {
                        break;
                    }
                }
                switch (ans) {
                    case 1:
                        System.out.println("== Fill out CD's information ==");
                        System.out.print("[ID]: ");
                        String id = input.readLine();
                        System.out.print("[Name]: ");
                        String name = input.readLine();
                        System.out.print("[Singer]: ");
                        String singer = input.readLine();
                        int numberOfSongs = 0;
                        while (true) {
                            if (numberOfSongs <= 0) {
                                System.out.print("[Number of songs]: ");
                                numberOfSongs = Integer.parseInt(input.readLine());
                            } else {
                                break;
                            }
                        }
                        double price = 0;
                        while (true) {
                            if (price <= 0) {
                                System.out.print("[Price]: ");
                                price = Double.parseDouble(input.readLine());
                            } else {
                                break;
                            }
                        }
                        list.add(new CD(id, name, singer, numberOfSongs, price));
                        break;
                    case 2:
                        System.out.println("== Show list of CDs");
                        double sumPrice = 0;
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println("CD[" + i + "]");
                            list.get(i).showInfo();
                            sumPrice += list.get(i).getPrice();
                        }
                        System.out.println("Total price: " + sumPrice);
                        break;
                    case 3:
                        Collections.sort(list);
                        break;
                }
                if (ans == 4) {
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
