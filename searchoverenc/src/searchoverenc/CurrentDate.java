/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchoverenc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author welcome
 */
public class CurrentDate {
    public String getDate()
 {
 Calendar cal = Calendar.getInstance();
 DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
 String p=dateFormat.format(cal.getTime());
 // System.out.println("Today's date is "+p);
  return p;
}
}
