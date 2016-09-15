/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex9_1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @since : 13/09/2016
 */
public class ResourceBundleMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                int lg = 0;
                while (true) {
                    System.out.println("Chose language");
                    System.out.println("1. EN");
                    System.out.println("2. VI");
                    System.out.println("0. Exit");
                    System.out.print("Choose: ");
                    lg = Integer.parseInt(input.readLine());
                    if (lg == 1 || lg == 2 || lg == 0) {
                        break;
                    }
                }
                if (lg == 1) {
                    String language = "en";
                    String country = "US";
                    Locale currentLocal = new Locale(language, country);
                    getResource(currentLocal, "Ex9_1/resource_en_US");
                }
                if (lg == 2) {
                    String language = "vi";
                    String country = "VN";
                    Locale currentLocal = new Locale(language, country);
                    getResource(currentLocal, "Ex9_1/resource_vi_VN");
                }
                if (lg == 0) {
                    break;
                }
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

    public static void getResource(Locale currentLocal, String path) {
        ResourceBundle message = ResourceBundle.getBundle(path, currentLocal);
        List<String> list = new ArrayList<>();
        Enumeration<String> keys = message.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = message.getString(key);
            list.add(value);
        }
        showList(list);
    }

    public static void showList(List list) {
        for (Object st : list) {
            System.out.println((String) st);
        }
    }
}
