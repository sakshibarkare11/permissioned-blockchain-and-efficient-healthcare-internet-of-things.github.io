
package AWS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class AWSSensorDBInserter {
    
     public boolean insertUserinfo(Statement st, String sensorval1, String sensorval2, String date,String time)
    {
        boolean flag=true;
        System.out.println("inside sensorinfo");
        try
        {
            
           String query="Insert into sensorinfo values('"+sensorval1+"','"+sensorval2+"','"+date+"','"+time+"')";
                      
            
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;
            
            
        }
        
        catch(Exception e)
        {
            System.out.println("Exception in AWSUserDBInserter Class is: "+e);
            flag=false;
        }
         System.out.println("inside sensorinfo last "+flag);
        
        return flag;
    }
    
    
}
