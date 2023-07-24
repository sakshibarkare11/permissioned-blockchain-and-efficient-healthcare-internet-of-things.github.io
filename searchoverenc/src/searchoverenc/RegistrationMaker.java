/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchoverenc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class RegistrationMaker {
    
     public boolean doRegister(String name,String sex,String email,String mobile,String empid,String pass)
    {
        //name, dob, cadd, email, mobile, registerfor, uname, pass
        boolean flag=false ;
        try
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/searchoverenciot","root","root");
            Statement st=conn.createStatement();

            String query="Insert into userinfo values('"+name+"','"+sex+"','"+email+"','"+mobile+"','"+empid+"','"+pass+"')";
            int x=st.executeUpdate(query);
            if(x>0)
                flag=true;
            else
                flag=false;



        }
        catch(Exception ex)
        {
            System.out.println("exception in inserter "+ex);
            flag=false;
        }

        return flag;
    }
    
}
