/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchoverenc;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author welcome
 */
public class Searchoverenc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         LoginFrame mf=new LoginFrame();
       Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
       mf.setVisible(true);
       mf.setSize(d);
    }
    
}
