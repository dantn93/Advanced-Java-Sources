/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vd10_workbook;

import java.util.Date;

/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class Employee {

    private String name;
    private int sex;//1: male / 0: female
    private Date dateOfbirth;
    private String identityNumber;
    private double salary;
    private String address;
    private int departmentID;

    public Employee(String name, int sex, Date dateOfbirth, String identityNumber,
            double salary, String address, int departmentID) {
        this.name = name;
        this.sex = sex;
        this.dateOfbirth = dateOfbirth;
        this.identityNumber = identityNumber;
        this.salary = salary;
        this.address = address;
        this.departmentID = departmentID;
    }

    public void showInfo() {
        System.out.println("[Name]: " + this.name);
        System.out.println("[Sex]: " + this.sex);
        System.out.println("[Date of birth]:" + this.dateOfbirth);
        System.out.println("[Identify number]: " + this.identityNumber);
        System.out.println("[Salary]: " + this.salary);
        System.out.println("[Address]: " + this.address);
        System.out.println("[Department ID]: " + this.departmentID);
        System.out.println("");
    }

    public String getName() {
        return name;
    }

    public int getSex() {
        return sex;
    }

    public Date getDateOfbirth() {
        return dateOfbirth;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public double getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public int getDepartmentID() {
        return departmentID;
    }
    
}
