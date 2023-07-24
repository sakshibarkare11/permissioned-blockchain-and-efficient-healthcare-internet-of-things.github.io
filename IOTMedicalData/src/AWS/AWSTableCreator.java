
package AWS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AWSTableCreator {
    
//    public boolean createTable(Statement st)
//    {
//        boolean flag=true;
//        
//         try
//        {
//           
//            int x=0;
//            int count=0;
//            
//                       
//               String query="CREATE TABLE usersinfo"+
//                   "(Name VARCHAR(45), "
//                    + " DOB VARCHAR(45), "
//                    + " Address VARCHAR(45), "
//                    + " Email VARCHAR(45),"
//                    + " Mobile VARCHAR(45),"
//                    + " Userid VARCHAR(45),"
//                    + " Password VARCHAR(45),"
//                    + " PRIMARY KEY ( Userid ))";
//               
//               x=st.executeUpdate(query);
//                
//            if(x>0)
//                flag=true;
//            else
//                flag=false;
//            
//          
//                
//            }            
//             
//        
//        catch(Exception e)
//        {
//            System.out.println("Exception in AWSTableCreator Class is: "+e);
//            flag=false;
//        }
//        
//        
//        return flag;
//    }
//    
     public boolean createTableSensorvalue(Statement st)
    {
        boolean flag=false;
        
         try
        {
           
                    String query="CREATE TABLE sensorinfo"+
                   "(sensorvalone VARCHAR(45), "
                    + " sensorvaltwo VARCHAR(45), "
                    + " datte VARCHAR(45),"
                    + "time VARCHAR(45))";
                  
               
            int x=st.executeUpdate(query);
                System.out.println("X is: "+x);
            if(x>0)
                flag=true;
            else
                flag=false;
            
          st.close();
                
            }            
             
        catch(Exception e)
        {
            System.out.println("Exception in AWSTableCreator Class is: "+e);
            flag=false;
        }
        
        return flag;
    }
    
}
