/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex7_1;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 16/09/2016
 */
public class Contact {
    private String numberPhone;
    private String name;
    
    public Contact(String numberPhone, String name) {
        this.numberPhone = numberPhone;
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getName() {
        return name;
    }
    
    public void showInfo(){
        System.out.println("[Name]: "+this.name);
        System.out.println("[Number phone]: "+this.numberPhone);
        System.out.println("");
    }
}
