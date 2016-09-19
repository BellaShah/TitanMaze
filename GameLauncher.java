

import javax.swing.*;

/**
 * Created by IntelliJ IDEA.
 * User: axa0562
 * Date: May 10, 2011
 * Time: 11:00:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class GameLauncher extends JFrame {

    private static void createAndShowGUI() {

        final int WIDTH = 1000;
        final int HEIGHT = 800;

        JFrame frame = new JFrame("Titan Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new Game(WIDTH, HEIGHT);
        newContentPane.setOpaque(true);
        frame.setContentPane(newContentPane);

        frame.setSize(WIDTH, HEIGHT);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }


}
