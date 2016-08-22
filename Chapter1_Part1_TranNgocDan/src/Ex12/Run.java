/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex12;

import Ex11.GoldTransaction;
import Ex11.MoneyTransaction;
import Ex11.TranCollection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class Run {

    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("== Library Managerment ");
        BookCollection obj = new BookCollection();
        try {
            while (true) {
                System.out.println("-- Regular Information of Book --");
                System.out.print("ID: ");
                String ID = input.readLine();
                System.out.print("Name of Book: ");
                String name = input.readLine();
                System.out.print("Day: ");
                String date = input.readLine();

                System.out.print("Price: ");
                double price = Double.parseDouble(input.readLine());
                System.out.print("Quantity: ");
                int quantity = Integer.parseInt(input.readLine());
                System.out.print("Publisher: ");
                String publisher = input.readLine();
                while (true) {
                    System.out.print("Chooes Type - TextBook(1) or ReferenceBook(2): ");
                    int ans = Integer.parseInt(input.readLine());
                    if (ans == 1) {
                        while (true) {
                            System.out.print("Book is NEW(1) or OLD(2): ");
                            int ans1 = Integer.parseInt(input.readLine());
                            if (ans1 == 1) {
                                obj.addTextBook(new TextBook("new", ID, name, date, price, quantity, publisher));
                                break;
                            }
                            if (ans1 == 2) {
                                obj.addTextBook(new TextBook("old", ID, name, date, price, quantity, publisher));
                                break;
                            }
                        }
                        break;
                    }
                    if (ans == 2) {
                        double tax = 0;
                        while (true) {
                            System.out.print("Tax (0.01 - 1): ");
                            tax = Double.parseDouble(input.readLine());
                            if (tax >= 0.01 && tax <= 1) {
                                break;
                            }
                        }
                        obj.addRefBook(new ReferenceBook(tax, ID, name, date, price, quantity, publisher));
                        break;
                    }
                }

                //Ask continue
                boolean flag = false;
                while (true) {
                    System.out.print("Do you want to add another transaction into school (y/n): ");
                    String agr = input.readLine();
                    if (agr.equalsIgnoreCase("y")) {
                        break;
                    } else if (agr.equalsIgnoreCase("n")) {
                        flag = true;
                        break;
                    }
                }
                if (flag == true) {
                    break;
                }
            }

            //Show information
            obj.showInfo();
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
