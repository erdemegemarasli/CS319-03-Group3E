package TheWall;

import java.awt.*;

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
            g.fillOval(this.getX() - (radius / 2), this.getY() - (radius / 2), radius, radius);
        }
        else{
            g.setColor(Color.BLUE);
            g.fillOval(this.getX() - (radius / 2), this.getY() - (radius / 2), radius, radius);
        }
    }
}
