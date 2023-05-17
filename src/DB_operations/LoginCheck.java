package DB_operations;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginCheck {

    public static void LoginCheck() throws SQLException {
        Statement statement = DBConnect.connection.createStatement();
        String query = "SELECT User_Name, Password FROM users";
        ResultSet result = statement.executeQuery(query);
        while (result.next()) {
            System.out.println("Username: " + result.getString("User_Name") +
                    "\nPassword: " + result.getString("Password"));
            System.out.println("did it work?");
        }
    }

    public static boolean PassCheck(String user, String pass) throws SQLException, IOException {
        Statement statement = DBConnect.connection.createStatement();
        String queryUserName = "SELECT User_Name, Password FROM users";
        ResultSet result = statement.executeQuery(queryUserName);
        System.out.println("user arg: " + user);
        System.out.println("pass arg: " + pass);
        while (result.next()) {
            System.out.println("result user: " + result.getString("User_Name") +
                    "\nresult pass: " + result.getString("Password"));
            if (result.getString("User_Name").equals(user) &
                    result.getString("Password").equals(pass)) {
                System.out.println("match");
                return true;
            }
            else {
                System.out.println("No match ");
            }
        }
        return false;
    }
}



