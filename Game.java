
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: axa0562
 * Date: May 10, 2011
 * Time: 11:00:16 AM
 * To change this template use File | Settings | File Templates.
 */
public class Game extends JPanel implements MouseListener, MouseMotionListener, KeyListener, Runnable, GameConstants {

    private MainMenu gameMenu;

    private AbstractLevel level ;

    private ArrayList<AbstractLevel> levels ;

    private int currentLevel;

    private Player player;

    private boolean playerCommands[];

    private MouseEvent mouseMoved;

    private MouseEvent mouseClicked;


    public Game(int width, int height) {

        gameMenu = new MainMenu(width, height);

        gameMenu.setMouseValues(new MouseEvent(this, 50, 25, 40, 100, 100 , 0, false, 1), new MouseEvent(this, 50, 25, 40, 100, 100 , 0, false, 1)  );

        levels = new ArrayList<AbstractLevel>();
        currentLevel = 0 ;

        levels.add(new Level1());
        levels.add(new Level2());
        levels.add(new Level3());
        levels.add(new Level4());
        levels.add(new Level5());

        level = levels.get(0);

        player = new Player(0.5, level.getStartingZone());

        playerCommands = new boolean[10];

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);

        new Thread(this).start();

    }

    private boolean hasPlayerFinished() {
        return player.getNumberOfCoinsGrabbed() == level.getNumberOfCoins() && player.isInZone(level.getEndingZone());
    }

    public void paint(Graphics g) {

        super.paintComponent(g);

        if (!gameMenu.isGameStarted())

            gameMenu.draw(g);

        else {

            level.setPlayerDeaths(player.getNumberOfDeaths());

            level.draw(g);

            player.draw(g);

            player.setDirections(playerCommands);

            player.runLevel(level);

        }

    }

    private void runPlayerCommands(KeyEvent e, boolean switchValue) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                playerCommands[0] = switchValue;
                break;
            case KeyEvent.VK_LEFT:
                playerCommands[1] = switchValue;
                break;
            case KeyEvent.VK_DOWN:
                playerCommands[2] = switchValue;
                break;
            case KeyEvent.VK_RIGHT:
                playerCommands[3] = switchValue;
                break;
        }
    }

    public void keyTyped(KeyEvent e) {
        runPlayerCommands(e, true);
        switch(e.getKeyCode()) {
              case KeyEvent.VK_0 : currentLevel = 0 ;break ;
              case KeyEvent.VK_1 : currentLevel = 1 ;break ;
              case KeyEvent.VK_2 : currentLevel = 2 ; break ;
              case KeyEvent.VK_3 : currentLevel = 3 ; break ;
              case KeyEvent.VK_4 : currentLevel = 4 ; break ;
        }
    }

    public void keyPressed(KeyEvent e) {
        runPlayerCommands(e, true);
    }

    public void keyReleased(KeyEvent e) {
        runPlayerCommands(e, false);
    }

    public void mouseClicked(MouseEvent e) {
       if(!gameMenu.isGameStarted())
        gameMenu.traceClickingMouse(e);
    }

    public void mousePressed(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void mouseReleased(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void mouseEntered(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void mouseExited(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void mouseDragged(MouseEvent e) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void mouseMoved(MouseEvent e) {
       if(!gameMenu.isGameStarted())
        gameMenu.traceMovingMouse(e);
    }

    public void run() {

        while (true) {

            if (hasPlayerFinished()) {
                currentLevel++;
                if(currentLevel >= levels.size())
                   currentLevel = 0 ;
                level = levels.get(currentLevel);

                player = new Player(0.5, level.getStartingZone());

            }

            level.run();

            player.run();

            repaint();

            try {

                Thread.sleep(5);

            }
            catch (InterruptedException e) {

                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.

            }

        }
    }
}
