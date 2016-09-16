/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex7_2;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 16/09/2016
 */
public class Employee {

    private String id;
    private String name;
    private String sex;
    private String dOb;
    private double salary;
    private String address;
    private String department;

    public Employee(String id, String name, String sex, String dOb, double salary, String address, String department) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.dOb = dOb;
        this.salary = salary;
        this.address = address;
        this.department = department;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setdOb(String dOb) {
        this.dOb = dOb;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getdOb() {
        return dOb;
    }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public String getDepartment() {
        return department;
    }

    public void showInfo() {
        System.out.println("[id]: " + this.id);
        System.out.println("[name]: " + this.name);
        if (this.sex.equalsIgnoreCase("1")) {
            System.out.println("[sex]: nam");
        } else if (this.sex.equalsIgnoreCase("0")) {
            System.out.println("[sex]: nu");
        } else {
            System.out.println("[sex]: Undefined");
        }
        System.out.println("[date of birth]: " + this.dOb);
        System.out.println("[salary]: " + this.salary);
        System.out.println("[address]: " + this.address);
        System.out.println("[department]: " + this.department);
        System.out.println("");
    }

    public boolean compareTo(Employee emp) {
        if (this.id.equalsIgnoreCase(emp.getId())) {
            return true;
        } else {
            return false;
        }
    }
}
