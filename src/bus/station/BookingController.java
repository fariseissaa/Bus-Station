package bus.station;

import bus.logic.Customer;
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

public class BookingController implements Initializable {
    
    ObservableList<String> list ;
    FileManeger file = new FileManeger();
    ArrayList<Trip> cTrip = file.cScanner();
    ArrayList<Trip> trip = file.scanner();
    
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
    Label success;
    @FXML
    Label fail;
    @FXML
    ComboBox combobox;
    Trip t;
    
    
    @FXML
        private void pick(ActionEvent event) throws IOException {
            int temp = combobox.getSelectionModel().getSelectedIndex();
            fromLabel.setText(FileManeger.trips.get(temp).from);
            toLabel.setText(FileManeger.trips.get(temp).to);
            vehicleLabel.setText(FileManeger.trips.get(temp).vehicleType);
            dateLabel.setText(FileManeger.trips.get(temp).date);
            timeLabel.setText(FileManeger.trips.get(temp).time);
            priceLabel.setText(Float.toString(FileManeger.trips.get(temp).vehiclePrice));
            stopsLabel.setText(FileManeger.trips.get(temp).stops);
            fail.setVisible(false);
            success.setVisible(false);
        }
    @FXML
        private void book(ActionEvent event) throws IOException {
            if(!combobox.getSelectionModel().isEmpty())
            {
                int temp2 = Integer.parseInt((String) combobox.getSelectionModel().getSelectedItem());
                for(int i=0; i<trip.size() ; i++)
                {
                    if(trip.get(i).ID == temp2)
                    {
                        t = trip.get(i);
                        t.customer = Customer.flag;
                        FileManeger.cTrips.add(t);
                        file.cWritter();
                        success.setVisible(true);
                        fail.setVisible(false);
                    }
                }
            }
            else
            {
                success.setVisible(false);
                fail.setVisible(true);
            }
        }
        
    @FXML
        private void back(ActionEvent event) throws IOException {
        Parent customer = FXMLLoader.load(getClass().getResource("Customer.fxml"));

            Scene customerScene = new Scene(customer);
            customerScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(customerScene);
            window.show();
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> ID = new ArrayList<>();
        int temp;
        String temp2;
        for(int j=0 ; j<FileManeger.trips.size() ; j++)
        {
           temp = FileManeger.trips.get(j).ID;
           temp2 = Integer.toString(temp);
           ID.add(temp2);
        }
        list = FXCollections.observableArrayList(ID);
        combobox.setItems(list);
    }    
}    
