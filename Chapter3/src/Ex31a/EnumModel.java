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
public enum EnumModel {
    TraditionalColothes("Traditional Clothes"), AODAI("Ao dai"), CheongsamClothes("Cheongsam Clothes");
    private String name;

    private EnumModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
