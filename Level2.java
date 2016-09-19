

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 18, 2011
 * Time: 6:46:26 PM
 * To change this template use File | Settings | File Templates.
 */
public class Level2 extends AbstractLevel {
    private int speed = 5;
    public Level2() {
        //NEEDED : THIS SETS THE LEVEL
        setLevel(2);

        /*Applies to All Zone Methods :
        Method Parameters : (vertical row position, horizontal column position,
        numbers of rows to go down, numbers of columns to go right)
        */

        //add contest also known as main action zone
        addContestZone(2 , 2 , 22 , 30);

        //add another contest zone
        //addContestZone(2 , 24 , 8 ,  8);

        /*set right bound of zone 1 to a different size and put it in another place
         Method Parameters :
         getBound(zone number(0-n), bound(0-3))
         replace(vertical row position, horizontal column position,
         numbers of rows to go down, numbers of columns to go right)
         */
        //getBound(0, 1).replace(10, 24, 15 , 1 );

        /*remove left bound from zone 1
         Method Parameters : (zone number(0-n), bound(0-3))
         */
       // removeBound(1 , 3);

        //add starting one or the place where the player starts z
        setStartingZone(2 , 16 , 4 , 4);

        //add ending zone or the place where the player has to go
        setEndingZone(20 , 16, 4 , 4);

        //add block Zone or the place where the player cannot go on
          addBlockZone(2 , 2 , 4 , 8); // top right
          addBlockZone(3, 27, 4, 6); // top left
          addBlockZone(10, 17, 9, 2); // middle
          addBlockZone(22, 3, 3, 9);//bottom
          addBlockZone(22,25,5,7);

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
        addVerticalObstacle(5 , 14, 2 , 23 , speed , Color.BLUE, Color.BLACK );//left near the start
        addVerticalObstacle(5 , 20, 2 , 23 , speed , Color.BLUE, Color.BLACK );//right near the start
		addVerticalObstacle(3 ,11 , 5 , 20 , speed , Color.BLUE, Color.BLACK ); // farthest left
		addVerticalObstacle(3 , 23, 5 , 23 , speed , Color.BLUE, Color.BLACK );// farthest right
        //add horizontal moving obstacle which moves from left to right
        addHorizontalObstacle(8 , 2, 2 , 31 , speed , Color.BLUE, Color.BLACK );
		addHorizontalObstacle(10 , 2, 2 , 16 , speed , Color.BLUE, Color.BLACK );
		addHorizontalObstacle(18 , 2, 2 , 16 , speed , Color.BLUE, Color.BLACK );
		addHorizontalObstacle(19 , 2, 2 , 31 , speed , Color.BLUE, Color.BLACK );
		addHorizontalObstacle(10 , 2, 19 , 31 , speed , Color.BLUE, Color.BLACK );
		addHorizontalObstacle(18 , 2, 19 , 31 , speed , Color.BLUE, Color.BLACK );
        //add rotating Obstacle that will rotate around a tile for a certain number of tiles
        //addRotatingObstacle(6 , 12, 0 , 6 , Color.BLUE, Color.BLACK );

        //add coin
        //addCoin(9 , 9);

        //add another coin
       // addCoin(15, 15);

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
