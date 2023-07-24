/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import AWS.AWSConnection;
import AWS.AWSSensorDBInserter;
import java.sql.Statement;
import javax.swing.JOptionPane;
import rcc_enc.ReverseEncryptionHelper;

/**
 *
 * @author welcome
 */
public class CloudStreamer extends Thread 
{
public void run()
{
    
    
    System.out.println("CloudStreamer Thread ");
    while (true)
    {
        
        System.out.print(".");
        if(!SensorDatakeeper.q.isEmpty())
        {
            String str=(String) SensorDatakeeper.q.remove();
          //   System.out.print("SensorDatakeeper.q "+str);
                    String sp[]=str.split("#");
                    String sensorval1=sp[0];
                    String sensorval2=sp[1];
                    String date=sp[2];
                    String time=sp[3];
                    //System.out.println(sensorval1+"---"+sensorval2+"--"+date+"--"+time);
            
                 String key=Datakeeper.key;
                   
                   
                   
                //   System.out.println(sensorval1+"  "+sensorval2);
                   String encsenval1=new ReverseEncryptionHelper().startEncryption(sensorval1, key);
                   String encsenval2=new ReverseEncryptionHelper().startEncryption(sensorval2, key);
                   String encdate=new ReverseEncryptionHelper().startEncryption(date, key);
                   String enctime=new ReverseEncryptionHelper().startEncryption(time, key);
                   
                  
                   
                  // System.out.println("   Sensor val 1 "+encsenval1+" Sensor val 2 "+" date "+encdate+" time "+time);
                   Statement st=new AWSConnection().createawsConnection();
                   AWSSensorDBInserter sf=new AWSSensorDBInserter();
                   if(sf.insertUserinfo(st, encsenval1, encsenval2, encdate, enctime))
                   {
                       System.out.println("Sensor Data Stored on cloud is "+str);
                      // JOptionPane.showMessageDialog(null, "Sensor Data Stored on cloud");
                   }
                   else
                   {
                      //  JOptionPane.showMessageDialog(null, "Eroor");
                       
                   }
        }
    }
}

    
   
    
}
