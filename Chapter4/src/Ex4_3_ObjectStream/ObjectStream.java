/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4_3_ObjectStream;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 12/09/2016
 */
public class ObjectStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            List<Student> list = new ArrayList<>();
            for (int i = 0; i < StudentList.values().length; i++) {
                list.add(new Student(StudentList.values()[i].getName(), StudentList.values()[i].getAge(),
                        StudentList.values()[i].getMark1(), StudentList.values()[i].getMark2()));
            }

            //Show list of student 
            list.stream().forEach(e -> System.out.println(e.showInfo()));
            //number of student has old >= 18
            int count = (int) list.stream().filter(e -> e.getAge() >= 18).count();
            System.out.println("Number of student has old >= 18: " + count);
            //number of student has first name which is H
            count = (int) list.stream().filter(e -> (e.getName().charAt(0) + "").equalsIgnoreCase("h")).count();
            System.out.println("Number of student has his/her name's first letter is H/h: " + count);
            //print first student (has first name is H)
            Optional<Student> opt = list.stream().filter(e -> (e.getName().charAt(0) + "").equalsIgnoreCase("h")).findFirst();
            System.out.println("Show first student has his/her name's first letter is H/h");
            System.out.println("\t" + opt.get().showInfo());
            //calculate maximum & minimum average, then vaerage of average
            DoubleSummaryStatistics stats = list.stream().mapToDouble(e -> e.avg()).summaryStatistics();
            System.out.println("Highest average: " + stats.getMax());
            System.out.println("Lowest average: " + stats.getMin());
            System.out.println("Average of average mark: " + String.format("%.2f", stats.getAverage()));

            //list have very good students
            Stream<Student> goodList = list.stream().filter(e -> e.avg() >= 8.0);
            System.out.println("List of very good student");
            goodList.forEach(e -> System.out.println(e.showInfo()));

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }
}
