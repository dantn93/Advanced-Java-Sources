/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex6_3;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import static java.lang.Math.round;
import java.text.DecimalFormat;

/**
 *
 * @author snow
 */
public class Student {

    private String name;
    private int grade;
    private double semester1;
    private double semester2;

    public Student(String name, int grade, double semester1, double semester2) {
        this.name = name;
        this.grade = grade;
        this.semester1 = semester1;
        this.semester2 = semester2;
    }

    //write student's info into file
    public void writeIntoFile(String file) {
        try (DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file, true)))) {
            out.writeUTF(this.name);
            out.writeInt(this.grade);
            out.writeDouble(this.semester1);
            out.writeDouble(this.semester2);
            out.close();
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

    public int getGrade() {
        return grade;
    }
    
    

    //calculate the average mark
    public double getAverage() {
        DecimalFormat df = new DecimalFormat("###.##");
        double avg = (this.semester1 + this.semester2 * 2) / 3;
        return Double.parseDouble(df.format(avg));
    }

    //show student's information
    public void showInfo() {
        System.out.println("[Name] " + this.name);
        System.out.println("[Grade] " + this.grade);
        System.out.println("[Mark in semester 1] " + this.semester1);
        System.out.println("[Mark in semester 2] " + this.semester2);
        System.out.println("");
    }
}
