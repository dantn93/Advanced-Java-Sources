/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigex;

/**
 *
 * @author snow
 */
public class PersonalInformation {
    private String name;
    private String numberPhone;
    private String email;

    public PersonalInformation(String name, String numberPhone, String email) {
        this.name = name;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getEmail() {
        return email;
    }
    
}
