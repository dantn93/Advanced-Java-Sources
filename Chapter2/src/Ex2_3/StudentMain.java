/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_3;

import Ex2_2.Dictionary;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 08/09/2016
 */
public class StudentMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            TreeMap<String, Student> school = new TreeMap<String, Student>();
            while (true) {
                System.out.println("1. Add a student");
                System.out.println("2. Search a student");
                System.out.println("3. Remove a student");
                System.out.println("4. View all studens");
                System.out.println("5. Quit");
                int ans = 0;
                while (true) {
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 5) {
                        break;
                    }
                }
                switch (ans) {
                    case 1:
                        System.out.println("== Fill out information of student ==");
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
                        System.out.print("[Place of birth]: ");
                        String placeOfBirth = input.readLine();
                        if (school.containsKey(id) == false) {
                            school.put(id, new Student(name, age, placeOfBirth));
                            System.out.println("Add a student successfully!");
                        } else {
                            System.out.println("Student has existed");
                        }

                        System.out.println("");
                        break;
                    case 2:
                        System.out.println("== Searching a student ==");
                        System.out.print("[ID]: ");
                        id = input.readLine();
                        if (school.containsKey(id) == true) {
                            school.get(id).showInfo();
                        } else {
                            System.out.println("The student isn't existed");
                        }
                        System.out.println("");
                        break;
                    case 3:
                        System.out.println("== Remove a student ==");
                        System.out.print("[ID]: ");
                        id = input.readLine();
                        if (school.containsKey(id) == true) {
                            school.remove(id);
                            System.out.println("Remove student successfully");
                        } else {
                            System.out.println("The student isn't existed");
                        }
                    case 4:
                        System.out.println("== View all students ==");
                        for (Object object : school.keySet()) {
                            school.get(object).showInfo();
                        }
                }
                if (ans == 5) {
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
