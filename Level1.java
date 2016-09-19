

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 12, 2011
 * Time: 4:54:46 PM
 * To change this template use File | Settings | File Templates.
 */
public class Level1 extends AbstractLevel {

    private double speed = 3;


    public Level1() {
        setLevel(1);
        setNumberOfCoins(0);

        addContestZone(1, 1, 18, 18);
        setStartingZone(1, 1, 4, 4);
        setEndingZone(15, 15, 4, 4);

        for (int o = 0; o < 10; o += 2)
            addVerticalObstacle(1, 5 + o, 1, 18, speed, Color.BLUE, Color.BLACK);

        for (int o = 0; o < 10; o += 2)
            addVerticalObstacle(18, 6 + o, 1, 18, speed, Color.BLUE, Color.BLACK);

        for (int o = 0; o < 10; o += 2)
            addHorizontalObstacle(5 + o, 1, 1, 18, speed, Color.BLUE, Color.BLACK);

        for (int o = 1; o < 10; o += 2)
            addHorizontalObstacle(5 + o, 18, 1, 18, speed, Color.BLUE, Color.BLACK);

    }

    public void draw(Graphics g) {
        super.draw(g);

    }

    @Override
    public void run() {
        moveObstacles();
    }
}
