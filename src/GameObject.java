package TheWall;

import javax.swing.*;
import java.awt.*;

abstract class GameObject implements Moveable, Drawable{

    private int x;
    private int y;
    public GameObject(int x, int y){
        setX(x);
        setY(y);
    }

    //method for setting the location x
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
}
