/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex8_1_6;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tran Ngoc Dan
 * @since 17/09/2016
 * @version 1.0
 */
public class CategoryController {

    static DatabaseConnection db = new DatabaseConnection();
    List<Category> list;

    public CategoryController() {
        list = new ArrayList<>();
    }

    public int getSize() {
        return list.size();
    }

    //load all of Category into list<Category>
    public void getAllCategory() throws SQLException, ClassNotFoundException {
        User user = null;

        try (Connection conn = db.connect()) {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT * FROM category";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int id = Integer.parseInt(resultSet.getString("id"));
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                list.add(new Category(id, name, description));
            }
            conn.close();
        }
    }

    public void showInfo() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + "");
            System.out.println("\t[id] " + list.get(i).getId());
            System.out.println("\t[name] " + list.get(i).getName());
            System.out.println("\t[description] " + list.get(i).getDescription());
            System.out.println("");
        }
    }
}
