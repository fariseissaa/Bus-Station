package bus.station;

import bus.logic.Customer;
import bus.logic.Driver;
import bus.logic.Admin;
import bus.logic.FileManeger;
import bus.logic.Trip;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    Admin adminClass = new Admin();
    Driver driverClass = new Driver();
    Customer customerClass = new Customer();
    FileManeger file= new FileManeger();
    @FXML
    private TextField name;
    @FXML
    private PasswordField password;
    @FXML
    private Label error;
    @FXML
    private RadioButton admin;
    @FXML
    private RadioButton driver;
    @FXML
    private RadioButton customer;
    @FXML
    private ToggleGroup people;

    @FXML
    private void login(ActionEvent event) throws IOException {

        if (admin.isSelected() && adminClass.authentication(name.getText(), password.getText())) {
            
            Parent admin = FXMLLoader.load(getClass().getResource("Admin.fxml"));

            Scene adminScene = new Scene(admin);
            adminScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(adminScene);
            window.show();
        } else if (driver.isSelected() && driverClass.authentication(name.getText(), password.getText())) {
            driverClass.flag = name.getText();
            Parent driver = FXMLLoader.load(getClass().getResource("Driver.fxml"));

            Scene driverScene = new Scene(driver);
            driverScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(driverScene);
            window.show();
        } else if (customer.isSelected() && customerClass.authentication(name.getText(), password.getText())) {
            customerClass.flag = name.getText();
            Parent customer = FXMLLoader.load(getClass().getResource("Customer.fxml"));

            Scene customerScene = new Scene(customer);
            customerScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(customerScene);
            window.show();
        } else {
            error.setVisible(true);
        }
    }
    public String x;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public TextField getName() {
        return name;
    }

    public PasswordField getPassword() {
        return password;
    }

    public RadioButton getAdmin() {
        return admin;
    }

    public RadioButton getDriver() {
        return driver;
    }

    public RadioButton getCustomer() {
        return customer;
    }

}
