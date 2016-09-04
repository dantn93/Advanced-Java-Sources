/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex31a;

/**
 *
 * @author snow
 */
public class ModelFactory {

    public Model chooseClothes(String type) {
        if (type.equals("")) {
            return null;
        }
        if (type.equalsIgnoreCase(EnumModel.AODAI.getName())) {
            return new Aodai();
        }
        if (type.equalsIgnoreCase(EnumModel.CheongsamClothes.getName())) {
            return new CheongsamClothes();
        }
        if (type.equalsIgnoreCase(EnumModel.TraditionalColothes.getName())) {
            return new TraditionalClothes();
        }
        return null;
    }

}
