/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex6_1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author snow
 */
public class Diary {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                int ans = 0;
                while (true) {
                    System.out.println("\n1. Write");
                    System.out.println("2. Read diary");
                    System.out.println("3. Quit");
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans == 1 || ans == 2 || ans == 3) {
                        break;
                    }
                }

                switch (ans) {
                    case 1:
                        writeDiary();
                        break;
                    case 2:
                        List<String> list = readDaiary();
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println(list.get(i));
                        }
                        break;
                }
                if (ans == 3) {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

    public static void writeDiary() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, "ISO-8859-15"));
        System.out.println("== Write diary ==");
        while (true) {
            System.out.println("Quit if you type \"q\"");
            System.out.print("[Note]... ");
            String note = input.readLine();
            if (note.equalsIgnoreCase("q")) {
                break;
            }
            //get time
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = new Date();
            String d = dateFormat.format(date);
            //write
            try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("src\\Ex6_1\\daily.txt", true)))) {
                out.writeUTF(d);
                out.writeUTF(note);
                out.close();
            } catch (Exception ex) {
                System.out.println("Err: " + ex.getMessage());
            }
        }
    }

    public static List readDaiary() throws IOException {
        System.out.println("== Read diary ==");
        List<String> list = new ArrayList<>();
        try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("src\\Ex6_1\\daily.txt")))) {
            String date;
            String contents;
            String s;
            while (in.available() > 0) {
                System.out.println(in.readUTF() + " " + in.readUTF());
            }

        } catch (Exception e) {
            System.out.println("Err: " + e.getMessage());
        }
        return list;
    }
}
