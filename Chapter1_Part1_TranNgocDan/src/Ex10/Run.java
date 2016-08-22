/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex10;

import Ex9.Collection;
import Ex9.Desktop;
import Ex9.Laptop;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("== School's Information Managerment ");
        School obj = new School();
        try {
            while (true) {
                System.out.println("-- Regular Information --");
                System.out.print("Name: ");
                String name = input.readLine();
                System.out.print("Date Of Birth: ");
                String dOb = input.readLine();
                System.out.print("Address: ");
                String address = input.readLine();
                System.out.print("Phone Number: ");
                String pNumber = input.readLine();

                //Choose computer type
                while (true) {
                    System.out.println("He/She is a TEACHER (1) or STUDENT (2)");
                    int ans = Integer.parseInt(input.readLine());

                    if (ans == 1) {
                        System.out.print("Be Charge Of: ");
                        String beChargeOf = input.readLine();
                        System.out.print("Coefficient of Salary: ");
                        double coeff = Double.parseDouble(input.readLine());
                        System.out.print("Bonus: ");
                        double bonus = Double.parseDouble(input.readLine());
                        obj.addTeacher(new Teacher(beChargeOf, coeff, bonus, name, dOb, address, pNumber));
                        break;
                    }
                    if (ans == 2) {
                        System.out.print("Class: ");
                        String cls = input.readLine();
                        System.out.print("Point in Semetster I: ");
                        double sm1 = Double.parseDouble(input.readLine());
                        System.out.print("Point in Semetster II: ");
                        double sm2 = Double.parseDouble(input.readLine());
                        obj.addStudent(new Student(cls, sm1, sm2, name, dOb, address, pNumber));
                        break;
                    }
                }

                boolean flag = false;
                while (true) {
                    System.out.println("Do you want to add another person into school (y/n): ");
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
            obj.showAllTeachers();
            System.out.println("");
            obj.showAllStudents();
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
