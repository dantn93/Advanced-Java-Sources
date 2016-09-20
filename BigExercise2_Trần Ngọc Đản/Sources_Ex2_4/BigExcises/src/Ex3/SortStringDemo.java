/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Tran Ngoc Dan
 * @since 19/09/2016
 * @version 1.0
 */
public class SortStringDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            List<String> list = new ArrayList<>();
            //load strings
            for (EString value : EString.values()) {
                list.add(value.getString());
            }

            //sort list by ascending of length
            ascendingSort(list);
            //sort list by decrease of length
            decreaseSort(list);
            //sort list by alphabet
            alphabetSort(list);
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

    /**
     * sort list by ascending of length.
     *
     * @param list
     */
    public static void ascendingSort(List<String> list) {
        System.out.println("== Sort by Length of string ascending ==");
        Collections.sort(list, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        list.forEach(str -> System.out.println(str));
        System.out.println("");
    }

    /**
     * sort list by decrease of length.
     *
     * @param list
     */
    public static void decreaseSort(List<String> list) {
        System.out.println("== Sort by Length of string decrease ==");
        Collections.sort(list, (s1, s2) -> Integer.compare(s2.length(), s1.length()));
        list.forEach(str -> System.out.println(str));
        System.out.println("");
    }

    /**
     * sort list by alphabet.
     * @param list
     */
    public static void alphabetSort(List<String> list) {
        System.out.println("== Sort by Alphabet ==");
        Collections.sort(list, (s1, s2) -> s1.compareTo(s2));
        list.forEach(str -> System.out.println(str));
        System.out.println("");
    }
}