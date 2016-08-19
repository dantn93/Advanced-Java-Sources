/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author hv
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                System.out.println("==Linear Equation ax + b = 0 ==");
                System.out.print("a = ");
                double a = Double.parseDouble(input.readLine());

                System.out.print("b = ");
                double b = Double.parseDouble(input.readLine());
                LinearEquation eq = new LinearEquation(a, b);
                double[] result = eq.findSolution();
                eq.printSolution(result);
                
                //request continue
                System.out.print("Do you want to continue (y/n)? ");
                String ans;
                while(true){
                    ans = input.readLine();
                    if(ans.equalsIgnoreCase("y"))
                        break;
                    else
                        System.exit(0);
                }  
            }
        } catch (Exception ex) {
            System.out.println("Err: ");
        }
    }
}
