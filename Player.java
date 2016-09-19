

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: axa0562
 * Date: May 10, 2011
 * Time: 11:10:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class Player implements Runnable, GameConstants {

    private GameShape playerObject;

    private GameShape playerFrame;

    private double velocity;

    private boolean directions[];

    private int deaths;

    private int coinsGrabbed;


    public Player(double speed, SafeZone startingZone) {

        playerObject = new RectangleShape(startingZone.getXPosition() + startingZone.getWidth() / 2, startingZone.getYPosition() + startingZone.getHeight() / 2, playerSize, playerSize, playerColor);

        playerFrame = new RectangleShape(startingZone.getXPosition() + startingZone.getWidth() / 2 - playerFrameDistance,
                startingZone.getYPosition() + startingZone.getHeight() / 2 - playerFrameDistance,
                playerSize + playerFrameDistance * 2,
                playerSize + playerFrameDistance * 2,
                playerFrameColor);

        directions = new boolean[10];

        velocity = speed;

        deaths = 0;

        coinsGrabbed = 0;

    }

    public void draw(Graphics g) {

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(playerFrame.getColor());

        g2d.fill(playerFrame.getModel());

        g2d.setColor(playerObject.getColor());

        g2d.fill(playerObject.getModel());

        g2d.dispose();

    }

    public void setXPosition(double x) {
        playerObject.setXPosition(x);
        playerFrame.setXPosition(x - playerFrameDistance);
    }

    public void setYPosition(double y) {
        playerObject.setYPosition(y);
        playerFrame.setYPosition(y - playerFrameDistance);
    }

    public void move() {
        if (directions[0])
            setYPosition(getYPosition() - velocity);

        if (directions[1])
            setXPosition(getXPosition() - velocity);

        if (directions[2])
            setYPosition(getYPosition() + velocity);

        if (directions[3])
            setXPosition(getXPosition() + velocity);
    }

    public void setDirections(boolean direction[]) {
        directions = direction;
    }

    public double getXPosition() {
        return playerObject.getXPosition();
    }

    public double getYPosition() {
        return playerObject.getYPosition();
    }

    public double getWidth() {
        return playerObject.getWidth();
    }

    public double getHeight() {
        return playerObject.getHeight();
    }

    public void checkCollisions(AbstractLevel level) {
        boolean b = false;
        for (ContestZone zone : level.getContestZones()) {
            if (b) break;
            for (BlockZone bound : zone.getBounds()) {
                if (intersects(bound.getXPosition(), bound.getYPosition(),
                        bound.getWidth(), bound.getHeight())) {
                    if (directions[3] && getXPosition() <= bound.getXPosition())
                        setXPosition(getXPosition() - 2 * velocity);
                    else if (directions[1] && getXPosition() >= bound.getXPosition())
                        setXPosition(getXPosition() + 2 * velocity);
                    if (directions[2] && getYPosition() <= bound.getYPosition())
                        setYPosition(getYPosition() - 2 * velocity);
                    else if (directions[0] && getYPosition() >= bound.getYPosition())
                        setYPosition(getYPosition() + 2 * velocity);
                    b = true;
                    break;
                }
            }
        }

        for (BlockZone block : level.getBlockZones()) {
            if (intersects(block.getXPosition(), block.getYPosition(), block.getWidth(), block.getHeight())) {
                if (directions[3] && getXPosition() <= block.getXPosition())
                    setXPosition(getXPosition() - 2 * velocity);
                else if (directions[1] && getXPosition() >= block.getXPosition())
                    setXPosition(getXPosition() + 2 * velocity);
                if (directions[2] && getYPosition() <= block.getYPosition())
                    setYPosition(getYPosition() - 2 * velocity);
                else if (directions[0] && getYPosition() >= block.getYPosition())
                    setYPosition(getYPosition() + 2 * velocity);
                break;
            }
        }

    }

    public boolean isInZone(Zone zone) {
        return playerObject.getModel().intersects(zone.getXPosition(), zone.getYPosition(), zone.getWidth(), zone.getHeight());
    }

    public void touches(AbstractLevel level) {
        for (BallObstacle obstacle : level.getObstacles())
            if (intersects(obstacle.getXPosition(), obstacle.getYPosition(), obstacle.getWidth(), obstacle.getHeight())) {
                setXPosition((level.getStartingZone().getXPosition() + level.getStartingZone().getWidth() / 2));
                setYPosition((level.getStartingZone().getYPosition() + level.getStartingZone().getHeight() / 2));
                deaths++;
                level.resetCoins();
                coinsGrabbed = 0;
            }
    }

    public void grabCoins(AbstractLevel level) {
        ArrayList<Coin> coins = level.getCoins();
        for (int coin = 0; coin < coins.size(); coin++)
            if (intersects(coins.get(coin).getXPosition(), coins.get(coin).getYPosition(), coins.get(coin).getWidth(), coins.get(coin).getHeight())) {
                coinsGrabbed++;
                level.transferCoin(coin);
            }
    }

    public int getNumberOfCoinsGrabbed() {
        return coinsGrabbed;
    }

    public boolean intersects(double x, double y, double width, double height) {
        return playerObject.getModel().intersects(x, y, width, height);
    }

    public void runLevel(AbstractLevel level) {
        checkCollisions(level);
        touches(level);
        grabCoins(level);
        savePlayer(level);
    }

    public void savePlayer(AbstractLevel level) {
        for (SafeZone safeZone : level.getSafeZones()) {
            if (isInZone(safeZone)) {
                level.addSafeZone(level.getStartingZone());
                level.setStartingZone(safeZone);
                break;
            }
        }
    }

    public int getNumberOfDeaths() {
        return deaths;
    }

    public void run() {
        move();
    }
}
