

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 12, 2011
 * Time: 5:28:51 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class AbstractLevel implements Runnable, GameConstants {
    private Map map;
    private ArrayList<BallObstacle> obstacles;
    private ArrayList<Coin> coins;
    private ArrayList<Coin> removedCoins;
    private int playerDeaths;
    private int level;
    private int numberOfCoins;

    public AbstractLevel() {
        map = new Map();
        obstacles = new ArrayList<BallObstacle>();
        coins = new ArrayList<Coin>();
        removedCoins = new ArrayList<Coin>();
        playerDeaths = 0;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setNumberOfCoins(int coins) {
        numberOfCoins = coins;
    }

    public void setPlayerDeaths(int deaths) {
        playerDeaths = deaths;
    }

    public void setStartingZone(int row, int column, int rows, int columns) {
        map.setStartingZone(row, column, rows, columns);
    }

    public void setStartingZone(SafeZone zone) {
        map.setStartingZone(zone.getRow(), zone.getColumn(), zone.getRows(), zone.getColumns());
    }

    public void setEndingZone(int row, int column, int rows, int columns) {
        map.setEndingZone(row, column, rows, columns);
    }

    public void addSafeZone(int row, int column, int rows, int columns) {
        map.addSafeZone(row, column, rows, columns);
    }

    public void addSafeZone(SafeZone zone){
        map.addSafeZone(zone.getRow(), zone.getColumn(), zone.getRows(), zone.getColumns());
    }

    public void addContestZone(int row, int column, int rows, int columns) {
        map.addContestZone(row, column, rows, columns);
    }

    public void addBlockZone(int row, int column, int rows, int columns) {
        map.addBlockZone(row, column, rows, columns);
    }

    public void addHorizontalObstacle(int row, int column, int startingColumn, int endingColumn, double speed, Color mainColor, Color colorFrame) {
        obstacles.add(new HorizontalBallObstacle(Grid.getXCoordinate(column),
                Grid.getYCoordinate(row),
                Grid.getXLocation(startingColumn, obstacleSize_small),
                Grid.getXLocation(endingColumn, obstacleSize_small),
                speed, mainColor, colorFrame));
        Grid.putInLocation(row, column, obstacles.get(obstacles.size() - 1));
    }

    public void addVerticalObstacle(int row, int column, int startingRow, int endingRow, double speed, Color mainColor, Color colorFrame) {
        obstacles.add(new VerticalBallObstacle(Grid.getXCoordinate(column),
                Grid.getYCoordinate(row),
                Grid.getYLocation(startingRow, obstacleSize_small),
                Grid.getYLocation(endingRow, obstacleSize_small),
                speed, mainColor, colorFrame));
        Grid.putInLocation(row, column, obstacles.get(obstacles.size() - 1));
    }

    public void addRotatingObstacle(int row, int column, double startingAngle, int tiles, Color mainColor, Color colorFrame) {
        obstacles.add(new RotatingBallObstacle(Grid.getXCoordinate(column),
                Grid.getYCoordinate(row),
                startingAngle,
                tiles * 0.61 - 0.065 * (Math.pow(tiles, 1.2) - 1), mainColor, colorFrame));
        Grid.rotateFromLocation(row, column, obstacles.get(obstacles.size() - 1));
    }

    public void addCoin(int row, int column) {
        coins.add(new Coin(Grid.getXLocation(column, coinSize), Grid.getYLocation(row, coinSize)));
    }

    public void draw(Graphics g) {
        map.draw(g);
        drawObjects(g);
        drawDeaths(g);
    }

    public void drawObjects(Graphics g) {
        for (BallObstacle obstacle : obstacles)
            obstacle.draw(g);
        for (Coin coin : coins)
            coin.draw(g);
    }

    public void moveObstacles() {
        for (BallObstacle obstacle : obstacles)
            obstacle.run();
    }

    public SafeZone getStartingZone() {
        return map.getStartingZone();
    }

    public SafeZone getEndingZone() {
        return map.getEndingZone();
    }

    public ContestZone getContestZone(int zone) {
        return map.getContestZone(zone);
    }

    public ArrayList<ContestZone> getContestZones() {
        return map.getContestZones();
    }

    public ArrayList<SafeZone> getSafeZones() {
        return map.getSafeZones();
    }

    public ArrayList<BlockZone> getBlockZones() {
        return map.getBlockZones();
    }

    public ArrayList<BallObstacle> getObstacles() {
        return obstacles;
    }

    public ArrayList<Coin> getCoins() {
        return coins;
    }

    public ArrayList<BlockZone> getBounds(int zone) {
        return map.getBounds(zone);
    }

    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    public void transferCoin(int index) {
        removedCoins.add(coins.get(index));
        coins.remove(index);
    }

    public void resetCoins() {
        for (Coin removedCoin : removedCoins)
            coins.add(removedCoin);
        removedCoins = new ArrayList<Coin>();
    }

    public void removeBound(int zone, int bound){
        getBounds(zone).remove(bound);
    }

    public BlockZone getBound(int zone, int bound){
        return  getBounds(zone).get(bound);
    }

    public void drawDeaths(Graphics g) {
        int fontSize = 25 ;
        g.setColor(stringColor);
        g.setFont(new Font("TimesRoman", Font.BOLD + Font.ITALIC, fontSize));

        g.drawString("Deaths : " + playerDeaths,
                getStartingZone().getXPosition() ,
                getStartingZone().getYPosition() + 2 * fontSize);

        g.drawString("Level : " + level,
                getStartingZone().getXPosition(),
                getStartingZone().getYPosition() +  fontSize);
    }

    public abstract void run();
}
