package bus.station;

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

public class DriverController implements Initializable {

    Driver driver = new Driver();
    FileManeger file = new FileManeger();
    ObservableList<String> list;
    ArrayList<Trip> trip = file.scanner();
    
    @FXML
    Label name;
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
    Label stopsLabel;
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
            for(int i=0; i<trip.size() ; i++)
            {
                if(trip.get(i).ID == temp2)
                {
                    fromLabel.setText(trip.get(i).from);
                    toLabel.setText(trip.get(i).to);
                    vehicleLabel.setText(trip.get(i).vehicleType);
                    dateLabel.setText(trip.get(i).date);
                    timeLabel.setText(trip.get(i).time);
                    stopsLabel.setText(trip.get(i).stops);
                }
            }
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        name.setText(Driver.flag);
        
        ArrayList<String> ID = new ArrayList<>();
        int temp;
        String temp2;
        for(int j=0 ; j<trip.size() ; j++)
        {
            if(trip.get(j).driver.equals(Driver.flag))
            {
                temp = trip.get(j).ID;
                temp2 = Integer.toString(temp);
                ID.add(temp2);
            }
        }
        list = FXCollections.observableArrayList(ID);
        combobox.setItems(list);
    }    
}

