/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex7_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 16/09/2016
 */
public class DirectoryMain {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            TelephoneDirectory directory = new TelephoneDirectory();
            directory.loadContact();
            
            while (true) {
                System.out.println("\n");
                System.out.println("1. Show all contact");
                System.out.println("2. Search contact");
                System.out.println("3. Add new contact");
                System.out.println("4. Remove contact");
                System.out.println("5. Update contact");
                System.out.println("6. Exit");

                int ans = 0;
                while (true) {
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 6) {
                        break;
                    }
                }
                switch (ans) {
                    case 1:
                        System.out.println("== Show all contact ==");
                        directory.showAllContact();
                        break;
                    case 2:

                        System.out.print("[Name]: ");
                        String name = input.readLine();
                        System.out.println("== List of contacts ==");
                        directory.searchContact(name);
                        break;
                    case 3:
                        System.out.println("== Add new contact ==");
                        int ans1 = 0;
                        System.out.print("[Name]: ");
                        name = input.readLine();
                        System.out.print("[Numberphone]: ");
                        String numberPhone = input.readLine();
                        directory.addContact(numberPhone, name);
                        break;
                    case 4:
                        System.out.println("== Remove contact ==");
                        int ans2 = 0;
                        while (true) {
                            System.out.println("1. Remove a contact regarding to name");
                            System.out.println("2. Remove a contact regarding to numberphone");
                            System.out.print("Choose: ");
                            ans2 = Integer.parseInt(input.readLine());
                            if (ans2 == 1 || ans2 == 2) {
                                break;
                            }
                        }

                        if (ans2 == 1) {
                            System.out.print("[Name]: ");
                            String nameSearching = input.readLine();
                            directory.removeContactRegardingName(nameSearching);
                        }
                        if (ans2 == 2) {
                            System.out.print("[NumberPhone]: ");
                            String numberSearching = input.readLine();
                            directory.removeContactRegardingNumPhone(numberSearching);
                        }
                        break;
                    case 5:
                        System.out.println("== Update contact ==");
                        System.out.print("[Name]: ");
                        String updatedName = input.readLine();
                        directory.updateContact(updatedName);
                }
                if (ans == 6) {
                    directory.updateFileContact();
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }
}
