/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author snow
 */
public class DirectoryMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            TelephoneDirectory directory = new TelephoneDirectory();
            for (int i = 0; i < ListContact.values().length; i++) {
                String name = ListContact.values()[i].getName();
                String numberPhone = ListContact.values()[i].getNumberPhone();
                directory.addContact(numberPhone, name);
            }
            while (true) {
                System.out.println("\n");
                System.out.println("1. Show all contact");
                System.out.println("2. Add contact");
                System.out.println("3. Search contact");
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
                        System.out.println("== Add contact ==");
                        System.out.print("[Name] ");
                        String name = input.readLine();
                        System.out.print("[Number Phone] ");
                        String numberPhone = input.readLine();
                        directory.addContact(numberPhone, name);
                        break;
                    case 3:
                        System.out.println("== Search contact ==");
                        int ans1 = 0;
                        while (true) {
                            System.out.println("1. Search name");
                            System.out.println("2. Search numberphone");
                            System.out.print("Choose: ");
                            ans1 = Integer.parseInt(input.readLine());
                            if (ans1 == 1 || ans1 == 2) {
                                break;
                            }
                        }

                        if (ans1 == 1) {
                            System.out.print("[Name]: ");
                            String nameSearching = input.readLine();
                            directory.searchName(nameSearching);
                        }
                        if (ans1 == 2) {
                            System.out.print("[NumberPhone]: ");
                            String numberSearching = input.readLine();
                            directory.searchNumberPhone(numberSearching);
                        }

                        break;
                    case 4:
                        System.out.println("== Remove contact ==");
                        int ans2 = 0;
                        while (true) {
                            System.out.println("1. Search name");
                            System.out.println("2. Search numberphone");
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
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
