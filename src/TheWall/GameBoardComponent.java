package TheWall;

import java.awt.*;
import java.util.ArrayList;
/**
Creator: Erdem Ege Marasli
 Contains basic same information for Components of game board.
 */
abstract class GameBoardComponent implements Drawable
{
    private int x;
    private int y;
    private int width;
    private int height;
    private int info;
    public GameBoardComponent(int x,int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        info = 0;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    //method for setting the location y
    public void setY(int y)
    {
        this.y = y;
    }
    //getter for x
    public int getX()
    {
        return x;
    }
    //getter for y
    public int getY()
    {
        return y;
    }
    public int getWidth()
    {
        return width;
    }
    //getter for height
    public int getHeight()
    {
        return height;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }
    public boolean isContainPoint(int contX, int contY)
    {
        if(contX >= this.getX() && contX <= (this.getX() ) + (this.getWidth() ) &&
                contY >= this.getY() && contY <= (this.getY() ) + (this.getHeight() ) ) {
            return true;
        }
        return false;
    }
}
