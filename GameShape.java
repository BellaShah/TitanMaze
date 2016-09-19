

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: axa0562
 * Date: May 10, 2011
 * Time: 10:51:52 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class GameShape {

    //x position on the screen of the Shape
    private double xPosition;

    //y position on the screen of the Shape
    private double yPosition;

    //the width of the Shape
    private double width;

    //the height of the Shape
    private double height;

    //color of the Shape
    private Color color;

    //base and main constructor for all future subclasses
    public GameShape(double x, double y, double width, double height, Color color) {

        //this sets the x position of the shape to x
        xPosition = x;

        //this sets the y position of the shape to y
        yPosition = y;

        //this sets the width of the shape to the width parameter
        this.width = width;

        //this sets the height of the shape to the height parameter
        this.height = height;

        //this sets the color of the shape to the color parameter
        this.color = color;

    }

    //this method sets the x position on the screen of the shape to x
    public void setXPosition(double x) {
        xPosition = x;
    }

    //this method sets the y position on the screen of the shape to y
    public void setYPosition(double y) {
        yPosition = y;
    }

    //this getter returns the x position on the screen of the shape
    public double getXPosition() {
        return xPosition;
    }

    //this getter returns the y position on the screen of the shape
    public double getYPosition() {
        return yPosition;
    }

    //this getter returns the width value of the shape
    public double getWidth() {
        return width;
    }

    //this getter returns the height value of the shape
    public double getHeight() {
        return height;
    }

    //this getter returns the color of the shape
    public Color getColor() {
        return color;
    }

    //this is an abstract method for the subclasses to implement so that they return different shapes like rectangles or ellipses
    public abstract Shape getModel();


}
