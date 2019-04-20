package bus.station;

import bus.logic.FileManeger;
import bus.logic.Trip;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController implements Initializable {
    
    FileManeger file = new FileManeger();
    Trip t;
    ArrayList<Trip> trip = file.scanner();
    
    @FXML
    TextField IDText;
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
    Label error;
    
    @FXML
    private void back(ActionEvent event) throws IOException {
    
                Parent admin = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
                Scene adminScene = new Scene(admin);
                adminScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                window.setScene(adminScene);
                window.show();
            }
    
    @FXML
    private void save(ActionEvent event) throws IOException {
        
        
        if(!IDText.getText().isEmpty() && !driverText.getText().isEmpty() && !fromText.getText().isEmpty() && 
                !toText.getText().isEmpty() && !vehicleText.getText().isEmpty() && !dateText.getText().isEmpty() 
                && !timeText.getText().isEmpty() && !priceText.getText().isEmpty() && !stopsText.getText().isEmpty())
        {
            t = new Trip();
            t.ID = Integer.parseInt(IDText.getText());
            t.driver = driverText.getText();
            t.from = fromText.getText();
            t.to = toText.getText();
            t.vehicleType = vehicleText.getText();
            t.date = dateText.getText();
            t.time = timeText.getText();
            t.vehiclePrice = Float.parseFloat(IDText.getText());
            t.stops = stopsText.getText();
            trip.add(t);
            file.writter();
            Parent admin = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
                Scene adminScene = new Scene(admin);
                adminScene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                window.setScene(adminScene);
                window.show();  
        }
        else
        {
            error.setVisible(true);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
