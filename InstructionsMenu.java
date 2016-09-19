

import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 22, 2011
 * Time: 11:36:07 AM
 * To change this template use File | Settings | File Templates.
 */
public class InstructionsMenu {

    private String[] texts;

    private Font font;

    public InstructionsMenu(){

        texts = new String[6];

        texts[0] = " You are the red square. Avoid the blue circles and collect the";

        texts[1] = " yellow circles. Once you have collected all of the yellow ";

        texts[2] = " circles, move to the green beacon to complete the level. ";

        texts[3] = " Some levels consist of more than one beacon; the ";

        texts[4] = " intermediary beacons act as check points. ";

        texts[5] = " GOOD LUCK AND ENJOY! ";

        font = new Font("Castellar", Font.PLAIN, 20);

    }

    private void drawBackGround(Graphics g){

        g.setColor(Color.WHITE);

        g.fillRect(0 , 0 , 1000 , 1000);

    }

    private void drawTexts(Graphics g){

        g.setColor(Color.BLACK);

        g.setFont(font);

        for (int i = 0 ; i < texts.length ; i++)

            g.drawString(texts[i], 0,  25 + i * 50);

    }

    public void draw(Graphics g) {

        drawBackGround(g);

        drawTexts(g);

    }
}
