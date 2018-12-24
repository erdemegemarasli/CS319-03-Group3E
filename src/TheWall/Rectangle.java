package TheWall;

import java.awt.*;
/**
Creator: Erdem Ege Marasli
 Contains the information for rectangle class
 */
public class Rectangle extends GameBoardComponent {
    public Rectangle(int x,int y, int width, int height){
        super(x,y,width,height);
    }
    public void draw(Graphics g)
    {

        g.setColor(Color.BLACK);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
