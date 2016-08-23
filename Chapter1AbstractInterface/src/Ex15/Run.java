/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex15;

import Ex14.Circle;
import Ex14.Rectangle;
import Ex14.Square;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("== HOW TO USE A INSTRUMENT ==");
            while (true) {
                while (true) {
                    System.out.println("Name of Instrument: ");
                    String name = input.readLine();
                    System.out.println("Publisher: ");
                    String publisher = input.readLine();
                    System.out.println("The instrument is: ");
                    System.out.println("1. Stringed instrument");
                    System.out.println("2. No stringed instrument");
                    System.out.print("Choose: ");
                    int ans = Integer.parseInt(input.readLine());
                    if (ans == 1) {//1. Stringed instrument
                        int num = 0;
                        while (true) {
                            System.out.print("Number of String: ");
                            num = Integer.parseInt(input.readLine());
                            if (num > 0) {
                                break;
                            }
                        }
                        StringedInstrument instr = new StringedInstrument(num, name, publisher);
                        instr.showInfo();
                        break;
                    }
                    if (ans == 2) {//2. No stringed instrument
                        String howToPlay = "";
                        System.out.print("How to play: ");
                        howToPlay = input.readLine();
                        NoStringedInstrument instr = new NoStringedInstrument(howToPlay, name, publisher);
                        instr.showInfo();
                        break;
                    }
                }

                //Ask continue
                boolean flag = false;
                while (true) {
                    System.out.print("\n\nDo you want another operation (y/n): ");
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

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
