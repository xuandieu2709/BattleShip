package Model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
* @author Dell
 */
public class Board implements GameObject
{

    private final BufferedImage img;
    private final int X;
    private final int Y;
    public int boxBoard[][] = new int[100][4];
       /* Mảng boxBoard có 100 phần tử, tương ứng với 100 "hộp vuông" trên bàn cờ. Mỗi phần tử chứa 
    một mảng 1 chiều gồm 4 phần tử( x,y góc trên bên trái và x,y góc dưới bên phải)*/
    public Board(BufferedImage img, int X, int Y)
    {
        this.img = img;
        this.X = X;
        this.Y = Y;
        setBoxBoard();
    }
    
    private void setBoxBoard()
    {
        int x = 50;
        int y = 50;
        int cont = 0;
        for (int i = 0; i < 100; i++)
        {
            boxBoard[i][0] = X + x; // 50
            boxBoard[i][1] = X + x + 50; // 100
            boxBoard[i][2] = Y + y; // 50
            boxBoard[i][3] = Y + y + 50; // 100
            x += 50;
            cont++;
            if (cont > 9)
            {
                x = 50;
                y += 50;
                cont = 0;
            }
        }
    }

    @Override
    public void draw(Graphics g)
    {
        g.drawImage(img, X, Y, null);
    }
}
