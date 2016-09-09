/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 08/09/2016
 */
public class TelephoneDirectory {

    BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    //HashMap<numPhone, nameOfContact>
    private ArrayList<Contact> directory;

    public TelephoneDirectory() {
        this.directory = new ArrayList<Contact>();
    }

    public void addContact(String numberPhone, String name) {

        boolean numFlag = false;
        boolean nameFlag = false;
        for (int i = 0; i < this.directory.size(); i++) {
            numFlag = false;
            nameFlag = false;
            if (this.directory.get(i).getNumberPhone().compareTo(numberPhone) == 0) {
                numFlag = true;
            }
            if (this.directory.get(i).getName().compareToIgnoreCase(name) == 0) {
                nameFlag = true;
            }
            
            if(numFlag == true && nameFlag == true)
                break;
        }
        
        //If the directory hasn't contact, then add contact
        if (numFlag == true && nameFlag == true && this.directory.size() > 0) {
            System.out.println("The contact existed in directory");
        } else {
            this.directory.add(new Contact(numberPhone, name));
            System.out.println("Add contact successfully!");
        }
    }

    private ArrayList<Integer> searchContactRegardingName(String name) {
        ArrayList<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < this.directory.size(); i++) {
            if (this.directory.get(i).getName().compareToIgnoreCase(name) == 0) {
                index.add(i);
            }
        }
        return index;
    }

    public void searchName(String name) {
        ArrayList<Integer> index = searchContactRegardingName(name);
        for (int i = 0; i < index.size(); i++) {
            System.out.println("[NumberPhone] " + this.directory.get(index.get(i)).getNumberPhone());
            System.out.println("");
        }
    }

    private ArrayList<Integer> searchContactRegardingNumPhone(String numberPhone) {
        ArrayList<Integer> index = new ArrayList<Integer>();
        for (int i = 0; i < this.directory.size(); i++) {
            if (this.directory.get(i).getNumberPhone().compareTo(numberPhone) == 0) {
                index.add(i);
            }
        }
        return index;
    }

    public void searchNumberPhone(String numberPhone) {
        ArrayList<Integer> index = searchContactRegardingNumPhone(numberPhone);
        for (int i = 0; i < index.size(); i++) {
            System.out.println("[Name] " + this.directory.get(index.get(i)).getName());
            System.out.println("");
        }
    }

    //remove contact regarding to his numberphone
    public void removeContactRegardingNumPhone(String numberPhone) throws IOException {
        ArrayList<Integer> index = searchContactRegardingNumPhone(numberPhone);
        if (index.size() > 0) {
            //Show list results
            int ans = 0;
            while (true) {
                for (int i = 0; i < index.size(); i++) {
                    System.out.println((i + 1) + ". " + this.directory.get(index.get(i)).getNumberPhone() + " - " + this.directory.get(index.get(i)).getName());
                }
                //Choose the item which wanna remove
                System.out.print("Choose: ");
                ans = Integer.parseInt(input.readLine());
                if (ans >= 1 && ans <= index.size()) {
                    break;
                }
            }
            //remove
            this.directory.remove(index.get(ans - 1).intValue());
            System.out.println("Remove contact successfully");
        } else {
            System.out.println(numberPhone + " doesn't exist in directory");
        }
    }

    //remove contact regarding to his name
    public void removeContactRegardingName(String name) throws IOException {
        ArrayList<Integer> index = searchContactRegardingName(name);
        if (index.size() > 0) {
            //Show list results
            int ans = 0;
            while (true) {
                for (int i = 0; i < index.size(); i++) {
                    System.out.println((i + 1) + ". " + this.directory.get(index.get(i)).getName() + " - " + this.directory.get(index.get(i)).getNumberPhone());
                }
                //Choose the item which wanna remove
                System.out.print("Choose: ");
                ans = Integer.parseInt(input.readLine());
                if (ans >= 1 && ans <= index.size()) {
                    break;
                }
            }
            //remove
            this.directory.remove(index.get(ans-1).intValue());
            System.out.println("Remove contact successfully");
        } else {
            System.out.println(name + " doesn't exist in directory");
        }
    }

    public void updateContact(String name) throws IOException {
        System.out.println("== Delete information of contact ==");
        ArrayList<Integer> index = searchContactRegardingName(name);
        if (index.size() > 0) {
            //Show list results
            int ans = 0;
            while (true) {
                for (int i = 0; i < index.size(); i++) {
                    System.out.println((i + 1) + ". " + this.directory.get(index.get(i)).getName() + " - " + this.directory.get(index.get(i)).getNumberPhone());
                }
                //Choose the item which wanna update

                System.out.print("Choose: ");
                ans = Integer.parseInt(input.readLine());
                if (ans >= 1 && ans <= index.size()) {
                    break;
                }
            }
            //update information
            System.out.print("Fill new numberphone: ");
            String newNumberPhone = input.readLine();
            this.directory.set(index.get(ans-1), new Contact(newNumberPhone, this.directory.get(index.get(ans-1)).getName()));
            System.out.println("Update successfully");
        } else {
            System.out.println(name + " doesn't exist in directory");
        }
    }

    public void showAllContact() {
        System.out.println("Number of contacts: "+this.directory.size());
        if (this.directory.size() > 0) {
            for (int i = 0; i < this.directory.size(); i++) {
                System.out.println(i+1);
                System.out.println("\t[Name] " + this.directory.get(i).getName());
                System.out.println("\t[NumberPhone] " + this.directory.get(i).getNumberPhone());
                System.out.println("");
            }
        }
    }
}
