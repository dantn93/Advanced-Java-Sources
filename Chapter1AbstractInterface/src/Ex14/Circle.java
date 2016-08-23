/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex14;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class Circle extends Shape {
    private double r;

    public Circle(double r) {
        this.r = r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }

    public double perimeter() {
        return 2 * Math.PI * r;
    }

    public double area() {
        return Math.PI * Math.pow(r, 2);
    }

}
