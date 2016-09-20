/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex4;

/**
 * @author Tran Ngoc Dan
 * @since 19/09/2016
 * @version 1.0
 */
public class Employee {

    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * show information of one employee.
     */
    public void showInfo() {
        System.out.println("[name]: " + this.name);
        System.out.println("[age]: " + this.age);
        System.out.println("[salary]: " + String.format("%.0f", this.salary));
        System.out.println("");
    }

}
