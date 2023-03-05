package Model;

import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

/**
 *
 * @author Dell
 */
public abstract class Ships extends Object implements GameObject {

    private final BufferedImage imgTo0; // hình ảnh ban đầu của tàu
    protected int life; // số lượng ô trên bàn cờ mà tàu chiếm
    protected long score; // Điểm số
    public boolean board = false; // check tàu đã được đặt trên bàn cờ hay chưa
    public int XStart;
    public int YStart;
    private boolean rotate = false; // check tàu xoay 90 độ chưa
    public int[][] position; //  các tọa độ của từng ô trên bàn cờ mà tàu chiếm

    public Ships(BufferedImage img, int life, int X1, int Y1) {
        super(img, X1, Y1);
        this.imgTo0 = img;
        this.life = life;
        position = new int[life][4];
        this.XStart = X1;
        this.YStart = Y1;
    }

    public Ships(BufferedImage img, int life, long score, int X1, int Y1) {
        super(img, X1, Y1);
        this.imgTo0 = img;
        this.life = life;
        this.score = score;
        position = new int[life][4];
        this.XStart = X1;
        this.YStart = Y1;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public void reduceLife() {
        life--;
    }

    public void setPosition() {
        int x = X1;
        int y = Y1;
        for (int i = 0; i < life; i++) {
            position[i][0] = x;
            position[i][1] = x + 50;
            position[i][2] = y;
            position[i][3] = y + 50;
            if (!rotate) {
                x += 50;
            } else {
                y += 50;
            }
//            ships.listPoint.add(new PointShip(position[i][0], position[i][2], false));

        }
    }

    public boolean isRotate() {
        return rotate;
    }

    public boolean isBoard() {
        return board;
    }

    public void setBoard(boolean board) {
        this.board = board;
    }

    public void rotateTo90() {
        double rads = Math.toRadians(-90);
        double sin = Math.abs(Math.sin(rads));
        double cos = Math.abs(Math.cos(rads));
        int w = (int) Math.floor(WIDTH * cos + HEIGHT * sin);
        int h = (int) Math.floor(HEIGHT * cos + WIDTH * sin);
        BufferedImage rotatedImage = new BufferedImage(w, h, img.getType());
        AffineTransform at = new AffineTransform();
        at.translate(w / 2, h / 2);
        at.rotate(rads, 0, 0);
        at.translate(-WIDTH / 2, -HEIGHT / 2);
        AffineTransformOp rotateOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        rotateOp.filter(img, rotatedImage);
        img = rotatedImage;
        WIDTH = img.getWidth();
        HEIGHT = img.getHeight();
        this.setX(this.getX1());
        this.setY(this.getY1());
        rotate = true;
    }

    public void rotateTo0() {
        img = imgTo0;
        WIDTH = img.getWidth();
        HEIGHT = img.getHeight();
        this.setX(this.getX1());
        this.setY(this.getY1());
        rotate = false;
    }

    @Override
    public abstract void draw(Graphics g);
}
