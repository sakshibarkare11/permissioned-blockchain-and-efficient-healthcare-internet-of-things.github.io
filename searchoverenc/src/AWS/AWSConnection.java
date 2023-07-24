
package AWS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class AWSConnection {
    
    
    public Statement createawsConnection() 
    {
          Statement st=null;
          
         try
         {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://searchdb.cu6dsohks6ue.us-east-1.rds.amazonaws.com:3306/searchdb?characterEncoding=utf8","root","admin123");
            st=conn.createStatement();
    
         }
         catch (Exception e)
         {
             System.out.println("Exception in AWSConnection Class is: "+e);
         }
          
          
          return st;
    }
    
}
