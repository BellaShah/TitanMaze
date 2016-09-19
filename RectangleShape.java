

import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by IntelliJ IDEA.
 * User: axa0562
 * Date: May 10, 2011
 * Time: 10:58:13 AM
 * To change this template use File | Settings | File Templates.
 */
public class RectangleShape extends GameShape {

    //constructor
    public RectangleShape(double x, double y, double width, double height, Color color) {
         //calls parent class constructor
        super(x, y, width, height, color);
    }

    //implementation of the getModel() method, in our case, as the class is, the getter will return a Rectangle
    @Override
    public Shape getModel() {
        return new Rectangle2D.Double(getXPosition(), getYPosition(), getWidth(), getHeight());
    }
}
