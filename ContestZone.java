
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 11, 2011
 * Time: 8:05:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContestZone extends Zone implements GameConstants {

    public Border bounds;
    private Grid grid;

    public ContestZone(int row, int column, int rows, int columns) {
        super(row, column, rows, columns);
        grid = new Grid(row, column, rows, columns);
        bounds = new Border(row, column, rows, columns);
    }

    @Override
    public void draw(Graphics g) {
        bounds.draw(g);
        drawTiles(g);
    }

    private void drawTiles(Graphics g) {
        boolean even = true;
        for (int y = getYPosition(); y < getYPosition() + getHeight(); y += TILE_SIZE) {
            even = !even;
            for (int x = getXPosition(); x < getXPosition() + getWidth(); x += TILE_SIZE) {
                if (even) g.setColor(tileColor1);
                else g.setColor(tileColor2);
                g.fillRect(x, y, TILE_SIZE, TILE_SIZE);
                even = !even;
            }
        }
    }

    public int getRow() {
        return grid.getRow();
    }

    public int getColumn() {
        return grid.getColumn();
    }

    public int getRows() {
        return grid.getRows();
    }

    public int getColumns() {
        return grid.getColumns();
    }

    public ArrayList<BlockZone> getBounds(){
        return bounds.getBounds();
    }


}
