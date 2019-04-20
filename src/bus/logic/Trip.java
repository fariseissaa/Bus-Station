/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.logic;

public class Trip {
    public int ID;
    public String driver;
    public String from;
    public String to;
    public String date;
    public String time;
    public String stops;
    public String vehicleType;
    public float vehiclePrice;
    public int vehicleSize;
    public String customer;

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setVehiclePrice(float vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public void setVehicleSize(int vehicleSize) {
        this.vehicleSize = vehicleSize;
    }
}


