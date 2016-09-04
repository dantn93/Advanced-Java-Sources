package Ex15;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public class NoStringedInstrument extends Instrument {

    private String howToPlay;

    public NoStringedInstrument(String howToPlay, String name, String publisher) {
        super(name, publisher);
        this.howToPlay = howToPlay;
    }

    //How to play instrument
    @Override
    public void play() {
        System.out.println("How to play: " + this.howToPlay);
    }

    //Show information
    @Override
    public void showInfo() {
        System.out.println("== SHOW INFORMATION == ");
        System.out.println("- Name: " + this.name);
        System.out.println("- Publisher: " + this.publisher);
        System.out.println("- How to play: " + this.howToPlay);
    }
}
