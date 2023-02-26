package Input;

import Objects.Ships;
import Objects.States;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *
* @author Dell
 */
public class MouseDragged implements MouseMotionListener {

    private int x;
    private int y;
    public boolean canMove = true;
    public static boolean isMoved = true;
    public static Ships ship = null;
    private States ships;

    public MouseDragged(States ships) {
        this.ships = ships;

    }

    public void setShip(Ships ship) {
        this.ship = ship;
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        if (canMove)
            try {
            if (isMoved) {
                isMoved = false;
                setShip(MouseCollision.getShipClick(ships, me));
                x = me.getX() - ship.getX1();
                y = me.getY() - ship.getY1();
            }
            ship.setX(me.getX() - x);
            ship.setY(me.getY() - y);
        } catch (Exception ex) {

        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
    }
}
