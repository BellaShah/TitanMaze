

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 20, 2011
 * Time: 6:23:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tab {

    private String text ;

    private Font font ;

    private int xPosition ;

    private int yPosition ;

    private static int width ;

    private static int height ;

    public Tab(int x, int y, String string) {

        xPosition = x;

        yPosition = y;

        width = 125 ;

        height = 125 ;

        text = string;

        font = new Font("Castellar", Font.PLAIN, 15);

    }

    private void drawTabFrame(Graphics g){

        g.setColor(Color.BLACK);

        g.fillOval(xPosition - 20, yPosition - 20, width + 40, height + 40);

    }

    private void drawTab(Graphics g, boolean drawSpecialEffects) {

        if (drawSpecialEffects) g.setColor(new Color(0, 0, 255));

        else g.setColor(new Color(255, 255, 0));

        g.fillOval(xPosition, yPosition, width, height);

    }

    private void drawText(Graphics g) {

        g.setColor(Color.BLACK);

        g.setFont(font);

        FontMetrics fontMetrics = g.getFontMetrics();

        g.drawString(text, xPosition + width / 2 - fontMetrics.stringWidth(text) / 2, yPosition + height / 2);

    }

    private void drawSpecialEffect(Graphics g) {

        for (int i = 0; i < 255; i++) {

            if (255 - i * 2 >= 0) g.setColor(new Color(0, 255, 0, 255 - i * 2));

            g.drawRect(xPosition + width / 2 - i, yPosition + height / 2 - i, i * 2, i * 2);

        }

    }

    public void draw(Graphics g, boolean drawSpecialEffects) {

        if (drawSpecialEffects) drawSpecialEffect(g);

        drawTabFrame(g);

        drawTab(g, drawSpecialEffects);

        drawText(g);

    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }


}
