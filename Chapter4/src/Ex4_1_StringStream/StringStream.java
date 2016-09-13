/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4_1_StringStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 12/09/2016
 */
public class StringStream {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            List<String> list1 = Arrays.asList("William", "Shakespeare", "is", "widely", "regarded",
                    "as", "the", "", "writer", "the", "English", "happy",
                    "has", "ever", "seen");
            //== LIST 1 ==
            System.out.println("\t== LIST 1 == ");
            //Print elements of list1
            System.out.println("List1: " + list1);
            //count elemtns is ""
            int count = (int) list1.stream().filter(s -> s.equalsIgnoreCase("")).count();
            System.out.println("Number of element is \"\": " + count);

            //Number of elements whose length >= 5
            count = (int) list1.stream().filter(s -> s.length() >= 5).count();
            System.out.println("Number of element whose length >= 5: " + count);

            //Number of elements whose fist word is 'a'
            count = (int) list1.stream().filter(s -> s.startsWith("a")).count();
            System.out.println("Number of elements whose fist word is 'a': " + count);

            //Number of elements is 'happy'
            count = (int) list1.stream().filter(s -> s.equals("happy")).count();
            System.out.println("Number of elements is 'happy': " + count);

            //== LIST 2 ==
            System.out.println("\t== LIST 2 == ");
            //List of elememts without ""
            List<String> list2 = list1.stream().filter(s -> !s.equals("")).collect(Collectors.toList());
            System.out.println("List of elememts without \"\": " + list2);

            //== LIST 3 ==
            System.out.println("\t== LIST 3 == ");
            //List of elememts whose length >= 3 && <=6
            List<String> list3 = list1.stream().filter(s -> s.length() >= 3 && s.length() <= 6).collect(Collectors.toList());
            System.out.println("List of elememts whose length >= 3 && <=6: " + list3);
            String mergeString = list3.stream().collect(Collectors.joining(","));
            System.out.println("Merged String: " + mergeString);
            
            //== LIST 4 ==
            System.out.println("\t== LIST 4 == ");
            List<String> list4 = list1.stream().map(s -> s + " happy").collect(Collectors.toList());
            System.out.println("Element add happy: " + list4);
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
