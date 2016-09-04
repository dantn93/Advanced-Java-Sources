package Ex17;

import java.util.ArrayList;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class Zoo {

    private ArrayList<Bird> bird;
    private ArrayList<Boa> boa;
    private ArrayList<Fish> fish;
    private ArrayList<Tiger> tiger;

    public Zoo() {
        bird = new ArrayList<Bird>();
        boa = new ArrayList<Boa>();
        fish = new ArrayList<Fish>();
        tiger = new ArrayList<Tiger>();
    }

    public void addBird(Bird brd) {
        this.bird.add(brd);
    }

    public void addBoa(Boa boa) {
        this.boa.add(boa);
    }

    public void addFish(Fish fsh) {
        this.fish.add(fsh);
    }

    public void addTiger(Tiger tgr) {
        this.tiger.add(tgr);
    }
    
    public void showInfo(){
        System.out.println("== SHOW INFORMATION ==");
        if(this.bird.size() > 0){
            System.out.println("\n-- BIRD --");
            for(int i=0;i<this.bird.size();i++){
                System.out.println("-- Bird["+(i+1)+"] --");
                this.bird.get(i).showInfo();
                System.out.println("");
            }
        }
        
        if(this.tiger.size() > 0){
            System.out.println("\n-- TIGER --");
            for(int i=0;i<this.tiger.size();i++){
                System.out.println("-- Tiger["+(i+1)+"] --");
                this.tiger.get(i).showInfo();
                System.out.println("");
            }
        }
        
        System.out.println("\n-- FISH --");
        if(this.fish.size() > 0){
            for(int i=0;i<this.fish.size();i++){
                System.out.println("-- Fish["+(i+1)+"] --");
                this.fish.get(i).showInfo();
                System.out.println("");
            }
        }
        
        System.out.println("\n-- BOA --");
        if(this.boa.size() > 0){
            for(int i=0;i<this.boa.size();i++){
                System.out.println("-- Boa["+(i+1)+"] --");
                this.boa.get(i).showInfo();
                System.out.println("");
            }
        }
    }

}
