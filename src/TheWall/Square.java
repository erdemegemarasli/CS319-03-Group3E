package TheWall;

import java.awt.*;
/*
Creator: Erdem Ege Marasli
 */

public class Square extends GameBoardComponent{
    public Square(int x,int y, int width, int height){
        super(x,y,width,height);
    }
    public void draw(Graphics g)
    {
        g.setColor(Color.WHITE);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
