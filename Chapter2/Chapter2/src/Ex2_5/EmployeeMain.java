/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 *
 * @author snow
 */
public class EmployeeMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            HashMap<String, Employee> school = new HashMap<String, Employee>();
            while (true) {
                System.out.println("1. Add an employee");
                System.out.println("2. Search an employee");
                System.out.println("3. Remove an employee");
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
                        System.out.println("== Fill out information of employee ==");
                        System.out.print("[ID]: ");
                        String id = input.readLine();
                        System.out.print("[Name]: ");
                        String name = input.readLine();

                        int age = 0;
                        while (true) {
                            System.out.print("[age]: ");
                            age = Integer.parseInt(input.readLine());
                            if (age > 0) {
                                break;
                            }
                        }
                        double salary = 0;
                        while (true) {
                            System.out.print("[Salary]: ");
                            salary = Integer.parseInt(input.readLine());
                            if (salary > 0) {
                                break;
                            }
                        }
                        if (school.containsKey(id) == false) {
                            school.put(id, new Employee(name, age, salary));
                            System.out.println("Add an employee successfully!");
                        } else {
                            System.out.println("Employee has existed");
                        }

                        System.out.println("");
                        break;
                    case 2:
                        System.out.println("== Searching an employee ==");
                        System.out.print("[ID]: ");
                        id = input.readLine();
                        if (school.containsKey(id) == true) {
                            school.get(id).showInfo();
                        } else {
                            System.out.println("The employee isn't existed");
                        }
                        System.out.println("");
                        break;
                    case 3:
                        System.out.println("== Remove an employee ==");
                        System.out.print("[ID]: ");
                        id = input.readLine();
                        if (school.containsKey(id) == true) {
                            school.remove(id);
                            System.out.println("Remove employee successfully");
                        } else {
                            System.out.println("The employee isn't existed");
                        }
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
