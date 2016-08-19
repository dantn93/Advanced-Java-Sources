/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

/**
 *
 * @author Tran Ngoc Dan
 */
public class LinearEquation {

    private double a;
    private double b;

    public LinearEquation(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setB(double b) {
        this.b = b;
    }

    //return array (double type)
    //result[0] = 1: have solution;
    //result[1] = 1: have infinitive solution;
    //result[2] = ?: the solution;
    public double[] findSolution() {
        double[] result = new double[3];
        //infinity
        if (this.a == 0 && this.b == 0) {
            result[0] = 1;
            result[1] = 1;
            result[2] = 0;
        }
        //no solution
        if (this.a == 0 && this.b != 0) {
            result[0] = 0;
            result[1] = 0;
            result[2] = 0;
        }
        //one solution
        if (this.a != 0) {
            result[0] = 1;
            result[1] = 0;
            result[2] = -(this.b / this.a);
        }
        return result;
    }
    
    //Print solution
    public void printSolution(double... solution) {
        if (solution[0] == 0) {
            System.out.println("The equation doesn't have any solutions");
        } else if (solution[0] == 1 && solution[1] == 1) {
            System.out.println("The equation has infinite solutions");
        } else if (solution[0] == 1 && solution[1] == 0) {
            System.out.println("The equation has one solution: " + solution[2]);
        }
    }
}
