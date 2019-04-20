package bus.station;

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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminController implements Initializable {
    
    FileManeger file = new FileManeger();
    ObservableList<String> list;
    ArrayList<Trip> trip = file.scanner();
    
    @FXML
    TextField driverText;
    @FXML
    TextField fromText;
    @FXML
    TextField toText;
    @FXML
    TextField vehicleText;
    @FXML
    TextField dateText;
    @FXML
    TextField timeText;
    @FXML
    TextField priceText;
    @FXML
    TextField stopsText;
    @FXML
    private ComboBox combobox;
    @FXML
    Label driverLabel;
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
    Label delete;
    
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
        private void save(ActionEvent event) throws IOException {
            boolean f = false;
            if(!driverText.getText().isEmpty() && !combobox.getSelectionModel().isEmpty())
            {
                int temp = combobox.getSelectionModel().getSelectedIndex();
                trip.get(temp).driver = driverText.getText();
                f = true;
            }
            if(!fromText.getText().isEmpty() && !combobox.getSelectionModel().isEmpty())
            {
                int temp = combobox.getSelectionModel().getSelectedIndex();
                trip.get(temp).from = fromText.getText();
                f = true;
            }
            if(!toText.getText().isEmpty() && !combobox.getSelectionModel().isEmpty())
            {
                int temp = combobox.getSelectionModel().getSelectedIndex();
                trip.get(temp).to = toText.getText();
                f = true;
            }
            if(!vehicleText.getText().isEmpty() && !combobox.getSelectionModel().isEmpty())
            {
                int temp = combobox.getSelectionModel().getSelectedIndex();
                trip.get(temp).vehicleType = vehicleText.getText();
                f = true;
            }
            if(!dateText.getText().isEmpty() && !combobox.getSelectionModel().isEmpty())
            {
                int temp = combobox.getSelectionModel().getSelectedIndex();
                trip.get(temp).date = dateText.getText();
                f = true;
            }
            if(!timeText.getText().isEmpty() && !combobox.getSelectionModel().isEmpty())
            {
                int temp = combobox.getSelectionModel().getSelectedIndex();
                trip.get(temp).time = timeText.getText();
                f = true;
            }
            if(!priceText.getText().isEmpty() && !combobox.getSelectionModel().isEmpty())
            {
                int temp = combobox.getSelectionModel().getSelectedIndex();
                trip.get(temp).vehiclePrice = Float.parseFloat(priceText.getText());
                f = true;
            }
            if(!stopsText.getText().isEmpty() && !combobox.getSelectionModel().isEmpty())
            {
                int temp = combobox.getSelectionModel().getSelectedIndex();
                trip.get(temp).stops = stopsText.getText();
                f = true;
            }
            if(f)
            {
                delete.setVisible(false);
                fail.setVisible(false);
                success.setVisible(true);
                file.writter();
            }
            else
            {
                delete.setVisible(false);
                success.setVisible(false);
                fail.setVisible(true);
            }
    }
        @FXML
        private void delete(ActionEvent event) throws IOException {
            if(!combobox.getSelectionModel().isEmpty())
            {
                int temp = combobox.getSelectionModel().getSelectedIndex();
                FileManeger.trips.remove(temp);
                delete.setVisible(true);
                fail.setVisible(false);
                file.writter();
            }
            else
            {
                delete.setVisible(false);
                fail.setVisible(true);
            }
        }
        @FXML
        private void pick(ActionEvent event) throws IOException {
            int temp = combobox.getSelectionModel().getSelectedIndex();
            driverLabel.setText(trip.get(temp).driver);
            fromLabel.setText(trip.get(temp).from);
            toLabel.setText(trip.get(temp).to);
            vehicleLabel.setText(trip.get(temp).vehicleType);
            dateLabel.setText(trip.get(temp).date);
            timeLabel.setText(trip.get(temp).time);
            priceLabel.setText(Float.toString(trip.get(temp).vehiclePrice));
            stopsLabel.setText(trip.get(temp).stops);
            fail.setVisible(false);
            success.setVisible(false);
            delete.setVisible(false);
        }
        
        @FXML
        private void add(ActionEvent event) throws IOException {
        Parent add = FXMLLoader.load(getClass().getResource("Add.fxml"));
        
        Scene addScene = new Scene(add);
        addScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(addScene);
        window.show();
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<String> ID = new ArrayList<>();
        int temp;
        String temp2;
        for(int j=0 ; j<trip.size() ; j++)
        {
           temp = trip.get(j).ID;
           temp2 = Integer.toString(temp);
           ID.add(temp2);
        }
        list = FXCollections.observableArrayList(ID);
        combobox.setItems(list);
    }    
    
}
