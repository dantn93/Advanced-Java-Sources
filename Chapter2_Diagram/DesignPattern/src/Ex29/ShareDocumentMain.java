/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex29;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShareDocumentMain {

    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Muon tao giao vien khong (y/n): ");
            String ans = input.readLine();
            if (ans.equalsIgnoreCase("Y")) {
                SingleTeacher teacher = SingleTeacher.getInstance();
                System.out.println(teacher.shareDocument());
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
