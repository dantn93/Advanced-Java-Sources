/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 08/09/2016
 */
public class PetManager<T> {

    private List<T> pets;

    PetManager() {
        this.pets = new ArrayList<>();
    }

    public List<T> getPets() {
        if (this.pets == null) {
            this.pets = new ArrayList<>();
        }
        return this.pets;
    }

}
