/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boot;

import java.lang.Thread;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import res.Tile;


public class Map {
    private static int sx;
    private static int sy;
    private static int[][] map;
  
    static Tile grass = new Tile("grass");
    static Tile water = new Tile("water");
    static Tile flowers = new Tile("flowers");
    public Map(int x, int y)
    {  
        Random r = new Random();
        
        map = new int[x][y];
        
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<y;j++)
            {   
                int b = r.nextInt(100);
                System.out.print(b);
                if(b<90)
                    map[i][j]=0;
                if(b>=90 && b<93)
                    map[i][j]=1;
                if(b>=93 &&b<100)
                    map[i][j]=2;
            }
        }
        sx = x;
        sy=y;
        //map[4][0]=2;
    }
    public void cleanup()
    {
        water.getTex().release();
        grass.getTex().release();
    }
    public void setTile(int x, int y, int tileID)
    {
        map[x][y]=tileID;
    }
    public int getTile(int x, int y)
    {
        return map[x][y];
    }
    public void draw()
    {
        for(int i=sx-1;i>=0;i--)//X values
        {
            for(int j=0;j<sy;j++)//Y Values
            {
                if(map[j][i]==0)
                    grass.getTex().bind();
                if(map[j][i]==1)
                    water.getTex().bind();
                if(map[j][i]==2)
                    flowers.getTex().bind();
                int x = 16*i + 16*j;
                int y = (8*j) - (8*i) + (sx/2)*15;
                
                GL11.glBegin(GL11.GL_QUADS);
                    GL11.glTexCoord2f(0,0);
                    GL11.glVertex2f(x,y);
                    GL11.glTexCoord2f(1,0);
                    GL11.glVertex2f(x+grass.getTex().getTextureWidth(),y);
                    GL11.glTexCoord2f(1,1);
                    GL11.glVertex2f(x+grass.getTex().getTextureWidth(),y+grass.getTex().getTextureHeight());
                    GL11.glTexCoord2f(0,1);
                    GL11.glVertex2f(x,y+grass.getTex().getTextureHeight());
                GL11.glEnd();
                
                    
                
            }
        }
        
    }
}
