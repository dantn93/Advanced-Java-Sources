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
public enum EStaff {
    Employee1("Nguyen Van An", 20, 2000000),
    Employee2("Vo Viet Hoai", 30, 500000),
    Employee3("Le Hoai Anh", 19, 200000),
    Employee4("Do Thanh Trung", 21, 6000000),
    Employee5("Phan Ngoc Anh", 53, 1000000),
    Employee6("Ninh Ngoc Linh Duong", 45, 8000000),
    Employee7("Nguyen Ngoc anh", 35, 200000);
    private String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    private EStaff(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}
