/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigex;

import java.util.Date;

/**
 *
 * @author snow
 */
public class Student {

    PersonalInformation info;
    private String dOb;//Date of birth

    public Student(String name, String numberPhone, String email, String dOb) {
        this.info = new PersonalInformation(name, numberPhone, email);
        this.dOb = dOb;
    }

    public String getName() {
        return info.getName();
    }

    public String getNumberPhone() {
        return info.getNumberPhone();
    }

    public String getEmail() {
        return info.getEmail();
    }

    public String getdOb() {
        return dOb;
    }
    

}
