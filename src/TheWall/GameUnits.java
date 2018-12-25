package TheWall;

import javax.swing.*;
import java.awt.*;
import java.io.File;
/**
Creator: Ayca Begum Tascioglu
 Contains basic information for the GameUnits
 */

abstract class GameUnits extends GameObject{
    int radius;
    boolean isEnemy;

    /**
     ImageIcons to used to draw a game unit
     */
    ImageIcon harry = new ImageIcon("src/TheWall/images/harry.jpg");
    ImageIcon voldemort = new ImageIcon("src/TheWall/images/voldemort.jpg");
    ImageIcon hermione = new ImageIcon("src/TheWall/images/hermione.jpg");
    ImageIcon ron = new ImageIcon("src/TheWall/images/ron.jpg");


    ImageIcon arya = new ImageIcon("src/TheWall/images/arya.jpg");
    ImageIcon cersei = new ImageIcon("src/TheWall/images/nightking.jpg");
    ImageIcon jon = new ImageIcon("src/TheWall/images/jon.jpg");
    ImageIcon khaleesi = new ImageIcon("src/TheWall/images/khaleesi.jpg");
    //ImageIcon nightKing = new ImageIcon("src/TheWall/images/khaleesi.jpgg");


    int theme;
    boolean isCastle = false;   //a boolean flag to decide if the game unit is a blue knight or a castle
    int info = 0;
    boolean isHorizontalCastle;
    int fixedX;
    int fixedY;
    int indexNo;
    boolean isPlaced;

    /**
     * GameUnit constructor to construct a game unit such as knights and castle
     * @param x : int - the x coordinate of a game unit
     * @param y : int - the y coordinate of a game unit
     * @param radius : int the radius of a game unit
     * @param isEnemy : boolean a flag to understand if the knight is an enemy knight(red knight) or not(blue knight)
     * @param theme : int an ID to decide if the theme (HarryPotter or GameOfThrones) character will be presented on the game units or not(default)
     */
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
        return getX() + radius / 2;

    }
    public int getMidY(){
        return getY() + radius / 2;

    }
    /*
    This method controls if the given point is in that game object
    Note: If you are going to use this method for a isCastle == true object,
    since castle froms from 2 seperate pieces use the first piece of the castle
    For example GameUnit [] castle = new GameUnit[2] After initializes
    call castle[0].isContainMouse(x,y) Do no call castle[1].isContainMouse(x,y)
     */
    public boolean isContainMouse(int contX, int contY) {
        if(!isCastle){
            if (contX >= this.getX() && contX <= (this.getX()) + (this.getRadius()) &&
                    contY >= this.getY() && contY <= (this.getY()) + (this.getRadius())) {
                return true;
            }
        }
        else{
            if(isHorizontalCastle){
                if (contX >= this.getX() && contX <= (this.getX()) + 2 *(this.getRadius()) + 40 &&
                        contY >= this.getY() && contY <= (this.getY()) + (this.getRadius())) {
                    return true;
                }
            }
            else{
                if (contX >= this.getX() && contX <= (this.getX()) + (this.getRadius()) &&
                        contY >= this.getY() && contY <= (this.getY()) + 2 * (this.getRadius()) + 40) {
                    return true;
                }

            }
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
