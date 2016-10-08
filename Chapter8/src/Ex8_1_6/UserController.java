package Ex8_1_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class UserController {

    static DatabaseConnection db = new DatabaseConnection();
    List<User> list;

    public UserController() {
        list = new ArrayList<>();
    }

    //search account in database
    public User loginUser(String username, String password)
            throws ClassNotFoundException, SQLException {
        User user = null;

        try (Connection conn = db.connect()) {
            Statement statement = (Statement) conn.createStatement();
            String sql = "SELECT * FROM user WHERE user like '" + username
                    + "' and password like '" + password + "'";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                user = new User();
                user.setUser(resultSet.getString("user"));
                user.setPassword(resultSet.getString("password"));
                break;
            }
            conn.close();
        }
        return user;
    }

    //check login
    public void checkLogin() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Username: ");
        String user = input.readLine();
        System.out.print("Password: ");
        String password = input.readLine();

        UserController userController = new UserController();
        User u = null;
        try {
            u = userController.loginUser(user, password);
            if (u == null) {
                System.out.println("Can not login!");
            } else {
                System.out.println("Login successed!");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    //add account
    public void addUser() throws IOException, SQLException, ClassNotFoundException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Username: ");
        String user = input.readLine();
        System.out.print("Password: ");
        String password = input.readLine();
        System.out.print("Confirm: ");
        String confirm = input.readLine();
        if (!password.equals(confirm)) {
            System.out.println("Password isn't the same as the Confirm Password");
        } else {
            try (Connection conn = db.connect()) {
                String sql = "INSERT INTO user VALUES(NULL,'" + user + "','" + password + "')";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.execute();
                System.out.println("Add user successfully!");
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("Can not add new user");
            }
        }
    }
}