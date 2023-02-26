package Input;

import Objects.Ships;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

/**
 *
* @author Dell
 */
public class MouseWheel implements MouseWheelListener
{

    private Ships ship;

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe)
    {
        if (!MouseDragged.isMoved)
        {
            ship = MouseDragged.ship;
            if (!ship.isRotate())
                ship.rotateTo90();
            else
                ship.rotateTo0();
        }
    }

}
