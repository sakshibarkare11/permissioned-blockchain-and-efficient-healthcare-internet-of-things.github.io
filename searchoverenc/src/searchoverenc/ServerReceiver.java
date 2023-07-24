/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package searchoverenc;

import AWS.AWSConnection;
import AWS.AWSSensorDBInserter;
import AWS.AWSTableCreator;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import rcc_enc.ReverseEncryptionHelper;
import util.CloudStreamer;
import util.SensorDatakeeper;


/**
 *
 * @author Mohit
 */
public class ServerReceiver extends Thread{
    public void run()
    {
     String main="";
        
       
        System.out.println("Recevier Starter");
        try
        {
            ServerSocket s= new ServerSocket(1215);
            while(true)
            {
                Socket ss= s.accept();
                InputStream is = ss.getInputStream();
                DataInputStream dis= new DataInputStream(is);
                String ms=dis.readUTF();
              //  System.out.println(ms);
                   
               if(ms.contains("sensorvalue"))
               {
                   String sp[]=ms.split("#");
                   String sensorval1=sp[1];
                   String sensorval2=sp[2];
                   String date=new CurrentDate().getDate();
                   String time=new CurrentTime().getTime();
                   
                   
                           
                           
                   String str=sensorval1+"#"+sensorval2+"#"+date+"#"+time;
                  
                   SensorDatakeeper.q.add(str);
                  System.out.println("Added in Queue ====== "+str);
             
                   
               }

     }
            }
        
        catch(Exception e)
        {

        }
       
    }
}
