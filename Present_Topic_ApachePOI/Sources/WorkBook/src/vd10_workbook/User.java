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
public class User {

    private String name;
    private String password;
    private String expansion; //I dont know what it is!!! ^_^ It's just a number
    private int groupID;

    public User(String name, String password, String expansion, int groupID) {
        this.name = name;
        this.password = password;
        this.expansion = expansion;
        this.groupID = groupID;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getExpansion() {
        return expansion;
    }

    public int getGroupID() {
        return groupID;
    }

    public void showInfo() {
        System.out.println("[Name]: " + this.name);
        System.out.println("[Password]: " + this.password);
        System.out.println("[Expansion]: " + this.expansion);
        System.out.println("[Group ID] " + this.groupID);
        System.out.println("");
    }

}
