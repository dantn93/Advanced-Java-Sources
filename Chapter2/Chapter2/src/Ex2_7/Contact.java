/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_7;

/**
 *
 * @author snow
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
}
