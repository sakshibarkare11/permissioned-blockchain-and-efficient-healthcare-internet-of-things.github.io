package AWS;

import java.sql.*;
import java.util.ArrayList;


public class AWSSensorDataExtractor {

       
       public ArrayList getUserData(Statement st)
    {

       ArrayList data=new ArrayList();

        try
        {

            String query="Select *from sensorinfo";

            ResultSet rs1=st.executeQuery(query);
            
             while(rs1.next())
            {

                ArrayList user=new ArrayList();
             String senval1=rs1.getString(1);
             String senval2=rs1.getString(2);
             String date=rs1.getString(3);
           String time=rs1.getString(4);
            


              user.add(senval1);
              user.add(senval2);
              user.add(date);
            user.add(time);
           
              data.add(user);

            }

               
        }

        catch(Exception e)
        {
            System.out.println("Exception in AWSUserDataExtractor Class is: "+e);

        }

       return data;
    }

      
}


     
      