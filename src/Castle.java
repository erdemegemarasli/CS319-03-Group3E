package TheWall;

import java.awt.*;

public class Castle extends GameObject{
    int radius;
    public Castle(int x, int y,int radius){
        super(x,y);
        this.radius = radius;
    }

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(getX()+(radius/2),getY(),radius-(radius/2), radius);
        g.setColor(Color.BLACK);
        g.drawRect(getX()+(radius/2),getY(),radius-(radius/2), radius);

        g.setColor(Color.BLUE);
        g.fillOval(getX(),getY(),radius, radius);
        g.setColor(Color.BLACK);
        g.drawOval(getX(),getY(),radius, radius);

        g.setColor(Color.BLUE);
        g.fillOval(getX()+radius,getY(),radius, radius);
        g.setColor(Color.BLACK);
        g.drawOval(getX()+radius,getY(),radius, radius);
    }
}
