

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: soh8916
 * Date: May 19, 2011
 * Time: 11:01:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class Level3 extends AbstractLevel{
    public Level3() {
        //NEEDED : THIS SETS THE LEVEL
        setLevel(3);
        setNumberOfCoins(6);

        /*Applies to All Zone Methods :
        Method Parameters : (vertical row position, horizontal column position,
        numbers of rows to go down, numbers of columns to go right)
        */

        //add contest also known as main action zone
        addContestZone(2 , 2 , 14 , 16);

        //up left
        addBlockZone(2 , 2 , 1 , 2);

        //up left
        addBlockZone(3 , 2 , 3 , 3);

        //up right
        addBlockZone(2, 14, 1, 3);

        //left
        addBlockZone(7, 2, 3, 2);

        //right
        addBlockZone(6, 16, 8, 2);

        //down
        addBlockZone(14, 6, 2, 8);

        //center boundry
        addBlockZone(8, 6, 1, 10);

        //down boundry
        addBlockZone(10, 9, 5, 1);

        /*remove left bound from zone 1
         Method Parameters : (zone number(0-n), bound(0-3))
         */


        //add starting one o the place where the player starts z
        setStartingZone(5 , 13 , 3 , 3);

        //add ending zone or the place where the player has to go
        setEndingZone(14 , 16 , 2 , 2);


        //add vertical moving obstacle which moves up and down
        //section 1
        addVerticalObstacle(2 , 6, 2 , 7 , 0.5 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(2 , 8, 2 , 7 , 0.5 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(2 , 10, 2 , 7 , 0.5 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(2 , 12, 2 , 7 , 0.5 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(2 , 14, 2 , 7 , 0.5 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(2 , 16, 2 , 7 , 0.5 , Color.BLUE, Color.BLACK );
        //section2 MONDAY!!!!!!!!
        //up
        addVerticalObstacle(8 , 6, 8 , 13 , 0.5 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(8 , 8, 8 , 13 , 0.5 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(8 , 10, 8 , 13 , 0.5 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(8 , 12, 8 , 13 , 0.5 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(8 , 14, 8 , 13 , 0.5 , Color.BLUE, Color.BLACK );
        //down
        addVerticalObstacle(13 , 7, 8 , 13 , 0.7 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(13 , 9, 8 , 13 , 0.7 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(13 , 11, 8 , 13 , 0.7 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(13 , 13, 8 , 13 , 0.7 , Color.BLUE, Color.BLACK );
        addVerticalObstacle(13 , 15, 8 , 13 , 0.7 , Color.BLUE, Color.BLACK );
        //add horizontal moving obstacle which moves from left to right
        addHorizontalObstacle(6 , 2, 5 , 15 , 1.2 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(4 , 2, 5 , 17 , 1.2 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(2 , 2, 4 , 13 , 1.2 , Color.BLUE, Color.BLACK );
        //add rotating Obstacle that will rotate around a tile for a certain number of tiles
        //addRotatingObstacle(6 , 12, 0 , 6 , Color.BLUE, Color.BLACK );

        //add coin
        addCoin(9 , 9);

        //add another coin
        addCoin(15, 15);
        addCoin(2,4);
        addCoin(6,2);
        addCoin(13,3);
        addCoin(2,17);

    }

    public void draw(Graphics g) {
        //NEEDED : USE THIS METHOD TO DRAW ALL OBJECTS AND SHAPES
        super.draw(g);
    }

    @Override
    public void run() {
        //NEEDED : USE THIS METHOD TO MOVE THE OBSTACLES
        moveObstacles();
    }
}
