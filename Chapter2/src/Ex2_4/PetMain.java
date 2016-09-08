/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex2_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author snow
 */
public class PetMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            PetManager<Dog> managerDog = new PetManager<Dog>();
            PetManager<Cat> managerCat = new PetManager<Cat>();
            System.out.print("[Dog]: ");
            String Dogs = input.readLine();
            System.out.print("[Cat]: ");
            String Cats = input.readLine();
            String DogNames[] = Dogs.split(",");
            String CatNames[] = Cats.split(",");
            //add dogs
            for (String DogName : DogNames) {
                managerDog.getPets().add(new Dog(DogName));
            }
            //add cats
            for (String CatName : CatNames) {
                managerCat.getPets().add(new Cat(CatName));
            }
            // show list of dogs
            System.out.println("== SHOW DOGS ==");
            if (managerDog != null && !managerDog.getPets().isEmpty()) {
                for (int i = 0; i < managerDog.getPets().size(); i++) {
                    System.out.println(managerDog.getPets().get(i).getName());
                }
            }
            // show list of cats
            System.out.println("\n== SHOW CATS ==");
            if (managerCat != null && !managerCat.getPets().isEmpty()) {
                for (int i = 0; i < managerCat.getPets().size(); i++) {
                    System.out.println(managerCat.getPets().get(i).getName());
                }
            }
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
