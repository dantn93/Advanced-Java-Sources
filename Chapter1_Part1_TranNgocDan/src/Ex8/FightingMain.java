/**
 * This code manages fights
 */
package Ex8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 */
public class FightingMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("==FIGHTING==");
            System.out.println("INFANTRYMAN");
            System.out.print("Name: ");
            String infName = input.readLine();
            System.out.print("Power: ");
            int infPower = Integer.parseInt(input.readLine());
            System.out.print("Weapon: ");
            String infWeapon = input.readLine();

            System.out.println("TROOPER");
            System.out.print("Name: ");
            String troName = input.readLine();
            System.out.print("Power: ");
            int troPower = Integer.parseInt(input.readLine());
            System.out.print("Weapon: ");
            String troWeapon = input.readLine();

            //Create 2 competitor
            Infantryman inf = new Infantryman(infName, infPower, infWeapon);
            Trooper tro = new Trooper(troName, troPower, troWeapon);

            //Fighting
            while (true) {
                System.out.print("Do you want Infantryman (1) to fight or Trooper (2): ");
                int ans = Integer.parseInt(input.readLine());
                if (ans == 1) {//Infantryman fight
                    tro.subPower(inf.fight());
                } else if (ans == 2) {//Trooper fight
                    inf.subPower(tro.fight());
                }else
                    System.out.println("Nobody fights. Continue...");
                //show point of them
                System.out.println("[Power] Infantryman: " + inf.getPower());
                System.out.println("[Power] Trooper: " + tro.getPower());

                //Check power
                if (inf.getPower() <= 0) {
                    System.out.println("Infantryman is loser");
                    break;
                }
                if (tro.getPower() <= 0) {
                    System.out.println("Trooper is loser");
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
