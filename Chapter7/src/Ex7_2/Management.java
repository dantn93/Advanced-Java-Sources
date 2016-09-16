/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex7_2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Tran Ngoc Dan
 * @version 1.0
 * @since 16/09/2016
 */
public class Management {

    private List<Department> departments;
    private List<Employee> employee;

    public Management() {
        this.departments = new ArrayList<>();
        this.employee = new ArrayList<>();
    }

    //add new department
    public void addDepartment(Department depart) {
        departments.add(depart);
    }

    //load data from employee file
    public void loadEmployee() throws SAXException {
        //read listNode
        File fXmlFile = new File("src\\Ex7_2\\nhan_vien.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        NodeList nList = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            //normalize tree
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("nhan_vien");
        } catch (ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }

        //get element
        if (nList != null) {
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                Element element = (Element) node;
                String id = element.getElementsByTagName("id").item(0).getChildNodes().item(0).getNodeValue();
                String name = element.getElementsByTagName("ho_ten").item(0).getChildNodes().item(0).getNodeValue();

                String sex = element.getElementsByTagName("gioi_tinh").item(0).getChildNodes().item(0).getNodeValue();
                String dOb = element.getElementsByTagName("ngay_sinh").item(0).getChildNodes().item(0).getNodeValue();
                double salary = Double.parseDouble(element.getElementsByTagName("muc_luong").item(0).getChildNodes().item(0).getNodeValue());
                String address = element.getElementsByTagName("dia_chi").item(0).getChildNodes().item(0).getNodeValue();
                String department = element.getElementsByTagName("id_don_vi").item(0).getChildNodes().item(0).getNodeValue();
                Employee emp = new Employee(id, name, sex, dOb, salary, address, department);
                employee.add(emp);
            }
        }
    }

    /**
     * load data from load department file
     */
    public void loadDepartment() throws SAXException {
        //read listNode
        File fXmlFile = new File("src\\Ex7_2\\don_vi.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        NodeList nList = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //normalize tree
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("don_vi");

        } catch (ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
        //get element
        if (nList != null) {
            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                Element element = (Element) node;
                String id = element.getElementsByTagName("id").item(0).getChildNodes().item(0).getNodeValue();
                String name = element.getElementsByTagName("ten").item(0).getChildNodes().item(0).getNodeValue();

                Department depart = new Department(id, name);
                departments.add(depart);
            }
        }
    }

    /**
     * show all employee in an department which assigned input: id of department
     */
    public void showAllEmployeeInADepartment(int d) {
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).getDepartment().equals(departments.get(d).getId())) {
                employee.get(i).showInfo();
            }
        }
    }

    //show list department
    public void showAllDeparment() {
        for (int i = 0; i < departments.size(); i++) {
            System.out.println(i + 1);
            departments.get(i).showInfo();
        }
    }

    public int getSizeDepartment() {
        return departments.size();
    }

    public void addNewEmployee(String id, String name, String sex, String dOb, double salary, String address, int idx) {
        Employee emp = new Employee(id, name, sex, dOb, salary, address, departments.get(idx).getId());
        int count = 0;
        for (int i = 0; i < employee.size(); i++) {
            if (employee.get(i).compareTo(emp)) {
                count++;
            }
        }
        if (count == 0) {
            employee.add(emp);
            System.out.println("Add successfully!");
        } else {
            System.out.println("The id is existed in database");
        }

    }

    //update don_vi.xml & nhan_vien.xml file.
    public void updateFileData() {
        //== rewrite file nhan_vien.xml ==//
        Path path = Paths.get("src\\Ex7_2\\nhan_vien.xml");
        if (!Files.exists(path)) {
            File file = new File("src\\Ex7_2\\nhan_vien.xml");
        }

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();

            //create root elements
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("don_vi");
            doc.appendChild(rootElement);

            for (int i = 0; i < employee.size(); i++) {
                Employee e = employee.get(i);
                //employee element
                Element contact = doc.createElement("nhan_vien");
                rootElement.appendChild(contact);

                //id element
                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(e.getId()));
                contact.appendChild(id);

                //name element
                Element name = doc.createElement("ho_ten");
                name.appendChild(doc.createTextNode(e.getName()));
                contact.appendChild(name);

                //sex element
                Element sex = doc.createElement("gioi_tinh");
                sex.appendChild(doc.createTextNode(e.getSex()));
                contact.appendChild(sex);

                //day of birth element
                Element dOb = doc.createElement("ngay_sinh");
                dOb.appendChild(doc.createTextNode(e.getdOb()));
                contact.appendChild(dOb);

                //salary element
                Element salary = doc.createElement("muc_luong");
                salary.appendChild(doc.createTextNode(Double.toString(e.getSalary())));
                contact.appendChild(salary);

                //address element
                Element address = doc.createElement("dia_chi");
                address.appendChild(doc.createTextNode(e.getAddress()));
                contact.appendChild(address);

                //address element
                Element idDepart = doc.createElement("id_don_vi");
                idDepart.appendChild(doc.createTextNode(e.getDepartment()));
                contact.appendChild(idDepart);
            }
            //Write the content into file contact.xml
            TransformerFactory tranformer = TransformerFactory.newInstance();
            Transformer tf = tranformer.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src\\Ex7_2\\nhan_vien.xml"));
            tf.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getMessage());
        }

        //== rewrite file don_vi.xml ==//
        path = Paths.get("src\\Ex7_2\\don_vi.xml");
        if (!Files.exists(path)) {
            File file = new File("src\\Ex7_2\\don_vi.xml");
        }

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbf.newDocumentBuilder();

            //create root elements
            Document doc = builder.newDocument();
            Element rootElement = doc.createElement("cong_ty");
            doc.appendChild(rootElement);

            for (int i = 0; i < departments.size(); i++) {
                Department d = departments.get(i);
                //employee element
                Element contact = doc.createElement("don_vi");
                rootElement.appendChild(contact);

                //id element
                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(d.getId()));
                contact.appendChild(id);

                //name element
                Element name = doc.createElement("ten");
                name.appendChild(doc.createTextNode(d.getName()));
                contact.appendChild(name);

            }
            //Write the content into file contact.xml
            TransformerFactory tranformer = TransformerFactory.newInstance();
            Transformer tf = tranformer.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src\\Ex7_2\\don_vi.xml"));
            tf.transform(source, result);

        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println(e.getMessage());
        }
    }
}
