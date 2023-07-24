/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotmedicaldata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class UpdateMaker {
    public  boolean updateData(String name,String sex,String email,String mobile,String uname,String pass)
    {
     boolean flag=false;
     
     //name, gen, emailid, mobile, username, password
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood_donations","root","root");
            Statement st=conn.createStatement();
           //name, Dob, address, emailid, mobile, subject, class, staffid, password
            String query=" update employee_info set name='"+name+"',gen='"+sex+"',emailid='"+email+"',mobile='"+mobile+"',password='"+pass+"'  where username='"+uname+"'";
           int x=st.executeUpdate(query);
           if(x>0)
               flag=true;
           else
               flag=false;
        }
        catch(Exception e)
        {
            System.out.println("Exception in Updater"+e);
        flag=false;
        }
       return flag;
    }
    
}
