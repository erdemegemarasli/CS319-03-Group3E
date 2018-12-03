package TheWall;

import java.awt.*;
import java.util.ArrayList;
/*
Creator: Ayca Begum Tascioglu
 */

public class Wall implements Moveable, Drawable{
    WallEdge[] wallEdges;
    WallLine[] wallLines;

    int initialPositionX;
    int initialPositionY;

    int midPointX;
    int midPointY;

    int wallNumber;

    boolean isMoving;

    public Wall(WallEdge[] wallEdges, WallLine[] wallLines,int wallNumber)
    {
        this.wallEdges = wallEdges;
        this.wallLines = wallLines;
        this.wallNumber = wallNumber;
        isMoving = false;
    }


    /*
    SETTERS
     */

    public void setWallNumber(int wallNumber) {
        this.wallNumber = wallNumber;
    }

    public void setMidPointX(int midPointX) {
        this.midPointX = midPointX;
    }

    public void setMidPointY(int midPointY) {
        this.midPointY = midPointY;
    }

    public void setInitialPositionX(int initialPositionX) {
        this.initialPositionX = initialPositionX;
    }

    public void setInitialPositionY(int initialPositionY) {
        this.initialPositionY = initialPositionY;
    }

    public void setWallEdges(WallEdge[] wallEdges) {
        this.wallEdges = wallEdges;
    }

    public void setWallLines(WallLine[] wallLines) {
        this.wallLines = wallLines;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    /*
        rotates the wall 90 degrees in Clockwise
         */
    public void rotate(){
        int tmpX =0;
        int tmpY = 0;
        int tmpHeight =0;
        int tmpWidth = 0;
        int negativeX =0;

        for(int i = 0; i < wallLines.length; i++){
            tmpX = wallLines[i].getX() ;
            tmpY = wallLines[i].getY() ;
            tmpWidth = wallLines[i].getWidth();
            tmpHeight = wallLines[i].getHeight();

            int sin = 1;
            int cos = 0;
            int pX = tmpX - initialPositionX;
            int pY = tmpY - initialPositionY;
            wallLines[i].setX(pX);
            wallLines[i].setY( pY ) ;

            int xNew = pX*cos - pY*sin;
            int yNew = pX*sin + pY*cos;
            wallLines[i].setX(xNew+initialPositionX - tmpWidth +tmpHeight);
            wallLines[i].setY( yNew+ initialPositionY) ;
            wallLines[i].setHeight(tmpWidth);
            wallLines[i].setWidth(tmpHeight);
        }

        tmpX =0;
        tmpY = 0;


        for(int i = 0; i < wallEdges.length; i++){
            tmpX = wallEdges[i].getX() ;
            tmpY = wallEdges[i].getY() ;

            int sin = 1;
            int cos = 0;
            int pX = tmpX - initialPositionX;
            int pY = tmpY - initialPositionY;
            wallEdges[i].setX(pX);
            wallEdges[i].setY( pY ) ;

            int xNew = pX*cos - pY*sin;
            int yNew = pX*sin + pY*cos;
            wallEdges[i].setX(xNew+initialPositionX);
            wallEdges[i].setY( yNew+ initialPositionY) ;
        }

    }

    public boolean isContainMouse(int contX, int contY)
    {
        for(int i = 0; i < wallLines.length; i++){
            if(contX >= wallLines[i].getX() && contX <= (wallLines[i].getX() ) + (wallLines[i].getWidth() ) &&
                    contY >= wallLines[i].getY() && contY <= (wallLines[i].getY() ) + (wallLines[i].getHeight() ) ) {
                return true;
            }
        }
        for(int i = 0; i < wallEdges.length; i++){
            if(contX >= wallEdges[i].getX() && contX <= (wallEdges[i].getX() ) + (wallEdges[i].getRadius() ) &&
                    contY >= wallEdges[i].getY() && contY <= (wallEdges[i].getY() ) + (wallEdges[i].getRadius() ) ) {
                return true;
            }
        }
        return false;
    }


    /*
    GETTERS
     */

    public int getWallNumber() {
        return wallNumber;
    }

    public int getMidPointX() {
        return midPointX;
    }

    public int getMidPointY() {
        return midPointY;
    }

    public int getInitialPositionY() {
        return initialPositionY;
    }

    public int getInitialPositionX() {
        return initialPositionX;
    }

    public WallEdge[] getWallEdges() {
        return wallEdges;
    }

    public WallLine[] getWallLines() {
        return wallLines;
    }

    @Override
    public void setX(int x) {
        int temp = x - midPointX;
        for(int i = 0; i < wallLines.length; i++)
            wallLines[i].setX((wallLines[i].getX() + temp));
        if(wallEdges != null){
            for(int i = 0; i < wallEdges.length; i++)
                wallEdges[i].setX((wallEdges[i].getX() + temp));
        }
        setMidPointX(x);
    }

    @Override
    public void setY(int y) {
        int temp = y - midPointY;
        for(int i = 0; i < wallLines.length; i++)
            wallLines[i].setY((wallLines[i].getY() + temp));
        if(wallEdges != null){
            for(int i = 0; i < wallEdges.length; i++)
                wallEdges[i].setY((wallEdges[i].getY() + temp));
        }
        setMidPointY(y);
    }

    @Override
    public int getY() {
        return midPointY;
    }

    @Override
    public int getX() {
        return midPointY;
    }
    public void draw(Graphics g) {
        for(int i = 0; i < wallLines.length; i++)
            wallLines[i].draw(g);
        if(wallEdges != null){
            for(int i = 0; i < wallEdges.length; i++)
                wallEdges[i].draw(g);
        }

    }

    public boolean isMoving() {
        return isMoving;
    }
}
