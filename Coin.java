

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: axa0562
 * Date: May 17, 2011
 * Time: 10:23:36 AM
 * To change this template use File | Settings | File Templates.
 */
public class Coin extends BallShape implements GameConstants {

    //The border around the coin
    private BallShape ballFrame;

    //constructor
    public Coin(double x, double y) {

        //calls parent class constructor; size and color are predefined in GameConstants
        super(x, y, coinSize, coinSize, coinColor);

        //this creates the coin frame
        ballFrame = new BallShape(x - obstacleFrameDistance,
                y - obstacleFrameDistance,
                obstacleSize_small + obstacleFrameDistance * 2,
                obstacleSize_small + obstacleFrameDistance * 2,
                frameColor);

    }

    //this method draws the coin object and its frame
    public void draw(Graphics g){

        /*we want to create 2D graphics for better performance
         g.create() will create a new reference so that we don't use the old one and create problems */
        Graphics2D g2d = (Graphics2D)g.create();

         //this makes graphics more smooth
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //set the Color and draw the frame into the screen
        g2d.setColor(ballFrame.getColor());
        g2d.fill(ballFrame.getModel());

        //set the Color and draw the object into the screen
        g2d.setColor(getColor());
        g2d.fill(getModel());

         //in order to not use too much memory, and because we don't need it any more, we will dispose the graphics object
        g2d.dispose();

    }
}
