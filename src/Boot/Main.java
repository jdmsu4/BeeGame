package Boot;



import Entity.Bee;
import Entity.Structure;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
import res.Tile;
/**
 *
 * @author GMD061
 */
public class Main {
    private static int sx = 20;
    private static int sy = 20;
    private static int width = sx*32;
    private static int height = 600;
    private static long time;
    private static long cooldown=0;
    //Testing Strings
    static boolean gay = true;
    public static void start() {        
        try {
        Display.setDisplayMode(new DisplayMode(sx*32,600));
        Display.create();
    } catch (LWJGLException e) {
        e.printStackTrace();
        System.exit(0);
    }
        
        
        GL11.glEnable(GL11.GL_TEXTURE_2D);               
         
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);          
         
            // enable alpha blending
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
         
            GL11.glViewport(0,0,width,height);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
 
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, width, height, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);  
        
        List<Bee> bees = new ArrayList();
        Map m = new Map(20,20);
              
        Structure s = new Structure(4,8,"house");
        
        cooldown=Sys.getTime()+1000;
        while (!Display.isCloseRequested()) 
        {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);  
        m.draw();//draw the map
        
        time = Sys.getTime();//get the current time
        if(cooldown<time){
            bees.add(new Bee(1,1,"sprite"));
            cooldown=time+1000;}
        for (Bee g: bees)
        {
            g.update(m);
            g.draw();
        }
        
        s.draw();
        Display.update();
        Display.sync(60);
        }
    
    Display.destroy();
    }
    public static void main(String args[])
    {
        start();
    }
}
