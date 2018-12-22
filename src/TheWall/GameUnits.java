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
    ImageIcon hermione = new ImageIcon("src/TheWall/images/hermione.jpg");
    ImageIcon ron = new ImageIcon("src/TheWall/images/ron.jpg");


    ImageIcon arya = new ImageIcon("src/TheWall/images/arya.jpg");
    ImageIcon cersei = new ImageIcon("src/TheWall/images/cersei.jpg");
    ImageIcon jon = new ImageIcon("src/TheWall/images/jon.jpg");
    ImageIcon khaleesi = new ImageIcon("src/TheWall/images/khaleesi.jpg");


    int theme;
    boolean isCastle = false;
    int info = 0;
    public GameUnits(int x, int y,int radius,boolean isEnemy, int theme){
        super(x, y);
        this.theme = theme;
        this.radius = radius;
        this.isEnemy = isEnemy;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setIsCastle(boolean b){
        isCastle = b;
    }
    public boolean isCastle(){
        return isCastle;
    }
    @Override
    public void draw(Graphics g) {
         if(theme == 1){
            if(isEnemy) {
                voldemort.paintIcon(null, g, this.getX(), this.getY());
            }
            else if(isCastle){
                g.setColor(Color.BLUE);
                g.fillOval(this.getX() , this.getY() , radius, radius);
            }
            else{
                if(info == 0)
                    harry.paintIcon(null, g, this.getX(), this.getY());
                else if(info == 1)
                    ron.paintIcon(null,g,this.getX(),this.getY());
                else if(info == 2)
                    hermione.paintIcon(null,g,this.getX(),this.getY());
            }
        }

        else if(theme == 2){
            if(isEnemy) {
                cersei.paintIcon(null, g, this.getX(), this.getY());
            }
            else if(isCastle){
                g.setColor(Color.BLUE);
                g.fillOval(this.getX() , this.getY() , radius, radius);
            }
            else{
                if(info == 0)
                    jon.paintIcon(null, g, this.getX(), this.getY());
                else if(info == 1)
                    arya.paintIcon(null,g,this.getX(),this.getY());
                else if(info == 2)
                    khaleesi.paintIcon(null,g,this.getX(),this.getY());
            }
        }
        else{
            if(isEnemy) {
                g.setColor(Color.RED);
                g.fillOval(this.getX(), this.getY(), radius, radius);
            }
            else{
                g.setColor(Color.BLUE);
                g.fillOval(this.getX() , this.getY() , radius, radius);
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
