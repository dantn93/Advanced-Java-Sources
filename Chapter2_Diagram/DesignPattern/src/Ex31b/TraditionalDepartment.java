/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex31b;

import Ex31a.*;

/**
 *
 * @author snow
 */
public class TraditionalDepartment {

    private TraditionalClothes tradition;

    public TraditionalDepartment() {
        this.tradition = new TraditionalClothes();
    }

    public Model sew() {
        return this.tradition;
    }
}
