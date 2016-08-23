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
public abstract class Shape {

    public abstract double perimeter();

    public abstract double area();

    public void showInfo() {
        System.out.println("Perimeter: " + this.perimeter());
        System.out.println("Area: " + this.area());
    }
}
