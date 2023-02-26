package Model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
* @author Dell
 */
public class Destroyer extends Ships
{

    public Destroyer(BufferedImage img, int life, int X1, int Y1)
    {
        super(img, life, X1, Y1);
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(img, X1, Y1, null);
    }
    
}
