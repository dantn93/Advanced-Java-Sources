package Ex2;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Tran Ngoc Dan
 * @since 19/09/2016
 * @version 1.0
 */
public class CDController {

    /**
     * used to connect database.
     */
    static DatabaseConnection db = new DatabaseConnection();
    /**
     * list includes CDs which loaded from database.
     */
    private final List<CD> list;

    /**
     * controler.
     */
    public CDController() throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
        list = new ArrayList<>();
        try (Connection conn = db.connect()) {
            try (Statement statement = (Statement) conn.createStatement()) {
                String sql = "SELECT * FROM cd";
                ResultSet resultSet = statement.executeQuery(sql);
                int i = 0;
                while (resultSet.next()) {
                    CD cd = new CD();
                    cd.setId(resultSet.getInt("id"));
                    cd.setName(resultSet.getString("name"));
                    cd.setSinger(resultSet.getString("singer"));
                    cd.setNumberOfSongs(resultSet.getInt("numbersongs"));
                    cd.setPrice(resultSet.getDouble("price"));
                    list.add(cd);
                }
                statement.close();
            }
            conn.close();
        }
    }

    /**
     * add a cd input: a cd.
     *
     * @param cd
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public void addCD(CD cd) throws SQLException, ClassNotFoundException {
        try (Connection conn = db.connect()) {
            //static variable to findbug can't warn.
            String name = cd.getName();
            String singer = cd.getSinger();
            int numbersongs = cd.getNumberOfSongs();
            double price = cd.getPrice();
            final String sql = "INSERT INTO cd VALUES(NULL, ? ,  ? ,  ? ,  ? )";

            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, singer);
                statement.setInt(3, numbersongs);
                statement.setDouble(4, price);
                statement.execute();
                list.add(cd);
                System.out.println("Add new cd successfully!");
                statement.close();
                conn.close();
            }

        } catch (SQLException ex) {
            System.out.println("Can not add new cd");
        }
    }

    /**
     * search a cd input: name of cd output: list of cds satisfying
     *
     * @param name
     * @return List of CD after search
     */
    public List<CD> searchCD(String name) {
        List<CD> ls = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                ls.add(list.get(i));
            }
        }
        if (ls.isEmpty()) {
            System.out.println("list of CDs don't have " + name + "!");
        } else {
            return ls;
        }
        return ls;
    }

    /**
     * show all of information in this list.
     */
    public void showInfo() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print((i + 1) + ". ");
            list.get(i).showInfo();
        }
    }

    /**
     * get size of list.
     *
     * @return number of CD in list.
     */
    public int getSize() {
        return list.size();
    }

    /**
     * get CD at index i in list of CD.
     *
     * @param i
     * @return a CD
     */
    public CD getCD(int i) {
        return list.get(i);
    }

    /**
     * update price and amount of cd at position idx.
     *
     * @param idx
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.io.IOException
     */
    public void updateCD(int idx) throws SQLException, ClassNotFoundException, IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        double price;
        while (true) {
            System.out.print("[price]: ");
            price = Double.parseDouble(input.readLine());
            if (price >= 0) {
                break;
            }
        }
        int numberOfsongs;
        while (true) {
            System.out.print("[number of songs]: ");
            numberOfsongs = Integer.parseInt(input.readLine());
            if (numberOfsongs >= 0) {
                break;
            }
        }
        list.get(idx).setNumberOfSongs(numberOfsongs);
        list.get(idx).setPrice(price);
        try (Connection conn = db.connect()) {
            int id = list.get(idx).getId();
            String sql = "UPDATE cd SET price = ? , numbersongs = ? WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setDouble(1, price);
                statement.setInt(2, numberOfsongs);
                statement.setInt(3, id);
                statement.executeUpdate();
                System.out.println("Update successfully!");
                statement.close();
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Can not update");
        }
    }

    /**
     * delete cd at position idx.
     *
     * @param idx
     */
    public void deleteCD(int idx) {
        try (Connection conn = db.connect()) {
            int id = list.get(idx).getId();
            String sql = "DELETE FROM cd WHERE id = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, id);
                statement.execute();
                System.out.println("Delete cd successfully!");
                list.remove(idx);

                statement.close();
            }
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Can not delete cd");
        }
    }

    /**
     * function read information of employee.
     *
     * @throws java.io.FileNotFoundException
     * @throws java.lang.ClassNotFoundException
     */
    public void readTXTfileData() throws FileNotFoundException,
            IOException, ClassNotFoundException {
        //clear elements in initial list
        //clear elements in initial list
        list.clear();
        ObjectInputStream in = null;
        try (FileInputStream file = new FileInputStream("src\\Ex2\\cd.txt")) {
            if (file.available() != 0) {
                try {
                    in = new ObjectInputStream(file);
                    while (true) {
                        list.add((CD) in.readObject());
                    }
                } catch (EOFException e) {
                } finally {
                    if (in != null) {
                        in.close();
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Err: " + e.getMessage());
        }
    }

    /**
     * function add new employee.
     */
    public void writeTXTfileData() throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream("src\\Ex2\\cd.txt"));
            out.reset();
            for (Object obj : list) {
                CD cd = (CD) obj;
                out.writeObject(cd);
            }
            System.out.println("completed !");
            out.flush();
            out.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * read list note from cd.xml.
     */
    private NodeList readListNode(String path, String name) throws org.xml.sax.SAXException {

        File fXmlFile = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        NodeList nList = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            //normalize tree
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName(name);
        } catch (ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
        return nList;
    }

    /**
     * Read file XML and add contact into list contact.
     *
     * @throws org.xml.sax.SAXException
     */
    public void readXMLfileData() throws org.xml.sax.SAXException {
        NodeList nList = readListNode("src\\Ex2\\cd.xml", "cd");
        //clear list before do everything
        list.clear();
        if (nList != null) {
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                Element element = (Element) node;
                int id = Integer.parseInt(element.getElementsByTagName("id").item(0).getChildNodes().item(0).getNodeValue());
                String name = element.getElementsByTagName("name").item(0).getChildNodes().item(0).getNodeValue();
                String singer = element.getElementsByTagName("singer").item(0).getChildNodes().item(0).getNodeValue();
                int numberOfsongs = Integer.parseInt(element.getElementsByTagName("numbersongs").item(0).getChildNodes().item(0).getNodeValue());
                double price = Double.parseDouble(element.getElementsByTagName("price").item(0).getChildNodes().item(0).getNodeValue());
                CD cd = new CD(id, name, singer, numberOfsongs, price);
                list.add(cd);
            }
        }
    }

    /**
     * write
     *
     * @throws javax.xml.transform.TransformerConfigurationException
     */
    public void writeXMLfileData() throws TransformerConfigurationException, TransformerException {

        Path path = Paths.get("src\\Ex2\\cd.xml");
        if (!Files.exists(path)) {
            File file = new File("src\\Ex2\\cd.xml");
        }

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();

            //create root elements
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("CDs");
            doc.appendChild(rootElement);

            for (int i = 0; i < list.size(); i++) {
                CD c = list.get(i);
                //cd element
                Element cd = doc.createElement("cd");
                rootElement.appendChild(cd);

                //id element
                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(Integer.toString(c.getId())));
                cd.appendChild(id);

                //name element
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(c.getName()));
                cd.appendChild(name);

                //singer element
                Element singer = doc.createElement("singer");
                singer.appendChild(doc.createTextNode(c.getSinger()));
                cd.appendChild(singer);

                //number of songs element
                Element numbersongs = doc.createElement("numbersongs");
                numbersongs.appendChild(doc.createTextNode(Integer.toString(c.getNumberOfSongs())));
                cd.appendChild(numbersongs);

                //price element
                Element price = doc.createElement("price");
                price.appendChild(doc.createTextNode(Double.toString(c.getPrice())));
                cd.appendChild(price);
            }
            //Write the content into file contact.xml
            TransformerFactory tranformer = TransformerFactory.newInstance();
            Transformer tf = tranformer.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src\\Ex2\\cd.xml"));
            tf.transform(source, result);
            System.out.println("Write successfully!");
        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
