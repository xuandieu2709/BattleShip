package Model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
* @author Dell
 */
public class Hit extends Object
{

    public Hit(BufferedImage img, int X1, int Y1)
    {
        super(img, X1, Y1);
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(img, X1, Y1, null);
    }
}
