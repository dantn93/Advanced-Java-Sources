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
public class Department {

    private String id;
    private String name;

    public Department(String id, String name) {
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
        System.out.println("\t[id] " + this.id);
        System.out.println("\t[name] " + this.name);
        System.out.println("");
    }

}
