

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: Adrian
 * Date: May 11, 2011
 * Time: 8:18:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class Map {
    private ArrayList<ContestZone> contestZones;
    private ArrayList<SafeZone> safeZones;
    private ArrayList<BlockZone> blockZones;
    private ArrayList<BlockZone> bounds;
    private SafeZone startingZone;
    private SafeZone endingZone;

    public Map() {
        contestZones = new ArrayList<ContestZone>();
        safeZones = new ArrayList<SafeZone>();
        blockZones = new ArrayList<BlockZone>();
        bounds = new ArrayList<BlockZone>();
    }

    public void setStartingZone(int row, int column, int rows, int columns) {
        startingZone = new SafeZone(row, column, rows, columns);
    }

    public void setEndingZone(int row, int column, int rows, int columns) {
        endingZone = new SafeZone(row, column, rows, columns);
    }

    public void addContestZone(int row, int column, int rows, int columns) {
        contestZones.add(new ContestZone(row, column, rows, columns));
    }

    public void addSafeZone(int row, int column, int rows, int columns) {
        safeZones.add(new SafeZone(row, column, rows, columns));
    }

    public void addBlockZone(int row, int column, int rows, int columns) {
        blockZones.add(new BlockZone(row, column, rows, columns));
    }

    public void draw(Graphics g) {
        drawZones(g);
    }

    private void drawZones(Graphics g) {
        for (ContestZone contestZone : contestZones) contestZone.draw(g);
        for (SafeZone safeZone : safeZones) safeZone.draw(g);
        for (BlockZone blockZone : blockZones) blockZone.draw(g);
        startingZone.draw(g);
        endingZone.draw(g);
    }

    public SafeZone getStartingZone() {
        return startingZone;
    }

    public SafeZone getEndingZone() {
        return endingZone;
    }

    public SafeZone getSafeZone(int zone) {
        for (int z = 0; z < safeZones.size(); z++)
            if (zone == z)
                return safeZones.get(z);
        return null;
    }

    public ContestZone getContestZone(int zone) {
        for (int z = 0; z < contestZones.size(); z++)
            if (zone == z)
                return contestZones.get(z);
        return null;
    }

    public ArrayList<BlockZone> getBlockZones() {
        return blockZones ;
    }

    public ArrayList<ContestZone> getContestZones() {
        return contestZones;
    }

    public ArrayList<SafeZone> getSafeZones(){
        return safeZones;
    }

    public ArrayList<BlockZone> getBounds(int index){
        return contestZones.get(index).getBounds();
    }
}
