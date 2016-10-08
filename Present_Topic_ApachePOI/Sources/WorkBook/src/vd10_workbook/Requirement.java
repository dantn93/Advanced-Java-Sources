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
public class Requirement{

    private int worktypeID;
    private int foreignLanguageID;

    public Requirement(int worktypeID, int foreignLanguageID) {
        this.worktypeID = worktypeID;
        this.foreignLanguageID = foreignLanguageID;
    }

    public int getWorktypeID() {
        return worktypeID;
    }

    public int getForeignLanguageID() {
        return foreignLanguageID;
    }

    public void showInfo() {
        System.out.println("[Work type ID]: " + this.worktypeID);
        System.out.println("[Foreign language ID]: " + this.foreignLanguageID);
        System.out.println("");
    }

}
