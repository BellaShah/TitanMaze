

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 18, 2011
 * Time: 6:46:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Level4 extends AbstractLevel {

    public Level4() {
        //NEEDED : THIS SETS THE LEVEL
        setLevel(4);
        setNumberOfCoins(26);

        /*Applies to All Zone Methods :
        Method Parameters : (vertical row position, horizontal column position,
        numbers of rows to go down, numbers of columns to go right)
        */

        //add contest also known as main action zone
        addContestZone(2 , 2 , 22 , 22);

        //add another contest zone
        //addContestZone(2 , 24 , 8 ,  8);

        /*set right bound of zone 1 to a different size and put it in another place
         Method Parameters :
         getBound(zone number(0-n), bound(0-3))
         replace(vertical row position, horizontal column position,
         numbers of rows to go down, numbers of columns to go right)
         */


        /*remove left bound from zone 1
         Method Parameters : (zone number(0-n), bound(0-3))
         */


        //add starting one or the place where the player starts z
        setStartingZone(2 ,10 ,5 , 6);

        //add ending zone or the place where the player has to go
        setEndingZone(20 , 10 , 4 , 6);

        //add block Zone or the place where the player cannot go on
        //addBlockZone(10 , 10 , 5 , 5);

        /*Applies to All Obstacle and Object Methods :
        Method Parameters :
        addVerticalObstacle(vertical row position , horizontal column position,
        vertical row position to go from , vertical row position to go to , speed , main object color, frame or border color);

         Method Parameters :
        addHorizontalObstacle(vertical row position , horizontal column position,
        horizontal column position to go from , horizontal column position to go to , speed , main object color, frame or border color);

        Method Parameters :
        addRotatingObstacle(vertical row position , horizontal column position,
        starting direction(0-360 degrees) where 0 means right , vertical rows from row position, main object color, frame or border color);

        Method Parameters :
        addCoin(row position, column position)

         */

        //add vertical moving obstacle which moves up and down
        addVerticalObstacle(22 , 2, 2 , 23 , 5.0 , Color.BLUE, Color.BLACK );
		addVerticalObstacle(2 , 4, 2 , 23 , 5.0 , Color.BLUE, Color.BLACK );
		addVerticalObstacle(22 , 6, 2 , 23 , 5.0 , Color.BLUE, Color.BLACK );
		addVerticalObstacle(2 , 8, 2 , 23 , 5.0 , Color.BLUE, Color.BLACK );
		addVerticalObstacle(22 , 10, 7 , 16 , 5.0 , Color.BLUE, Color.BLACK );
		addVerticalObstacle(2 , 12, 7 , 16 , 5.0 , Color.BLUE, Color.BLACK );
		addVerticalObstacle(22 , 14, 7 , 16 , 5.0 , Color.BLUE, Color.BLACK );
		addVerticalObstacle(2 , 16, 2 , 23 , 5.0 , Color.BLUE, Color.BLACK );
		addVerticalObstacle(22 , 18, 2 , 23 , 5.0 , Color.BLUE, Color.BLACK );
		addVerticalObstacle(2 , 20, 2 , 23 , 5.0 , Color.BLUE, Color.BLACK );
		addVerticalObstacle(22 , 22, 2 , 23 , 5.0 , Color.BLUE, Color.BLACK );
        //add horizontal moving obstacle which moves from left to right
        addHorizontalObstacle(8 , 2, 2 , 23 , 5.0 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(10, 22, 2, 23, 5.0, Color.BLUE, Color.BLACK );
        addHorizontalObstacle(12, 2, 2, 23, 5.0, Color.BLUE, Color.BLACK );
        addHorizontalObstacle(14, 22, 2, 23, 5.0, Color.BLUE, Color.BLACK );
        addHorizontalObstacle(16, 2, 2, 23, 5.0, Color.BLUE, Color.BLACK );
        addHorizontalObstacle(18, 22, 2, 23, 5.0, Color.BLUE, Color.BLACK );


        //add rotating Obstacle that will rotate around a tile for a certain number of tiles
        //addRotatingObstacle(6 , 12, 0 , 6 , Color.BLUE, Color.BLACK );

        //add coin

        addCoin(7,7);
        addCoin(8,7);
        addCoin(9,7);
        addCoin(10,7);
        addCoin(11,7);
        addCoin(12,7);
		addCoin(13,7);
		addCoin(14,7);
		addCoin(15,7);
		addCoin(16,7);
		addCoin(17,7);
		addCoin(18,7);
		addCoin(19,7);

        //add another coin
        addCoin(7,17);
        addCoin(8,17);
        addCoin(9,17);
        addCoin(10,17);
        addCoin(11,17);
        addCoin(12,17);
        addCoin(13,17);
        addCoin(14,17);
        addCoin(15,17);
		addCoin(16,17);
		addCoin(17,17);
		addCoin(18,17);
		addCoin(19,17);

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
