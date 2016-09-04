/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

/**
 *
 * @author hv
 */
public class mainFactory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            ShapeFactory shapeFactory = new ShapeFactory();

            String type = "";
            while (true) {
                System.out.println("Input type: ");
                System.out.println("1. CIRCLE\n2. SQUARE\n3. RECTANGLE");
                int ans = Integer.parseInt(input.readLine());
                if (ans == 1) {
                    type = "CIRCLE";
                    break;
                }
                if (ans == 2) {
                    type = "SQUARE";
                    break;
                }
                if (ans == 3) {
                    type = "RECTANGLE";
                    break;
                }
            }

            Shape shape = shapeFactory.getShape(type);
            shape.draw();
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
