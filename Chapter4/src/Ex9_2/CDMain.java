package Ex9_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 08/09/2016
 */
public class CDMain {

    /**
     * @param args the command line arguments
     */
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            //Choose language
            int idxLang = chooseLanguage();
            //Get resource
            ResourceBundle message = getResource(idxLang);
            //Load resource bundle message
            //================  ===================//
            ArrayList<CD> list = new ArrayList<CD>() {
            };
            while (true) {
                System.out.println("1. "+message.getString("addCD"));
                System.out.println("2. "+message.getString("list"));
                System.out.println("3. "+message.getString("sort"));
                System.out.println("4. "+message.getString("quit"));
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
                        System.out.println("== Fill out CD's information ==");
                        System.out.print(message.getString("id"));
                        String id = input.readLine();
                        System.out.print(message.getString("name"));
                        String name = input.readLine();
                        System.out.print(message.getString("singer"));
                        String singer = input.readLine();
                        int numberOfSongs = 0;
                        while (true) {
                            if (numberOfSongs <= 0) {
                                System.out.print(message.getString("number"));
                                numberOfSongs = Integer.parseInt(input.readLine());
                            } else {
                                break;
                            }
                        }
                        double price = 0;
                        while (true) {
                            if (price <= 0) {
                                System.out.print(message.getString("price"));
                                price = Double.parseDouble(input.readLine());
                            } else {
                                break;
                            }
                        }
                        list.add(new CD(id, name, singer, numberOfSongs, price));
                        break;
                    case 2:
                        System.out.println("== "+message.getString("list")+" ==");
                        double sumPrice = 0;
                        for (int i = 0; i < list.size(); i++) {
                            System.out.println("CD[" + i + "]");
                            list.get(i).showInfo();
                            sumPrice += list.get(i).getPrice();
                        }
                        System.out.println(message.getString("sumprice") + sumPrice);
                        break;
                    case 3:
                        Collections.sort(list);
                        break;
                }
                if (ans == 4) {
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }


    public static int chooseLanguage() throws IOException{
        int lg = 0;
        while (true) {
            System.out.println("Chose language");
            System.out.println("1. EN");
            System.out.println("2. VI");
            System.out.print("Choose: ");
            lg = Integer.parseInt(input.readLine());
            if (lg == 1 || lg == 2) {
                break;
            }
        }
        return lg;
    }
    public static ResourceBundle getResource(int lg) throws IOException {
        if (lg == 1) {
            String language = "en";
            String country = "US";
            Locale currentLocal = new Locale(language, country);
            return ResourceBundle.getBundle("Ex9_2/resource_en_US", currentLocal);
        }
        if (lg == 2) {
            String language = "vi";
            String country = "VN";
            Locale currentLocal = new Locale(language, country);
            return ResourceBundle.getBundle("Ex9_2/resource_vi_VN", currentLocal);
        }
        return null;
    }
}
