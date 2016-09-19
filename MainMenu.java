
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 20, 2011
 * Time: 6:22:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class MainMenu implements GameConstants {

    private AbstractLevel backGroundLevel;

    private InstructionsMenu instructionsMenu ;

    private CreditsMenu creditsMenu;

    private Tab tabs[];

    private Tab backTab ;

    private MouseEvent mouseMoved ;

    private MouseEvent mouseClicked ;

    private int windowWidth;

    private int windowHeight;

    private boolean creditsMenuOpened ;

    private boolean instructionsMenuOpened ;

    private boolean backTabClicked ;


    public MainMenu(int width, int height) {

        backGroundLevel = new Level1();

        instructionsMenu = new InstructionsMenu();

        creditsMenu = new CreditsMenu(width, height);

        tabs = new Tab[3];

        tabs[0] = new Tab(width / 2 - Tab.getWidth() / 2 - 60, 200, "Start Game");

        tabs[1] = new Tab(width / 2 - Tab.getWidth() / 2, 400, "Instructions");

        tabs[2] = new Tab(width / 2 - Tab.getWidth() / 2, 600, "Credits");

        backTab = new Tab(width - 200, 75, "Go Back");

        windowWidth = width;

        windowHeight = height;

        creditsMenuOpened = false ;

        instructionsMenuOpened = false ;

        backTabClicked = true ;

    }

    public void traceMovingMouse(MouseEvent mouseMoved){
         this.mouseMoved = new MouseEvent(mouseMoved.getComponent(), mouseMoved.getID(), mouseMoved.getWhen(),
                 mouseMoved.getModifiers(), mouseMoved.getX(), mouseMoved.getY(),
                 mouseMoved.getClickCount(), mouseMoved.isPopupTrigger()) ;
    }

    public void traceClickingMouse(MouseEvent mouseClicked){
         this.mouseClicked = new MouseEvent(mouseClicked.getComponent(), mouseClicked.getID(), mouseClicked.getWhen(),
                 mouseClicked.getModifiers(), mouseClicked.getX(), mouseClicked.getY(),
                 mouseClicked.getClickCount(), mouseClicked.isPopupTrigger()) ;
    }

    public void setMouseValues(MouseEvent mouseMoved, MouseEvent mouseClicked){
        this.mouseMoved = mouseMoved ;
        this.mouseClicked = mouseClicked ;
    }

    private boolean isMouseOverTab(MouseEvent e, int tab) {
        return e.getX() >= tabs[tab].getXPosition() && e.getX() <= tabs[tab].getXPosition() + Tab.getWidth() &&
               e.getY() >= tabs[tab].getYPosition() && e.getY() <= tabs[tab].getYPosition() + Tab.getHeight();
    }

    private boolean isMouseOverBackTab(MouseEvent e) {
        return e.getX() >= backTab.getXPosition() && e.getX() <=  backTab.getXPosition() + Tab.getWidth() &&
               e.getY() >=  backTab.getYPosition() && e.getY() <=  backTab.getYPosition() + Tab.getHeight();
    }

    public boolean isGameStarted(){
        return isMouseOverTab(mouseClicked, 0);
    }

    private void drawTitle(Graphics g) {

        g.setColor(new Color(255, 255, 0));

        g.setFont(new Font("Castellar", Font.BOLD + Font.ITALIC, 75));

        FontMetrics fontMetrics = g.getFontMetrics();

        g.drawString("TITAN MAZE", windowWidth / 2 - fontMetrics.stringWidth("TITAN MAZE") / 2, 100);

    }

    private void drawTabs(MouseEvent mouseEvent, Graphics g) {

        g.setColor(new Color(0, 0, 0, 200));

        g.fillRect(0, 0, 1000, 1000);

        for (int t = 0; t < tabs.length; t++)
            tabs[t].draw(g, isMouseOverTab(mouseEvent, t));

    }

    public void draw(Graphics g) {

        if(isMouseOverBackTab(mouseClicked)){

            backTabClicked = true ;

            creditsMenuOpened = false ;

            instructionsMenuOpened = false ;

        }

        if(!creditsMenuOpened || backTabClicked || !instructionsMenuOpened){

          backGroundLevel.draw(g);

          drawTabs(mouseMoved, g);

          drawTitle(g);

        }

        if(isMouseOverTab(mouseClicked, 1) || instructionsMenuOpened){

           instructionsMenu.draw(g);

           instructionsMenuOpened = true ;

           backTabClicked = false ;

           backTab.draw(g,isMouseOverBackTab(mouseMoved));

        }

        if(isMouseOverTab(mouseClicked, 2) || creditsMenuOpened){

           creditsMenu.draw(g);

           creditsMenuOpened = true ;

           backTabClicked = false ;

           backTab.draw(g,isMouseOverBackTab(mouseMoved));

        }

    }

}
