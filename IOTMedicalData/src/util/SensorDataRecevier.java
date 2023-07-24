/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import iotmedicaldata.CurrentDate;
import iotmedicaldata.CurrentTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import jssc.SerialPort;
import jssc.SerialPortException;




public class SensorDataRecevier extends Thread {
       public void run()
    {
         String str1;
         
        //In the constructor pass the name of the port with which we work
        SerialPort serialPort1 = new SerialPort("COM4");
      
        try {
            //Open port
            serialPort1.openPort();
         

            //We expose the settings. You can also use this line - serialPort.setParams(9600, 8, 1, 0);
            serialPort1.setParams(SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
         

            Thread.sleep(1000);//Very important !!!


        String bodytemp="";String pulse="";
            //Read data from port
       for (int i = 0; i >-1; i++) 
            {
                   str1 = serialPort1.readString();
          
             //  System.out.println("sensor Value "+str1);
        
                if (str1 != null) {
                //   System.out.println(str1);
                 
                 if(str1.contains(":"))
                 {
                    //  System.out.println(str1);
                     String st[] = str1.split(":");
                    // pulse = new RandomNumGenerator().getRandomNumber(0, 100);
                     pulse=st[0];
                    pulse = pulse.trim();
                    // bodytemp = new RandomNumGenerator().getRandomNumber(0, 100);
                    bodytemp=st[1];
                   bodytemp = bodytemp.trim();
                     
                     if(!pulse.isEmpty()&&!bodytemp.isEmpty())
                     {
                    String date = new CurrentDate().getDate();
                    String time=new CurrentTime().getTime();
                         // String str = pulse + "#" + bodytemp ;
                          //System.out.println("str "+str);
                     String str = pulse + "#" + bodytemp + "#" + date+"#"+time;
                     System.out.println("str "+str);
                     SensorDatakeeper.q.add(str);
                     }


                     try
                     {
                          Thread.sleep(500);
                     }
                     catch(Exception ex)
                     {
                         
                     }
               
            }
            
          

        }

        
                     try
                     {
                          Thread.sleep(500);
                     }
                     catch(Exception ex)
                     {
                         
                     }
    }
    
}          catch (InterruptedException ex) {
               Logger.getLogger(SensorDataRecevier.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SerialPortException ex) {
               Logger.getLogger(SensorDataRecevier.class.getName()).log(Level.SEVERE, null, ex);
           } 
        
    }
}

