/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rcc_enc;



/**
 *
 * @author welcome
 */
public class Rcc_enc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cont="TODO code application logic here";
        String eekey12="1234567";
           
           System.out.println("Original Content \n "+cont );
            String econtent=new ReverseEncryptionHelper().startEncryption(cont, eekey12);
            
            System.out.println("Enncrypted Content \n "+econtent);
        
        
    }
    
}
