package ViewsControllers;

import DB_operations.LoginCheck;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginScreenController implements Initializable {
    public TextField loginUsername;
    public PasswordField loginPassword;
    Stage stage;
    Parent root;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Initialized Successfully");
    }

    public void loginMethod(ActionEvent actionEvent) throws SQLException, IOException {
        String user = loginUsername.getText();
        String pass = loginPassword.getText();
        boolean passwordCheck;
        System.out.println("User: " + user + "\nPass: " + pass);
        passwordCheck = LoginCheck.PassCheck(user, pass);
        if (passwordCheck) {
            stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("HomeScreen.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        }
        else {
            System.out.println("login was unsuccessfull");
        }

        //DBConnect.setUsername(user);
        //DBConnect.setPassword(pass);
        //DBConnect.openConn();
    }

}

