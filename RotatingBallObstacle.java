

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 15, 2011
 * Time: 2:39:44 PM
 * To change this template use File | Settings | File Templates.
 */
public class RotatingBallObstacle extends BallObstacle {

    //specific to this class, this is the angle that which the object rotates
    private double angle ;

    //constructor
    public RotatingBallObstacle(double x, double y, double startingAngle, double speed, Color mainColor, Color frameColor) {
        //calls parent class constructor
        super(x, y, speed, mainColor, frameColor);
        //this sets the angle rotation of the obstacle to the startingAngle parameter
        angle = startingAngle ;
    }

    //move implementation
    @Override
    public void move() {

        /*
        this object is changing its x position and y position based on the direction and speed
         which are dependant on the angle rotation and distance from a center focal point
         */

        setXPosition(getXPosition() + getXDirection() * getSpeed());
        setYPosition(getYPosition() + getYDirection() * getSpeed());

        /*
        increases the angle so that the object rotates
        it resets when it gets to 360 degrees
         */

        angle += 1;
        if (angle >= 360)
            angle = 0;

    }

    //return the x direction of the rotating obstacle
    public double getXDirection() {
        return Math.cos(Math.toRadians(angle));
    }

    //returns the y direction of the rotating obstacle
    public double getYDirection() {
        return Math.sin(Math.toRadians(angle));
    }

    //this method rotates the object's components before it draws them onto the screen
    public void draw(Graphics g){

         /*
        we want to create 2D graphics for better performance
         g.create() will create a new reference so that we don't use the old one and create problems
         */

        Graphics2D graphics2D = (Graphics2D)g.create();

         //this makes graphics more smooth
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //this rotates the obstacle to that angle and it rotates around a position around its own
        graphics2D.rotate(Math.toRadians(angle),getXPosition(),getYPosition());

        //set the color and draw the object frame into the screen
        graphics2D.setColor(getFrame().getColor());
        graphics2D.fill(getFrame().getModel());

        //set the color and draw the object into the screen
        graphics2D.setColor(getColor());
        graphics2D.fill(getModel());

        //in order to not use too much memory, and because we don't need it any more, we will dispose the graphics object
        graphics2D.dispose();

    }

    //implementation of the run method from the Runnable interface which is a Thread
    @Override
    public void run() {
        move();
    }
}
