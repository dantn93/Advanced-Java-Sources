/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 08/09/2016
 *
 */
public class TokenizingMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            Document document = new Document();
            while (true) {
                System.out.println("1. Document tokenizing");
                System.out.println("2. Search token");
                System.out.println("3. Show all tokens");
                System.out.println("4. Exit");
                
                int ans = 0;
                while (true) {
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 4) {
                        break;
                    }
                }

                if (ans == 1) {
                    System.out.println("Please fill document:");
                    String str = input.readLine();
                    document.tokenize(str);

                }
                if (ans == 2) {
                    System.out.print("[token]: ");
                    String token = input.readLine();
                    document.searchToken(token);
                }
                if (ans == 3) {
                    document.showInfo();
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
