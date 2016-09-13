/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3_2;

import java.util.Arrays;
import java.util.List;
public class PaymentMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            List<Integer> amounts = Arrays.asList(new Integer[]{2, 3, 5, 7});
            int price = 5200;
            amounts.forEach(element -> {
                System.out.println("Thanh tien = " + price * element + " vnd");
            });
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }
}
