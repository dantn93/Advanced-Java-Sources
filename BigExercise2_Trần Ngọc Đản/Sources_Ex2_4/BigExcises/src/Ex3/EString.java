/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex3;

/**
 * @author Tran Ngoc Dan
 * @since 19/09/2016
 * @version 1.0
 */
public enum EString {
    // Strings used to be examples
    string1("Nguyen Van An"),
    string2("Vo Viet Hoai"),
    string3("Le Hoai An"),
    string4("Do Thanh Trung"),
    string5("Phan Ngoc Anh"),
    string6("Ninh Ngoc Linh Duong");
    
    private String name;

    /**
     * constructor
     * @param name 
     */
    private EString(String name) {
        this.name = name;
    }
    /**
     * get each strings.
     * @return this.name
     */
    public String getString(){
        return this.name;
    }
}
