package TheWall;

import java.awt.*;
/**
Creator: Erdem Ege Marasli
 Contains information for edges
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
    public boolean isContainPoint(int contX, int contY)
    {
        if(contX >= this.getX() && contX <= (this.getX() ) + (this.getWidth() ) &&
                contY >= this.getY() && contY <= (this.getY() ) + (this.getHeight() ) ) {
            return true;
        }
        return false;
    }
}
