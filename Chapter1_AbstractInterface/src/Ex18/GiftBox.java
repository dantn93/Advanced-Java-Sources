/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex18;

/**
 *
 * @author snow
 */
public class GiftBox {

    private String shape;
    private String color;
    final int price = 10000;

    public GiftBox(String shape, String color) {
        this.shape = shape;
        this.color = color;
    }

    class Gift {

        public String name;
        public double weight;
        final int FEE = 200;

        public Gift(String name, double weight) {
            this.name = name;
            this.weight = weight;
        }

        public double calFee() {
            return this.weight * this.FEE + GiftBox.this.price;
        }
    }
}
