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
public class UserGroup {

    private String id;
    private String name;

    public UserGroup(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void showInfo() {
        System.out.println("[ID]: " + this.id);
        System.out.println("[Name]: " + this.name);
        System.out.println("");
    }

}
