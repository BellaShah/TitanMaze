

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by IntelliJ IDEA.
 * User: axa0562
 * Date: May 10, 2011
 * Time: 10:57:08 AM
 * To change this template use File | Settings | File Templates.
 */
public class BallShape extends GameShape {

    //BallShape constructor
    public BallShape(double x, double y, double width, double height, Color color) {
        //calls parent class constructor
        super(x, y, width, height, color);
    }

    //this getter is an implementation of the GameShape getModel() abstract method that returns an Ellipse Shape of the object of the class
    @Override
    public Shape getModel() {
        return new Ellipse2D.Double(getXPosition(), getYPosition(), getWidth(), getHeight());
    }
}
