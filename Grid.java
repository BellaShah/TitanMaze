
/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 15, 2011
 * Time: 12:37:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Grid implements GameConstants {

    private int row;
    private int column;

    private int rows;
    private int columns;

    public Grid(int row, int column, int rows, int columns) {

        this.row = row;
        this.column = column;

        this.rows = rows;
        this.columns = columns;

        resetGridCoordinates();

    }

    public void resetGridCoordinates() {

    }

    public static int getXCoordinate(int column) {
        return column * TILE_SIZE;
    }

    public static int getYCoordinate(int row) {
        return row * TILE_SIZE;
    }

    public static void putInLocation(int row, int column, BallObstacle gameShape) {
        gameShape.setXPosition(column * TILE_SIZE + TILE_SIZE / 2 - gameShape.getWidth() / 2);
        gameShape.setYPosition(row * TILE_SIZE + TILE_SIZE / 2 - gameShape.getHeight() / 2);
    }

    public static void rotateFromLocation(int row, int column, BallObstacle gameShape) {
        gameShape.setXPosition(column * TILE_SIZE + TILE_SIZE / 2 - gameShape.getWidth() / 2 + 5);
        gameShape.setYPosition(row * TILE_SIZE + TILE_SIZE / 2 - gameShape.getHeight() / 2);
    }

    public static int getXLocation(int column, int objectWidth) {
        return column * TILE_SIZE + TILE_SIZE / 2 - objectWidth / 2;
    }

    public static int getYLocation(int row, int objectHeight) {
        return row * TILE_SIZE + TILE_SIZE / 2 - objectHeight / 2;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

}
