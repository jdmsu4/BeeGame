/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Boot.Map;
import java.text.DecimalFormat;
import java.util.Random;

public class Bee extends Sprite
{
    DecimalFormat df = new DecimalFormat("###.##");
    Random r = new Random();
    
    float targetx = 5f;
    float targety = 5f;
    public Bee(int x, int y, String tex)
    {
        super(x,y,tex);
    }
    public void update(Map m)//move until the colonist reaches his target position
    {   
        float d = .05f;
        if(x != targetx)
        {            
            if(x<targetx)
                x = Float.parseFloat(df.format(x + d));//use format the string and then reconvert back to float.               
            if(x>targetx)
                x = Float.parseFloat(df.format(x - d));  
            System.out.println(x);
          
        }
        if(x==targetx && y!=targety)
        {
            if(y<targety)
                y = Float.parseFloat(df.format(y + d));//use format the string and then reconvert back to float.
            if(y>targety)
                y = Float.parseFloat(df.format(y - d));
        }
        if(x==targetx && y==targety)
        {
            //m.setTile((int)x,(int)y,0);
            
            targetx = r.nextInt(19);
            targety= r.nextInt(19);
            System.out.println(x + " " + y);
        }
    }
}
