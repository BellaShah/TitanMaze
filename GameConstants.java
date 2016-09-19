
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 11, 2011
 * Time: 7:31:23 PM
 * To change this template use File | Settings | File Templates.
 */
public interface GameConstants {

    public final int startGame_Menu = 0;
    public final int credits_Menu = 1;

    public final int CENTER = 50;

    public final int NORTH = 90;
    public final int WEST = 180;
    public final int SOUTH = 270;
    public final int EAST = 0;

    public final int UP = 90;
    public final int LEFT = 180;
    public final int DOWN = 270;
    public final int RIGHT = 0;

    static final int obstacleSize_small = 10;
    static final int obstacleSize_medium = 10;
    static final int obstacleSize_large = 15;

    static final int coinSize = 10;

    static final int playerSize = 15;

    static final int obstacleFrameDistance = 3;
    static final int playerFrameDistance = 4;

    static final Color playerColor = Color.MAGENTA;

    static final Color playerFrameColor = Color.BLACK;

    static final Color tileColor1 = Color.CYAN;

    static final Color tileColor2 = Color.WHITE;

    static final Color borderColor = Color.DARK_GRAY;

    static final Color safeZoneColor = Color.GREEN;

    static final Color stringColor = Color.BLACK;

    static final Color frameColor = Color.BLACK;

    static final Color coinColor = new Color(255, 255, 0);

    static final int TILE_SIZE = 30;


}