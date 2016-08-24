package Ex17;

import Ex16.VehicleCollection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class ZooMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Zoo zoo = new Zoo();
        try {
            System.out.println("== ZOO ==");
            while (true) {
                while (true) {
                    System.out.println("Fill out information of an animal");
                    System.out.print("Name: ");
                    String name = input.readLine();
                    System.out.print("Food: ");
                    String food = input.readLine();

                    int ans = 0;
                    while (true) {
                        System.out.println("The animal is a/an...");
                        System.out.println("1. Bird");
                        System.out.println("2. Fish");
                        System.out.println("3. Tiger");
                        System.out.println("4. Boa");
                        System.out.print("Choose: ");
                        ans = Integer.parseInt(input.readLine());
                        if (ans == 1 || ans == 2 || ans == 3 || ans == 4) {
                            break;
                        }
                    }
                    if(ans == 1){
                        zoo.addBird(new Bird(name, food));
                        System.out.println("I have just add a bird into Zoo!");
                        break;
                    }
                    if(ans == 2){
                        zoo.addFish(new Fish(name, food));
                        System.out.println("I have just add a fish into Zoo!");
                        break;
                    }
                    if(ans == 3){
                        zoo.addTiger(new Tiger(name, food));
                        System.out.println("I have just add a tiger into Zoo!");
                        break;
                    }
                    if(ans == 4){
                        zoo.addBoa(new Boa(name, food));
                        System.out.println("I have just add a boa into Zoo!");
                        break;
                    }
                }

                //Ask continue
                boolean flag = false;
                while (true) {
                    System.out.print("\n\nDo you want another operation (y/n): ");
                    String agr = input.readLine();
                    if (agr.equalsIgnoreCase("y")) {
                        break;
                    } else if (agr.equalsIgnoreCase("n")) {
                        flag = true;
                        break;
                    }
                }
                if (flag == true) {
                    break;
                }

            }
            //Show information
            zoo.showInfo();
        } catch (Exception ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

}
