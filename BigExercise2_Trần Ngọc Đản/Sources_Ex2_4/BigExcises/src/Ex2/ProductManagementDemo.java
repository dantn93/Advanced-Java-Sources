package Ex2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 * @author Tran Ngoc Dan
 * @since 19/09/2016
 * @version 1.0
 */
public class ProductManagementDemo {

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            CDController cdControler = new CDController();
            while (true) {
                int ans = 0;
                while (true) {
                    System.out.println("1. Add CD");
                    System.out.println("2. Search CD");
                    System.out.println("3. Update CD");
                    System.out.println("4. Delete CD");
                    System.out.println("5. Write data into txt data file");
                    System.out.println("6. Read data from txt data file");
                    System.out.println("7. Write data into xml file");
                    System.out.println("8. Read data from xml file");
                    System.out.println("9. Quit");
                    System.out.print("Choose: ");
                    ans = Integer.parseInt(input.readLine());
                    if (ans >= 1 && ans <= 9) {
                        break;
                    }
                }

                if (ans == 1) {//add cd
                    addCD(cdControler);
                }
                if (ans == 2) {//search cd
                    searchCD(cdControler);
                }
                if (ans == 3) {//update cd
                    updateCD(cdControler);
                }
                if (ans == 4) {//delete cd
                    deleteCD(cdControler);
                }
                if (ans == 5) {//write data into cd.txt
                    writeTXTfileData(cdControler);
                }
                if (ans == 6) {//read data from file cd.txt
                    readTXTfileData(cdControler);
                }
                if (ans == 7) {//write data into cd.xml
                    writeXMLfileData(cdControler);
                }
                if (ans == 8) {//read data from cd.xml
                    readXMLfileData(cdControler);
                }
                if (ans == 9) {//quit
                    break;
                }
            }
        } catch (SQLException | ClassNotFoundException | IOException | NumberFormatException | SAXException | TransformerException ex) {
            System.out.println("Err: " + ex.getMessage());
        }
    }

    /**
     * Search a CD Input: cd controler
     *
     * @param cdControler
     * @throws java.io.IOException
     */
    public static void searchCD(CDController cdControler) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("== Search CD ==");
        System.out.print("[CD's name]: ");
        String name = input.readLine();
        List<CD> lst = cdControler.searchCD(name);
        if (lst.size() > 0) {
            lst.forEach(e -> e.showInfo());
        } else {
            System.out.println("Don't have CD " + name);
        }
    }

    /**
     * add cd.
     *
     * @param cdControler
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public static void addCD(CDController cdControler) throws SQLException, ClassNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        System.out.println("== Add CD ==");
        System.out.println("Fill cd's information");
        //the title of cd
        System.out.print("[name]: ");
        String name = input.readLine();
        //name of singer
        System.out.print("[singer]: ");
        String singer = input.readLine();
        //number of songs in cd
        int numberOfsongs;
        while (true) {
            System.out.print("[number of songs]: ");
            numberOfsongs = Integer.parseInt(input.readLine());
            if (numberOfsongs > 0) {
                break;
            }
        }
        //put price
        double price;
        while (true) {
            System.out.print("[price]: ");
            price = Double.parseDouble(input.readLine());
            if (price > 0) {
                break;
            }
        }
        CD cd = new CD(0, name, singer, numberOfsongs, price);
        cdControler.addCD(cd);
    }

    /**
     * update cd.
     *
     * @param cdControler
     * @throws java.io.IOException
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public static void updateCD(CDController cdControler) throws IOException, SQLException, ClassNotFoundException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        cdControler.showInfo();
        int ans = 0;
        while (true) {
            System.out.print("Choose: ");
            ans = Integer.parseInt(input.readLine());
            if ((ans >= 1 && ans <= cdControler.getSize())) {
                break;
            }
        }
        cdControler.updateCD(ans - 1);
    }

    /**
     * delete cd.
     *
     * @param cdControler
     * @throws java.io.IOException
     */
    public static void deleteCD(CDController cdControler) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        cdControler.showInfo();
        int ans = 0;
        while (true) {
            System.out.print("Choose: ");
            ans = Integer.parseInt(input.readLine());
            if ((ans >= 1 && ans <= cdControler.getSize())) {
                break;
            }
        }
        String ans1 = "";
        System.out.print("Do you wanna delete this cd [y/n]: ");

        while ((ans1 = input.readLine()) != null) {
            if (ans1.equalsIgnoreCase("y")) {
                cdControler.deleteCD(ans - 1);
                break;
            } else {
                break;
            }
        }
    }

    /**
     * read data file.
     *
     * @param cdControler
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void readTXTfileData(CDController cdControler) throws IOException, FileNotFoundException, ClassNotFoundException {
        cdControler.readTXTfileData();
        cdControler.showInfo();
    }

    /**
     * write data file.
     *
     * @param cdControler
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public static void writeTXTfileData(CDController cdControler) throws IOException, FileNotFoundException, ClassNotFoundException {
        cdControler.writeTXTfileData();
    }

    //Read file XML and add contact into list contact
    public static void readXMLfileData(CDController cdControler) throws org.xml.sax.SAXException {
        cdControler.readXMLfileData();
        cdControler.showInfo();
    }

    //Write file XML and add contact into list contact
    public static void writeXMLfileData(CDController cdControler) throws org.xml.sax.SAXException, TransformerException {
        cdControler.writeXMLfileData();
    }
}
