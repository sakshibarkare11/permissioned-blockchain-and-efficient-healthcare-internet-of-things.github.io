/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchoverenc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class LoginMaker {
    public boolean doLogin(String uname,String pass)
    {
       
boolean flag=false;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/searchoverenciot","root","root");
            Statement st=conn.createStatement();
//name, gen, emailid, mobile, username, password
            String query="Select *from userinfo  where username='"+uname+"' and password='"+pass+"'";
            ResultSet rs=st.executeQuery(query);
      
  
            if(rs.next())
            {
                flag=true;

            }
           
        }
        catch(Exception e)
        {
            System.out.println("Exception in loginclass"+e);
            flag=false;
        }

return flag;

    }
    
    
}
