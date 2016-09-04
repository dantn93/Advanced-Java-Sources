package Ex9;

import java.util.ArrayList;

/**
 * @author Tran Ngoc Dan
 * @Date: 22/08/2016
 * @Version: 1.0
 */
public class Collection {

    private ArrayList<Desktop> dkt;
    private ArrayList<Laptop> lt;

    public Collection() {
        dkt = new ArrayList<Desktop>();
        lt = new ArrayList<Laptop>();
    }

    public void addDesktop(Desktop cpt) {
        dkt.add(cpt);
    }

    public void addLaptop(Laptop cpt) {
        lt.add(cpt);
    }
    
    public void showLaptopCharge() {
        double sum = 0;
        for (int i = 0; i < lt.size(); i++) {
            sum += lt.get(i).charge();
        }
        System.out.println("Laptop Price: " + sum);
    }

    public void showDesktopCharg() {
        double sum = 0;
        for (int i = 0; i < dkt.size(); i++) {
            sum += dkt.get(i).charge();
        }
        System.out.println("Desktop Price: " + sum);
    }
    
    public void showInfoAllLap(){
        for (int i = 0; i < lt.size(); i++) {
            System.out.println("-- Laptop["+i+1+"] --");
            lt.get(i).showLapInfo();
        }
    }
    
    public void showInfoAllDesk(){
        for (int i = 0; i < dkt.size(); i++) {
            System.out.println("-- Desktop["+i+1+"] --");
            dkt.get(i).showDeskInfo();
        }
    }

}
