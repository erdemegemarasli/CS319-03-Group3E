package TheWall;

import java.awt.*;
import java.util.ArrayList;

public class Wall implements Moveable, Drawable{
    WallEdge[] wallEdges;
    WallLine[] wallLines;
    public Wall(WallEdge[] wallEdges, WallLine[] wallLines){
        this.wallEdges = wallEdges;
        this.wallLines = wallLines;
    }

    public void setWallEdges(WallEdge[] wallEdges) {
        this.wallEdges = wallEdges;
    }

    public void setWallLines(WallLine[] wallLines) {
        this.wallLines = wallLines;
    }

    public WallEdge[] getWallEdges() {
        return wallEdges;
    }

    public WallLine[] getWallLines() {
        return wallLines;
    }

    @Override
    public void setX(int x) {

    }

    @Override
    public void setY(int y) {

    }

    @Override
    public int getY() {
        return 0;
    }

    @Override
    public int getX() {
        return 0;
    }
    public void draw(Graphics g) {
        for(int i = 0; i < wallLines.length; i++)
            wallLines[i].draw(g);
        if(wallEdges != null){
            for(int i = 0; i < wallEdges.length; i++)
                wallEdges[i].draw(g);
        }

    }
}
