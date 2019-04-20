package bus.logic;

import java.util.HashMap;

public class Admin implements Person {
    HashMap admins;
    public Admin()
        {
            admins = new HashMap();
            admins.put("Faris", "1234");
            admins.put("Mustafa", "Deif");
        }
    
    public boolean authentication(String name,String pass)
    { 
        String fetched = (String) admins.get(name);
        if(fetched != null)
        {
            return fetched.equals(pass);
        }
        return false;
    }
    
}
