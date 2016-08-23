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
public class Square extends Shape {

    private double edge;

    public Square(double edge) {
        this.edge = edge;
    }

    @Override
    public double perimeter() {
        return 4 * this.edge;
    }

    @Override
    public double area() {
        return this.edge * this.edge;
    }

}
