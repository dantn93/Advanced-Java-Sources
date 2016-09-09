/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_5;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 08/09/2016
 */
public class Employee {

    private String name;
    private int age;
    private double salary;

    public Employee(String name, int age, double salary) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void showInfo() {
        System.out.println("[Name]: " + this.name);
        System.out.println("[Age]: " + this.age);
        System.out.println("[Salary]: " + this.salary);
    }

}
