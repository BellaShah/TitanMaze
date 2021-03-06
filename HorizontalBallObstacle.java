

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: axa0562
 * Date: May 13, 2011
 * Time: 10:32:42 AM
 * To change this template use File | Settings | File Templates.
 */
public class HorizontalBallObstacle extends BallObstacle {

    //constructor
    public HorizontalBallObstacle(double x, double y, double start, double end, double speed , Color mainColor, Color frameColor) {
        //calls parent class constructor
        super(x, y, start, end, speed, mainColor, frameColor);
    }

    //this method moves the object horizontally by calling the method from the parent class
    public void move() {
        super.moveHorizontal();
    }

    //this draws the frame or border of the object and the main object through the super.draw(g) method
    public void draw(Graphics g) {
        drawFrame(g);
        super.draw(g);
    }

    //implementation of the run method from the Runnable interface which is a Thread
    @Override
    public void run() {
        this.move();
    }
}
