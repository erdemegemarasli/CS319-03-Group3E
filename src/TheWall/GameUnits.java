package TheWall;

import javax.swing.*;
import java.awt.*;
import java.io.File;
/*
Creator: Ayca Begum Tascioglu
 */

abstract class GameUnits extends GameObject{
    int radius;
    boolean isEnemy;
    ImageIcon harry = new ImageIcon("src/TheWall/images/harry.jpg");
    ImageIcon voldemort = new ImageIcon("src/TheWall/images/voldemort.jpg");
    int theme;
    public GameUnits(int x, int y,int radius,boolean isEnemy, int theme){
        super(x, y);
        this.theme = theme;
        this.radius = radius;
        this.isEnemy = isEnemy;
    }

    @Override
    public void draw(Graphics g) {
        if (theme == 0) {
            if(isEnemy) {
                g.setColor(Color.RED);
                g.fillOval(this.getX(), this.getY(), radius, radius);
            }
            else{
                g.setColor(Color.BLUE);
                g.fillOval(this.getX() , this.getY() , radius, radius);
            }
        }
        else if(theme == 1){
            if(isEnemy) {
                /*
                g.setColor(Color.RED);
                g.fillOval(this.getX(), this.getY(), radius, radius);
                */
                voldemort.paintIcon(null, g, this.getX(), this.getY());
            }
            else{
                harry.paintIcon(null, g, this.getX(), this.getY());
            }
        }

    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
