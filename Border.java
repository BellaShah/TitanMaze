

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 11, 2011
 * Time: 8:05:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Border implements GameConstants {
    private ArrayList<BlockZone> bounds;

    public Border(int row, int column, int rows, int columns) {
        bounds = new ArrayList<BlockZone>();

        //north
        bounds.add(new BlockZone(row - 1, column - 1, 1, columns + 1));

        //east
        bounds.add(new BlockZone(row - 1, column + columns, rows + 2, 1));

        //south
        bounds.add(new BlockZone(row + rows, column - 1, 1, columns + 1));

        //west
        bounds.add(new BlockZone(row - 1, column - 1, rows + 1, 1));

    }

    public void draw(Graphics g) {
        for (BlockZone blockZone : bounds)
            blockZone.draw(g);
    }

    public ArrayList<BlockZone> getBounds() {
        return bounds;
    }


}
