/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vd10_workbook;

/**
 *
 * @author Tran Ngoc Dan
 * @since 30/09/2016
 */
public class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.println("[Name]: " + this.name);
        System.out.println("");
    }

    public String getName() {
        return name;
    }
    
}
