/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iotmedicaldata;

import java.util.Random;


public class RandomNumGenerator
{
    public String getRandomNumber(int Low,int High)
    {
        
        Random r = new Random();

int Result = r.nextInt(High-Low) + Low;
String res=Integer.toString(Result);

        return (res);
        
        
    }
}
