/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigex;

import java.util.ArrayList;

/**
 *
 * @author snow
 */
public class Teacher {

    private PersonalInformation info;
    private String potentiality;

    public Teacher(String name, String numberPhone, String email, String potentiality) {
        info = new PersonalInformation(name, numberPhone, email);
        this.potentiality = potentiality;
    }
}
