package Ex15;

/**
 * @author: Tran Ngoc Dan
 * @version: 1.0
 * @day: 23/08/2016
 */
public abstract class Instrument {

    protected String name;
    protected String publisher;

    public Instrument(String name, String publisher) {
        this.name = name;
        this.publisher = publisher;
    }

    //how to play instrument
    public abstract void play();

    //show all information of instrument
    public abstract void showInfo();
}
