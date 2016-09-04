/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex31a;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author snow
 */
public class DressMain {

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
            ModelFactory modelFactory = new ModelFactory();
            Model model = modelFactory.chooseClothes(type);
            //show what clothes you want to sew
            model.sew();
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }
}
