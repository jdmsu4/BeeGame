package Entity;

import java.io.IOException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Structure extends Sprite
{
    private Texture t;
    static float x;
    static float y;
    
    public Structure(int x, int y, String tex)
    {
        super(x,y,tex);
    }
}
