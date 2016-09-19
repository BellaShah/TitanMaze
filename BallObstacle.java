

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: axa0562
 * Date: May 11, 2011
 * Time: 10:41:28 AM
 * To change this template use File | Settings | File Templates.
 */

/*BallObstacle is an extension of the BallShape which is an extension of the abstract class GameShape
  All classes implement GameConstants except GameLauncher
  Runnable is implemented by all objects
  This class will be the most used class for building obstacles in the game
 */
public abstract class BallObstacle extends BallShape implements GameConstants, Runnable {

    //The border around the obstacle
    private BallShape ballFrame;

    //X location that the object will go from
    private double X1;

    //Y location that the object will go from
    private double Y1;

    //X location that the object will go to
    private double X2;

    //Y location that the object will go to
    private double Y2;

    //speed of the object
    private double velocity;

    //if moveLeft is true than the object moves left
    private boolean moveLeft;

    //if moveRight is true than the object will move right
    private boolean moveRight;

    //if moveUp is true than the object will move up
    private boolean moveUp;

    //if moveDown is true than the object will go down
    private boolean moveDown;

   //constructor for rotating obstacles
   public BallObstacle(double x, double y, double speed, Color mainColor , Color frameColor){

       //call parent constructor to set the main data of the Shape
       super(x , y , obstacleSize_small, obstacleSize_small, mainColor);

       //setting the ballFrame
       ballFrame = new BallShape(x - obstacleFrameDistance * 2,
                y - obstacleFrameDistance * 2,
                obstacleSize_small + obstacleFrameDistance * 2,
                obstacleSize_small + obstacleFrameDistance * 2,
                frameColor);

       //setting the speed;
       velocity = speed;

   }

    //constructor for moving obstacles
    public BallObstacle(double x, double y, double start, double end, double speed, Color mainColor , Color frameColor) {

        //call parent constructor to set the main data of the Shape
        super(x, y, obstacleSize_small, obstacleSize_small, mainColor);

        //setting the ballFrame
        ballFrame = new BallShape(x - obstacleFrameDistance,
                y - obstacleFrameDistance,
                obstacleSize_small + obstacleFrameDistance * 2,
                obstacleSize_small + obstacleFrameDistance * 2,
                frameColor);

        //setting the speed
        velocity = speed;

        //setting the points for the obstacle to move towards and from
        X1 = start;
        Y1 = start;
        X2 = end;
        Y2 = end;

        //setting which way does the obstacle start to move
        if (x < X2) {
            moveLeft = false;
            moveRight = true;
        } else {
            moveLeft = true;
            moveRight = false;
        }
        if (y < Y2) {
            moveUp = false;
            moveDown = true;
        } else {
            moveUp = true;
            moveDown = false;
        }

    }

    //sets the X position of the obstacle as well as the obstacle border
    public void setXPosition(double x) {
        super.setXPosition(x);
        ballFrame.setXPosition(x - obstacleFrameDistance);
    }

    //sets the Y position of the obstacle as well as the obstacle border
    public void setYPosition(double y) {
        super.setYPosition(y);
        ballFrame.setYPosition(y - obstacleFrameDistance);
    }

    //this method moves the obstacle horizontally
    public void moveHorizontal() {

        /*this checks if the obstacle arrived at his rightMost position and is moving that way
        * if it does, than it will reset and change moving direction to left by setting the
        * moveLeft boolean to true and moveRight boolean to false*/
        if (getXPosition() >= X2 && moveRight) {
            moveLeft = true;
            moveRight = false;
        }

        /*this checks if the obstacle arrived at his leftMost position and is moving that way
        * if it does, than it will reset and change moving direction to right by setting the
        * moveLeft boolean to false and moveRight boolean to true*/
        if (getXPosition() <= X1 && moveLeft) {
            moveLeft = false;
            moveRight = true;
        }

        //self explanatory
        if (moveLeft)
            moveLeft();
        if (moveRight)
            moveRight();

    }

    //this method moves the obstacle vertically
    public void moveVertical() {

        /*this checks if the obstacle arrived at his downMost position and is moving that way
        * if it does, than it will reset and change moving direction to up by setting the
        * moveUP boolean to true and moveDown boolean to false*/
        if (getYPosition() >= Y2 && moveDown) {
            moveUp = true;
            moveDown = false;
        }

        /*this checks if the obstacle arrived at his upMost position and is moving that way
        * if it does, than it will reset and change moving direction to down by setting the
        * moveUP boolean to false and moveDown boolean to true*/
        if (getYPosition() <= Y1 && moveUp) {
            moveUp = false;
            moveDown = true;
        }

        //self explanatory
        if (moveUp)
            moveUp();
        if (moveDown)
            moveDown();

    }

    /*
    this draws the basics or only the shape of the obstacle
     it can be called by subclasses or even be overriden in the subclasses
     */
    public void draw(Graphics g) {

        /*
        we want to create 2D graphics for better performance
         g.create() will create a new reference so that we don't use the old one and create problems
         */

        Graphics2D g2d = (Graphics2D)g.create();

        //this makes graphics more smooth
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //set the Color and draw the object into the screen
        g2d.setColor(getColor());
        g2d.fill(getModel());

        //in order to not use too much memory, and because we don't need it any more, we will dispose the graphics object
        g2d.dispose();

    }

    //this draws the frame of the obstacle
    public void drawFrame(Graphics g){

        /*we want to create 2D graphics for better performance
         g.create() will create a new reference so that we don't use the old one and create problems */
        Graphics2D g2d = (Graphics2D) g.create();

        //this makes graphics more smooth
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //set the Color and draw the object frame into the screen
        g2d.setColor(ballFrame.getColor());
        g2d.fill(ballFrame.getModel());

        //in order to not use too much memory, and because we don't need it any more, we will dispose the graphics object
        g2d.dispose();

    }

    //this method moves the obstacle left by decreasing the value of the x position of the obstacle
    private void moveLeft() {
        setXPosition(getXPosition() - velocity);
    }

    //this method moves the obstacle left by increasing the value of the x position of the obstacle
    private void moveRight() {
        setXPosition(getXPosition() + velocity);
    }

   //this method moves the obstacle up by decreasing the value of the y position of the obstacle
    private void moveUp() {
        setYPosition(getYPosition() - velocity);
    }

    //this method moves the obstacle down by increasing the value of the y position of the obstacle
    private void moveDown() {
        setYPosition(getYPosition() + velocity);
    }

    //a getter that returns the border or the frame around the obstacle
    public GameShape getFrame(){
        return ballFrame ;
    }

    //a getter that returns the speed of the obstacle
    public double getSpeed(){
        return velocity ;
    }

    /*this is the abstract method move, particular to the BallObstacle class.
    It is abstract because of the different implementations that might be made by classes like RotatingBallObstacle
     */
    public abstract void move();

     /*this is the abstract method run of the Runnable interface, also known as the thread runner
     It is abstract because of the different implementations that might be made by the subclasses
     */
    public abstract void run();

}
