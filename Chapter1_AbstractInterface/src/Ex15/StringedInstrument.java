package Ex15;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class StringedInstrument extends Instrument {

    private int numOfString;

    public StringedInstrument(int numOfString, String name, String publisher) {
        super(name, publisher);
        this.numOfString = numOfString;
    }

    //How to play instrument
    @Override
    public void play() {
        if(this.numOfString > 1)
        System.out.println("Play " + this.name + " " + this.numOfString+" strings");
        if(this.numOfString == 1)
        System.out.println("Play " + this.name + " " + this.numOfString+" string");
    }

    //Show information
    @Override
    public void showInfo() {
        System.out.println("== SHOW INFORMATION == ");
        System.out.println("- Name: " + this.name);
        System.out.println("- Publisher: " + this.publisher);
        System.out.print("- How to play: ");
        play();
    }

}
