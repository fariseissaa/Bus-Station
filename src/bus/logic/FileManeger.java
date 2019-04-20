package bus.logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManeger {

    public static ArrayList<Trip> trips;
    public static ArrayList<Trip> cTrips;
    
    public ArrayList<Trip> scanner()
    {
        File filename = new File("D:\\trips.txt");
        Scanner scan = null;
        trips = new ArrayList<>();
        int i=0;
        
        try {
            scan = new Scanner(filename);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManeger.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(filename.exists())
        {
            Trip t;
            while(scan.hasNext())
            {
                t = new Trip();
                String line = scan.nextLine();
                String[] separated = line.split(";");
                
                t.setID(Integer.parseInt(separated[0]));
                t.setFrom(separated[1]);
                t.setTo(separated[2]);
                t.setDate(separated[3]);
                t.setTime(separated[4]);
                t.setStops(separated[5]);
                t.setVehicleType(separated[6]);
                t.setVehiclePrice(Float.parseFloat(separated[7]));
                t.setVehicleSize(Integer.parseInt(separated[8]));
                t.setDriver(separated[9]);
                trips.add(t);
                i++;
            }
        }
        return trips;
    }
public void writter()
    {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("D:/trips.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(int i=0; i<trips.size(); i++)
            {
                printWriter.print(trips.get(i).ID + ";");
                printWriter.print(trips.get(i).from + ";");
                printWriter.print(trips.get(i).to + ";");
                printWriter.print(trips.get(i).date + ";");
                printWriter.print(trips.get(i).time + ";");
                printWriter.print(trips.get(i).stops + ";");
                printWriter.print(trips.get(i).vehicleType + ";");
                printWriter.print(trips.get(i).vehiclePrice + ";");
                printWriter.print(trips.get(i).vehicleSize + ";");
                printWriter.println(trips.get(i).driver);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(FileManeger.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManeger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

public ArrayList<Trip> cScanner()
    {
        File filename = new File("D:\\cTrips.txt");
        Scanner scan = null;
        cTrips = new ArrayList<>();
        int i=0;
        
        try {
            scan = new Scanner(filename);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManeger.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(filename.exists())
        {
            Trip t;
            while(scan.hasNext())
            {
                t = new Trip();
                String line = scan.nextLine();
                String[] separated = line.split(";");
                
                t.setID(Integer.parseInt(separated[0]));
                t.setFrom(separated[1]);
                t.setTo(separated[2]);
                t.setDate(separated[3]);
                t.setTime(separated[4]);
                t.setStops(separated[5]);
                t.setVehicleType(separated[6]);
                t.setVehiclePrice(Float.parseFloat(separated[7]));
                t.setVehicleSize(Integer.parseInt(separated[8]));
                t.setDriver(separated[9]);
                t.setCustomer(separated[10]);
                cTrips.add(t);
                i++;
            }
        }
        return cTrips;
    }

public void cWritter()
    {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("D:/cTrips.txt", false);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for(int i=0; i<cTrips.size(); i++)
            {
                printWriter.print(cTrips.get(i).ID + ";");
                printWriter.print(cTrips.get(i).from + ";");
                printWriter.print(cTrips.get(i).to + ";");
                printWriter.print(cTrips.get(i).date + ";");
                printWriter.print(cTrips.get(i).time + ";");
                printWriter.print(cTrips.get(i).stops + ";");
                printWriter.print(cTrips.get(i).vehicleType + ";");
                printWriter.print(cTrips.get(i).vehiclePrice + ";");
                printWriter.print(cTrips.get(i).vehicleSize + ";");
                printWriter.print(cTrips.get(i).driver + ";");
                printWriter.println(cTrips.get(i).customer);
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(FileManeger.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManeger.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}