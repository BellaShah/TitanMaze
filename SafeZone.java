

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 11, 2011
 * Time: 8:05:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SafeZone extends Zone implements GameConstants {

    public SafeZone(int row, int column, int rows, int columns) {
        super(row, column, rows, columns);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(safeZoneColor);
        g.fillRect(getXPosition(), getYPosition(), getWidth(), getHeight());
    }
}
