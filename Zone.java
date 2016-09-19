

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: axa0562
 * Date: May 12, 2011
 * Time: 10:33:50 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Zone implements GameConstants {
    private int xPosition;
    private int yPosition;

    private int width;
    private int height;

    private int row ;
    private int column ;
    private int rows ;
    private int columns ;

    public Zone(int row, int column, int rows, int columns) {
        xPosition = Grid.getXCoordinate(column);
        yPosition = Grid.getYCoordinate(row);

        width = Grid.getXCoordinate(columns);
        height = Grid.getYCoordinate(rows);

        this.row = row ;
        this.column = column ;
        this.rows = rows ;
        this.columns = columns;
    }

    public void setXPosition(int x){
        xPosition = x ;
    }

    public void setYPosition(int y){
        yPosition = y ;
    }

    public void setPosition(int x , int y){
        xPosition = x ;
        yPosition = y ;
    }

    public void setWidth(int width){
        this.width = width;
    }

     public void setHeight(int height){
        this.height = height;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getColumn(){
        return column ;
    }

     public int getRow(){
        return row ;
    }

    public int getColumns(){
        return columns ;
    }

     public int getRows(){
        return rows ;
    }

    public abstract void draw(Graphics g);
}
