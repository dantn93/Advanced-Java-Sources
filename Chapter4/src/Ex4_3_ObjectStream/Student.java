/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4_3_ObjectStream;
/**
 *
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 12/09/2016
 */
public class Student {

    private String name;
    private int age;
    private double mark1;
    private double mark2;

    public Student(String name, int age, double mark1, double mark2) {
        this.name = name;
        this.age = age;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getMark1() {
        return mark1;
    }

    public double getMark2() {
        return mark2;
    }

    public double avg() {
        return (this.mark1 + this.mark2) / 2;
    }

    public String showInfo() {
        return "Name: " + this.name + "\n\tAge: " + this.age + "\n\tmark1: " + this.mark1 + " & mark2: " + this.mark2
                + "\n\tavg: " + avg();
    }
}
