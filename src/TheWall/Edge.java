package TheWall;

import java.awt.*;
/*
Creator: Erdem Ege Marasli
 */
public class Edge extends GameBoardComponent {
    public Edge(int x,int y, int width, int height){
        super(x,y,width,height);
    }
    public void draw(Graphics g)
    {

        g.setColor(Color.BLACK);
        g.fillRect(getX(),getY(),getWidth(),getHeight());
    }
}
