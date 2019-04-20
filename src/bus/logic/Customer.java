package bus.logic;

import java.util.HashMap;

public class Customer implements Person {
   HashMap customers;
    public Customer()
        {
            customers = new HashMap();
            customers.put("Ashraf", "2222");
            customers.put("Abdo", "3333");
            customers.put("Shehab", "4444");
        }
    public static String flag;
    public boolean authentication(String name,String pass)
    { 
        String fetched = (String) customers.get(name);
        if(fetched != null)
        {
            return fetched.equals(pass);
        }
        return false;
    }
    
    
}
