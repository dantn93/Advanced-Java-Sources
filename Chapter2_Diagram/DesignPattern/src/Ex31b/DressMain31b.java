/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex31b;

import Ex31a.EnumModel;
import Ex31a.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author snow
 */
public class DressMain31b {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            int ans = 0;
            String type = "";
            while (true) {
                System.out.print("What clothes type do you want to sew:\n");
                for (int i = 0; i < EnumModel.values().length; i++) {
                    System.out.print((i + 1) + ". " + EnumModel.values()[i].getName());
                    System.out.println("");
                }
                System.out.print("Choose: ");
                ans = Integer.parseInt(input.readLine());
                if (ans > 0 && ans <= EnumModel.values().length) {
                    type = EnumModel.values()[ans - 1].getName();
                    break;
                }
            }
            //sew clothes
            Company company = new Company();
            //The company will design the model of your clothes
            Model model = company.sew(type);
            //sew the model *_*
            model.sew();
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
