/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotmedicaldata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class UpdateFetcher {
    
     public ArrayList getDetails( String empid)
    {
       
        ArrayList ar= new ArrayList();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/searchoverenciot","root","root");
            Statement st=conn.createStatement();

            String query="Select * from userinfo where username='"+empid+"'";
            ResultSet rs=st.executeQuery(query);

            if(rs.next())
            {
  //name, gen, emailid, mobile, username, password
            ar.add(rs.getString(1));
            ar.add(rs.getString(2));
            ar.add(rs.getString(3));
            ar.add(rs.getString(4));
            ar.add(rs.getString(5));
            ar.add(rs.getString(6));
         
           
            
            }
            System.out.println("ar is  "+ar);
    
        }
           // int x=st.executeUpdate(query);
            
        catch(Exception e)
        {
            System.out.println("Exception at UpdateFetcher"+e);
            
        }
       
      return ar;
    }
 
    
}
