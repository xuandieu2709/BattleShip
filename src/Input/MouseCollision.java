package Input;

import Objects.Ships;
import Objects.States;
import java.awt.event.MouseEvent;

/**
 *
* @author Dell
 */
public class MouseCollision
{

    public static Ships getShipClick(States ships, MouseEvent me)
    {
        int X = me.getX();
        int Y = me.getY();
        if (ships.battleship.getX1() < X && ships.battleship.getX2() > X && ships.battleship.getY1() < Y && ships.battleship.getY2() > Y)
            return ships.battleship;
        if (ships.cruise.getX1() < X && ships.cruise.getX2() > X && ships.cruise.getY1() < Y && ships.cruise.getY2() > Y)
            return ships.cruise;
        if (ships.destroyer1.getX1() < X && ships.destroyer1.getX2() > X && ships.destroyer1.getY1() < Y && ships.destroyer1.getY2() > Y)
            return ships.destroyer1;
        if (ships.destroyer2.getX1() < X && ships.destroyer2.getX2() > X && ships.destroyer2.getY1() < Y && ships.destroyer2.getY2() > Y)
            return ships.destroyer2;
        if (ships.submarine.getX1() < X && ships.submarine.getX2() > X && ships.submarine.getY1() < Y && ships.submarine.getY2() > Y)
            return ships.submarine;
        return null;
    }
}
