/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 08/09/2016
 */
public class DictionaryMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            Dictionary dictionary = new Dictionary();
            while (true) {
                System.out.println("1. Add a word");
                System.out.println("2. Search word");
                System.out.println("3. Delete word");
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
                        System.out.println("== Fill out information of word ==");
                        System.out.print("[word]: ");
                        String word = input.readLine();
                        System.out.print("[Meaning]: ");
                        String meaning = input.readLine();
                        dictionary.add(word, meaning);
                        System.out.println("");
                        break;
                    case 2:
                        System.out.println("== Searching ==");
                        System.out.print("[Finding word]: ");
                        word = input.readLine();
                        dictionary.search(word);
                        System.out.println("");
                        break;
                    case 3:
                        System.out.println("== Deleting ==");
                        System.out.print("[Finding word]: ");
                        word = input.readLine();
                        dictionary.deleteWord(word);
                        System.out.println("");
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
