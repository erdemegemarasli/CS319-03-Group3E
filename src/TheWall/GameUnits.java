package TheWall;

import java.awt.*;
/*
Creator: Ayca Begum Tascioglu
 */

abstract class GameUnits extends GameObject{
    int radius;
    boolean isEnemy;
    public GameUnits(int x, int y,int radius,boolean isEnemy){
        super(x, y);
        this.radius = radius;
        this.isEnemy = isEnemy;
    }

    @Override
    public void draw(Graphics g) {
        if(isEnemy) {
            g.setColor(Color.RED);
            g.fillOval(this.getX(), this.getY(), radius, radius);
        }
        else{
            g.setColor(Color.BLUE);
            g.fillOval(this.getX() , this.getY() , radius, radius);
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
