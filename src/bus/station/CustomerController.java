package bus.station;

import bus.logic.Customer;
import bus.logic.Driver;
import bus.logic.FileManeger;
import bus.logic.Trip;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class CustomerController implements Initializable {

    ObservableList<String> list ;
    Customer customer = new Customer();
    FileManeger file = new FileManeger();
    ArrayList<Trip> cTrip = file.cScanner();
    
    @FXML
    Label fromLabel;
    @FXML
    Label toLabel;
    @FXML
    Label vehicleLabel;
    @FXML
    Label dateLabel;
    @FXML
    Label timeLabel;
    @FXML
    Label priceLabel;
    @FXML
    Label stopsLabel;
    @FXML
    Label remove;
    @FXML
    Label fail;
    @FXML
    ComboBox combobox;
    
    @FXML
        private void signout(ActionEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene loginScene = new Scene(login);
        loginScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(loginScene);
        window.show();
    }
    
    @FXML    
        private void pick(ActionEvent event) throws IOException {
            int temp2 = Integer.parseInt((String) combobox.getSelectionModel().getSelectedItem());
            for(int i=0; i<cTrip.size() ; i++)
            {
                if(cTrip.get(i).ID == temp2)
                {
                    fromLabel.setText(cTrip.get(i).from);
                    toLabel.setText(cTrip.get(i).to);
                    vehicleLabel.setText(cTrip.get(i).vehicleType);
                    dateLabel.setText(cTrip.get(i).date);
                    timeLabel.setText(cTrip.get(i).time);
                    priceLabel.setText(Float.toString(cTrip.get(i).vehiclePrice));
                    stopsLabel.setText(cTrip.get(i).stops);
                }
            }
        }
        
    @FXML
        private void delete(ActionEvent event) throws IOException {
            if(!combobox.getSelectionModel().isEmpty())
            {
                int temp2 = Integer.parseInt((String) combobox.getSelectionModel().getSelectedItem());
                for(int i=0; i<cTrip.size() ; i++)
                {
                    if(cTrip.get(i).ID == temp2)
                    {
                        cTrip.remove(i);
                        remove.setVisible(true);
                        fail.setVisible(false);
                        file.cWritter();
                    }
                }
            }
            else
            {
                remove.setVisible(false);
                fail.setVisible(true);
            }
            
        }
    
    @FXML
        private void book(ActionEvent event) throws IOException {
            Parent book = FXMLLoader.load(getClass().getResource("Booking.fxml"));
        
            Scene bookScene = new Scene(book);
            bookScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
            window.setScene(bookScene);
            window.show();
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> ID = new ArrayList<>();
        int temp;
        String temp2;
        for(int j=0 ; j<cTrip.size() ; j++)
        {
            if(cTrip.get(j).customer.equals(Customer.flag))
            {
                temp = cTrip.get(j).ID;
                temp2 = Integer.toString(temp);
                ID.add(temp2);
            }
        }
        list = FXCollections.observableArrayList(ID);
        combobox.setItems(list);
    }    
    
}
