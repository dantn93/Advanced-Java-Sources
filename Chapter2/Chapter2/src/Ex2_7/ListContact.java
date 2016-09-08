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
public enum ListContact {
    Person1("01675 217 654","Hoang"),
    Person2("01675 908 534","Ha"),
    Person3("0987678987","Hang"),
    Person4("0964578356","Thuy"),
    Person5("0964578356","Thuy");
    private String numberPhone;
    private String name;

    private ListContact(String numberPhone, String name) {
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
