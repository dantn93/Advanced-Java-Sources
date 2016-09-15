/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex6_3;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author snow
 */
public class StudentManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            List<Student> list = new ArrayList<>();
            while (true) {
                System.out.println("1. Add student");
                System.out.println("2. Load and show list of students");
                System.out.println("3. Statistics");
                System.out.println("4. Quit");
                int ans = 0;
                while (true) {
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 4) {
                        break;
                    }
                }

                //add student
                if (ans == 1) {
                    System.out.print("[Name]: ");
                    String name = input.readLine();//name
                    int grade = 0;//grade of student
                    while (true) {
                        System.out.print("[Grade]: ");
                        grade = Integer.parseInt(input.readLine());
                        if (grade > 0) {
                            break;
                        }
                    }

                    //put mark in semester 1
                    double semester1 = 0;
                    while (true) {
                        System.out.print("[Mark in Semester 1]: ");
                        semester1 = Double.parseDouble(input.readLine());
                        if (semester1 > 0) {
                            break;
                        }
                    }

                    //put mark in semester 2
                    double semester2 = 0;
                    while (true) {
                        System.out.print("[Mark in Semester 2]: ");
                        semester2 = Double.parseDouble(input.readLine());
                        if (semester2 > 0) {
                            break;
                        }
                    }
                    Student student = new Student(name, grade, semester1, semester2);
                    student.writeIntoFile("src\\Ex6_3\\tongketnamhoc.txt");
                }
                //show list of students
                if (ans == 2) {
                    String name;
                    int grade;
                    double semester1;
                    double semester2;
                    try (DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("src\\Ex6_3\\tongketnamhoc.txt")))) {

                        while (in.available() > 0) {
                            name = in.readUTF();
                            grade = in.readInt();
                            semester1 = in.readDouble();
                            semester2 = in.readDouble();
                            list.add(new Student(name, grade, semester1, semester2));
                        }
                        in.close();

                        //show list of students
                        for (int i = 0; i < list.size(); i++) {
                            list.get(i).showInfo();
                            System.out.println("");
                        }

                    } catch (Exception e) {
                        System.out.println("Err: " + e.getMessage());
                    }
                }
                //Analysis of students marks with descriptive statistics
                if (ans == 3) {
                    //1 == GRADE ==//
                    System.out.println("== LIST OF STUDENTS IN GRADE 10 ==");
                    Stream<Student> str10 = list.stream().filter(e -> e.getGrade() == 10);
                    str10.forEach(e -> e.showInfo());

                    System.out.println("\n== LIST OF STUDENTS IN GRADE 11 ==");
                    Stream<Student> str11 = list.stream().filter(e -> e.getGrade() == 11);
                    str11.forEach(e -> e.showInfo());

                    System.out.println("\n== LIST OF STUDENTS IN GRADE 12 ==");
                    Stream<Student> str12 = list.stream().filter(e -> e.getGrade() == 12);
                    str12.forEach(e -> e.showInfo());

                    //2 == TYPE OF STUDENTS ==//
                    //statistics
                    System.out.println("\n[Number of excellent students]: " + list.stream().filter(e -> e.getAverage() >= 8).count());
                    System.out.println("[Number of good students]: " + list.stream().filter(e -> e.getAverage() >= 7 && e.getAverage() < 8).count());
                    System.out.println("[Number of normal students]: " + list.stream().filter(e -> e.getAverage() >= 5 && e.getAverage() < 7).count());
                    System.out.println("[Number of bad students]: " + list.stream().filter(e -> e.getAverage() < 5).count());

                    //3 == NUMBER OF STUDENT REGARDING TO GRADE ==//
                    
                    System.out.println("\n[Number of students in grade 10]: " + list.stream().filter(e -> e.getGrade() == 10).count());
                    System.out.println("[Number of students in grade 11]: " + list.stream().filter(e -> e.getGrade() == 11).count());
                    System.out.println("[Number of students in grade 12]: " + list.stream().filter(e -> e.getGrade() == 12).count());

                    //average of average
                    System.out.println("\n[Average of average mark in grade 10]: " + list.stream().filter(e -> e.getGrade() == 10).mapToDouble(e -> e.getAverage()).summaryStatistics().getAverage());
                    System.out.println("[Average of average mark in grade 11]: " + list.stream().filter(e -> e.getGrade() == 11).mapToDouble(e -> e.getAverage()).summaryStatistics().getAverage());
                    System.out.println("[Average of average mark in grade 12]: " + list.stream().filter(e -> e.getGrade() == 12).mapToDouble(e -> e.getAverage()).summaryStatistics().getAverage());
                }
                //quit
                if (ans == 4) {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
