

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: soh8916
 * Date: May 23, 2011
 * Time: 10:50:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class Level5 extends AbstractLevel {

    public Level5() {
        //NEEDED : THIS SETS THE LEVEL
        setLevel(5);
        setNumberOfCoins(12);

        /*Applies to All Zone Methods :
        Method Parameters : (vertical row position, horizontal column position,
        numbers of rows to go down, numbers of columns to go right)
        */

        //add contest also known as main action zone
        addContestZone(2 , 2 , 16 , 16);

        //add another contest zone


       addBlockZone(2,2, 3, 11);
       addBlockZone(2,16, 16, 2);
       addBlockZone(14, 2, 4, 10);

        //add starting one or the place where the player starts z
        setStartingZone(6,2,2,1);
         setEndingZone(9, 15 , 2 , 1);

        //add block Zone or the place where the player cannot go on


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


        //add horizontal moving obstacle which moves from left to right

        addHorizontalObstacle(4 , 15, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(6 , 15, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(8 , 15, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(10 , 15, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(12, 15, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(14, 15, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(16, 15, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );

        addHorizontalObstacle(3 , 14, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(5 , 14, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(7 , 14, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(9 , 14, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(11, 14, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(13, 14, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(15, 14, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        addHorizontalObstacle(17 , 14, 13 , 15 , 0.3 , Color.BLUE, Color.BLACK );
        //add rotating Obstacle that will rotate around a tile for a certain number of tiles

        addRotatingObstacle(9 , 7, 0 , 0 , Color.BLUE, Color.BLACK );

        addRotatingObstacle(8 , 7, 0 , 1 , Color.BLUE, Color.BLACK );
        addRotatingObstacle(7 , 7, 0 , 2 , Color.BLUE, Color.BLACK );
        addRotatingObstacle(6 , 7, 0 , 3 , Color.BLUE, Color.BLACK );

        addRotatingObstacle(10 , 7, 180 , 1 , Color.BLUE, Color.BLACK );
        addRotatingObstacle(11 , 7, 180 , 2 , Color.BLUE, Color.BLACK );
        addRotatingObstacle(12 , 7, 180 , 3 , Color.BLUE, Color.BLACK );

        //add coin
        addCoin(8 , 6);
        addCoin(9 , 6);
        addCoin(10 , 6);

        addCoin(8 , 7);
        addCoin(8 , 8);

        addCoin(9 , 8);
        addCoin(10 , 8);

        addCoin(10 , 7);



        //add another coin
        addCoin(12, 15);
        addCoin(15, 15);
        addCoin(6 , 15);
        addCoin(3 , 15);

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

