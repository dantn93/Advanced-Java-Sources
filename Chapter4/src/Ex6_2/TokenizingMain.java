/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex6_2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-15"));
            Document document = new Document();
            while (true) {
                System.out.println("0. Write document");
                System.out.println("1. Load document");
                System.out.println("2. Search token");
                System.out.println("3. Show all tokens");
                System.out.println("4. Exit");

                int ans = 0;
                while (true) {
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 0 && ans <= 4) {
                        break;
                    }
                }
                if (ans == 0) {
                    System.out.println("== Write document ==");
                    while (true) {
                        System.out.println("Quit if you type \"q\"");
                        System.out.print("[put document]... ");
                        String note = input.readLine();
                        if (note.equalsIgnoreCase("q")) {
                            break;
                        }
                        //get time
                        //write
                        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src\\Ex6_2\\document.txt", true)))) {
                            out.writeUTF(note);
                            out.close();
                        } catch (Exception ex) {
                            System.out.println("Err: " + ex.getMessage());
                        }
                    }
                }

                if (ans == 1) {
                    System.out.println("== Load document ==");
                    System.out.println("== Read diary ==");
                    String str = "";
                    try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("src\\Ex6_2\\document.txt")))) {
                        
                        while (in.available() > 0) {
                            str+=" " + in.readUTF();
                        }
                        in.close();
                    } catch (Exception e) {
                        System.out.println("Err: " + e.getMessage());
                    }
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
