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
public class Ability {

    private int employeeID;
    private int languageID;

    public Ability(int employeeID, int languageID) {
        this.employeeID = employeeID;
        this.languageID = languageID;
    }

    public void showInfo() {
        System.out.println("[Employee ID]: " + this.employeeID);
        System.out.println("[Language ID]: " + this.languageID);
        System.out.println("");
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public int getLanguageID() {
        return languageID;
    }
    
}
