package Ex7;
/**
 * @author Tran Ngoc Dan
 * @version: 1.0
 * @day: 22/08/2016
 */
public class CD {

    private String id;
    private String name;
    private String singer;
    private int numOfSongs;
    private double price;

    public CD() {
        this.id = "";
        this.name = "";
        this.singer = "";
        this.numOfSongs = 0;
        this.price = 0;
    }

    public CD(String id, String name, String singer, int numOfSongs, double price) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.numOfSongs = numOfSongs;
        this.price = price;
    }

    @Override
    public String toString() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Singer: " + singer);
        System.out.println("The number of Songs is in CD: " + numOfSongs);
        System.out.println("Price: " + price);
        return "";
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public void setNumOfSongs(int numOfSongs) {
        this.numOfSongs = numOfSongs;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSinger() {
        return singer;
    }

    public int getNumOfSongs() {
        return numOfSongs;
    }

    public double getPrice() {
        return price;
    }
}
