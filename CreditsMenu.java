
import java.awt.*;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 21, 2011
 * Time: 5:14:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class CreditsMenu {

    private String[] texts;

    private Font font;

    private double x;

    private double y[];

    public CreditsMenu(int width, int height) {

        texts = new String[10];

        texts[0] = " Credits To : ";

        texts[1] = " Bella Shah - Developer, Documentation & Level builder ";

        texts[2] = " Sanjani Prodduturu - Developer, Documentation & Level builder ";

        texts[3] = " Adrian Armaselu - Chief Developer, Programmer & Debugger(the crazy genius dude)";

        texts[4] = " Shakil Huq - Developer, Tester & Level builder(the other crazy genius dude) ";

        texts[5] = " Mrs. Jan McClintock - Teacher, Conductor & Supporter ";

        texts[6] = " Intellij IDEA 9.0.2 - THE BEST TOOL TO BUILD JAVA PROGRAMS EVER ";

        texts[7] = " Java - Without It We Would Still Be In Stone Age ";

        texts[8] = " Titan Maze, An End of Year Project Game of the 2011 AP Computer Science Class ";

        texts[9] = " Made at Coppell High School ";

        font = new Font("Castellar", Font.PLAIN, 15);

        x = 50;

        y = new double[10];

        for (int i = 0; i < y.length; i++)

            y[i] = height + i * 100;

    }

    private void drawBackGround(Graphics g){

        g.setColor(Color.WHITE);

        g.fillRect(0 , 0 , 1000 , 1000);

    }

    private void drawTexts(Graphics g){

        g.setColor(Color.BLACK);

        g.setFont(font);

        for (int i = 0; i < texts.length; i++) {

            g.drawString(texts[i], (int)x, (int) y[i]);

            y[i] -= 0.50;

        }

    }

    public void draw(Graphics g) {

        drawBackGround(g);

        drawTexts(g);

    }
}
