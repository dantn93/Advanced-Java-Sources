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
public class Company {

    private AodaiDepartment aodaiDepartment;
    private CheongsamDepartment cheongsamDepartment;
    private TraditionalDepartment traditionDepartment;

    public Company() {
        this.aodaiDepartment = new AodaiDepartment();
        this.cheongsamDepartment = new CheongsamDepartment();
        this.traditionDepartment = new TraditionalDepartment();
    }

    public Model sew(String type) {
        if (type.equalsIgnoreCase(EnumModel.AODAI.getName())) {
            return this.aodaiDepartment.sew();
        }
        if (type.equalsIgnoreCase(EnumModel.CheongsamClothes.getName())) {
            return this.cheongsamDepartment.sew();
        }
        if (type.equalsIgnoreCase(EnumModel.TraditionalColothes.getName())) {
            return this.traditionDepartment.sew();
        }
        return null;
    }
}
