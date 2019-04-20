package bus.logic;

import bus.station.DriverController;
import java.util.ArrayList;
import java.util.HashMap;

public class Driver implements Person {
    HashMap drivers;
    DriverController control;
    public Driver()
        {
            drivers = new HashMap();
            drivers.put("Ahmed", "0000");
            drivers.put("Mohamed", "1111");
        }
    public static String flag;

    public boolean authentication(String name,String pass)
    { 
        String fetched = (String) drivers.get(name);
        if(fetched != null)
        {
            return fetched.equals(pass);
        }
        return false;
    }
    
}
