package TheWall;

import java.awt.*;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
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
            AffineTransform transform = new AffineTransform();
            Rectangle newRec = new Rectangle(wallLines[i].getX(),wallLines[i].getY(), wallLines[i].getWidth(), wallLines[i].getHeight());
            transform.rotate(Math.toRadians(90),  midPointX, midPointY);
            Shape transformed = transform.createTransformedShape(newRec);
            //System.out.println((int)(transformed.getBounds().getX()));
            wallLines[i].setX((int)(transformed.getBounds().getX()));
            wallLines[i].setY((int)(transformed.getBounds().getY()));
            wallLines[i].setWidth((int)(transformed.getBounds().getWidth()));
            wallLines[i].setHeight((int)(transformed.getBounds().getHeight()));
        /*
            tmpX = wallLines[i].getX() ;
            tmpY = wallLines[i].getY() ;
            tmpWidth = wallLines[i].getWidth();
            tmpHeight = wallLines[i].getHeight();

            int sin = 1;
            int cos = 0;
            int pX = tmpX - midPointX;
            int pY = tmpY - midPointY;
            wallLines[i].setX(pX);
            wallLines[i].setY( pY ) ;

            int xNew = pX*cos - pY*sin;
            int yNew = pX*sin + pY*cos;
            wallLines[i].setX(xNew+midPointX - tmpWidth +tmpHeight);
            wallLines[i].setY( yNew+ midPointY) ;
            wallLines[i].setHeight(tmpWidth);
            wallLines[i].setWidth(tmpHeight);
            */
        }

        tmpX =0;
        tmpY = 0;


        for(int i = 0; i < wallEdges.length; i++){
            AffineTransform transform = new AffineTransform();
            Rectangle newRec = new Rectangle(wallEdges[i].getX(),wallEdges[i].getY(), wallEdges[i].getRadius(), wallEdges[i].getRadius());
            transform.rotate(Math.toRadians(90), midPointX, midPointY);
            Shape transformed = transform.createTransformedShape(newRec);
            wallEdges[i].setX((int)(transformed.getBounds().getX()));
            wallEdges[i].setY((int)(transformed.getBounds().getY()));
            wallEdges[i].setRadius((int)(transformed.getBounds().getWidth()));
            //wallEdges[i].setHeight((int)(transformed.getBounds().getHeight()));
            /*
            tmpX = wallEdges[i].getX() ;
            tmpY = wallEdges[i].getY() ;

            int sin = 1;
            int cos = 0;
            int pX = tmpX - midPointX;
            int pY = tmpY - midPointY;
            wallEdges[i].setX(pX);
            wallEdges[i].setY( pY ) ;

            int xNew = pX*cos - pY*sin;
            int yNew = pX*sin + pY*cos;
            wallEdges[i].setX(xNew+midPointX);
            wallEdges[i].setY( yNew+ midPointY) ;
            */
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