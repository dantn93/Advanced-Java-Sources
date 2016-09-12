/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4_2_NumberStream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 12/09/2016
 */
public class NumberStream {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            List<Integer> list1 = Arrays.asList(2, 11, 10, 9, 5, 36, 47, 200, 400, 567, 11, 67, 890, 34, 0);
            //== LIST 1 ==
            System.out.println("\t== LIST 1 == ");
            //Print elements of list1
            System.out.println("List1: " + list1);

            //== LIST 2 ==
            System.out.println("\t== LIST 2 == ");
            //List of elememts without ""
            List<Integer> list2 = list1.stream().map(n -> n * n).collect(Collectors.toList());
            System.out.println("List 2 is square of list1: " + list2);
            //Statistic
            IntSummaryStatistics stats = list2.stream().mapToInt((x) -> x).summaryStatistics();
            System.out.println("Highest number: " + stats.getMax());
            System.out.println("Lowest number: " + stats.getMin());
            System.out.println("Sum of all numbers: " + stats.getSum());
            System.out.println("Average of all number: " + stats.getAverage());

            //== LIST 3 ==
            //Check prime number
            System.out.println("\t== LIST 3 == ");
            List<Integer> list3 = list2.stream().filter(n -> checkPrimeNumber(n)).collect(Collectors.toList());
            System.out.println("List of prime numbers: " + list3);

            //== LIST 4 ==
            //check square numbers
            System.out.println("\t== LIST 4 == ");
            List<Integer> list4 = list2.stream().filter(n -> checkSquareNumber(n)).collect(Collectors.toList());
            System.out.println("List of prime numbers: " + list4);

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

    //Check prime number
    //return true if the number is prime number, else return false
    public static boolean checkPrimeNumber(int n) {
        if (n > 0) {
            int m = (int) Math.sqrt(n);
            for (int i = 2; i <= m; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //check square number
    public static boolean checkSquareNumber(int n) {
        if (n >= 0 && Math.pow((int) Math.sqrt(n), 2) == n) {
            return true;
        } else {
            return false;
        }
    }
}
