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
    boolean isHorizontalCastle;
    int fixedX;
    int fixedY;
    int indexNo;
    boolean isPlaced;
    public GameUnits(int x, int y,int radius,boolean isEnemy, int theme){
        super(x, y);
        this.theme = theme;
        this.radius = radius;
        this.isEnemy = isEnemy;
        fixedX = x;
        fixedY = y;
        indexNo = -1;
        isPlaced = true;
    }
    public void setIsPlaced(boolean b){
        isPlaced = b;
    }
    public boolean isPlaced(){
        return isPlaced;
    }
    public boolean isEnemy(){
        return isEnemy;
    }
    public void setIndexNo(int index) {
        this.indexNo = index;
    }

    public int getIndexNo() {
        return indexNo;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setIsHorizontalCastle(boolean b){
        isHorizontalCastle = b;
    }
    public boolean isHorizontalCastle(){
        return isHorizontalCastle;
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
    public int getMidX(){
        if(!isCastle){
            return getX() + radius / 2;
        }
        else{
            if(isHorizontalCastle){
                return getX() + radius / 2 + 40;
            }
            else{
                return getX() + radius / 2;
            }
        }

    }
    public int getMidY(){
        if(!isCastle){
            return getY() + radius / 2;
        }
        else{
            if(isHorizontalCastle){
                return getY() + radius / 2;
            }
            else{
                return getY() + radius / 2 + 40;
            }
        }

    }
    public boolean isContainMouse(int contX, int contY) {
        if (contX >= this.getX() && contX <= (this.getX()) + (this.getRadius()) &&
                contY >= this.getY() && contY <= (this.getY()) + (this.getRadius())) {
            return true;
        }
        if(contX >= this.getX() && contX <= (this.getX() ) + (this.getRadius() ) &&
            contY >= this.getY() && contY <= (this.getY() ) + (this.getRadius() ) ) {
                return true;
            }
        return false;
    }


    public int getRadius() {
        return radius;
    } //

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
