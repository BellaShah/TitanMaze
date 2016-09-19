

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: axa0562
 * Date: May 17, 2011
 * Time: 11:01:31 AM
 * To change this template use File | Settings | File Templates.
 */
public class BlockZone extends Zone implements GameConstants {

    public BlockZone(int row, int column, int rows, int columns) {
        super(row, column, rows, columns);
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.BLACK);
        g2d.fillRect(getXPosition() , getYPosition() , getWidth() , getHeight());
        g2d.dispose();
    }

    public void setPosition(int row, int column){
        super.setPosition(Grid.getXCoordinate(column), Grid.getYCoordinate(row));
    }

    public void setXPosition(int column){
        super.setXPosition(Grid.getXCoordinate(column));
    }

    public void setYPosition(int row){
        super.setYPosition(Grid.getYCoordinate(row));
    }

    public void replace(int row, int column, int rows, int columns){
        this.setPosition(row , column);
        setHeight(Grid.getYCoordinate(rows));
        setWidth(Grid.getXCoordinate(columns));
    }
}
