package TheWall;

import java.awt.*;
/**
Creator: Ayca Begum Tascioglu
 This class contains the attributes of the edge of wall. Wall is created from WallEdges and WallLines
 */

public class WallEdge extends GameObject {
    int radius;
    boolean isCastle;
    int middleX;
    int middleY;

    int fixedX;
    int fixedY;

    int indexNo;

    public static final Color BROWN = new Color(153,102,0);
    public static final Color light_yellow = new Color(255,255,204);
    public static final Color golden_yellow = new Color(255,204, 51);
    public static final Color GREEN = Color.GREEN;
    Color currentColor;
    public WallEdge(int x, int y,int radius, boolean isCastle, int fixedX, int fixedY){
        super(x, y);
        this.radius = radius;
        this.isCastle = isCastle;
        this.fixedX = fixedX;
        this.fixedY = fixedY;
        indexNo = -1;
        currentColor = golden_yellow;
    }
    @Override
    public void draw(Graphics g) {
        //g.setColor(Color.lightGray);
        //g.fillRect(this.getX(), this.getY(), radius, radius);
        //g.fillOval(this.getX(), this.getY(), radius, radius);
        if(isCastle)
        {
            g.setColor(light_yellow);
            g.fillOval(this.getX(), this.getY(), radius+10, radius+10);
            g.setColor(golden_yellow);
            g.drawOval(this.getX(), this.getY(), radius+10, radius+10);
        }
        else
        {
            g.setColor(currentColor);
            //g.fillOval(this.getX(), this.getY(), radius, radius);
            g.fillRect(this.getX(), this.getY(), radius, radius);
            //g.setColor(Color.BLUE);
            //g.drawOval(this.getX(), this.getY(), radius, radius);
        }
    }

    public boolean isCastle() {
        return isCastle;
    }


    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
        updateMiddlePoint();
    }

    public int getMiddleX() {
        return middleX;
    }

    public int getMiddleY() {
        return middleY;
    }

    public void updateMiddlePoint(){
        middleX = getX() + radius / 2;
        middleY = getY() + radius / 2;
    }
    public void makeGreen(boolean b){
        if(b == true)
            currentColor = GREEN;
        else{
            currentColor = golden_yellow;
        }
    }

    @Override
    public int getY() {
        return super.getY();
    }

    @Override
    public int getX() {
        return super.getX();
    }

    public int getIndexNo() {
        return indexNo;
    }

    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    public void setFixedY(int fixedY) {
        this.fixedY = fixedY;
    }

    public void setFixedX(int fixedX) {
        this.fixedX = fixedX;
    }

    public int getFixedY() {
        return fixedY;
    }

    public int getFixedX() {
        return fixedX;
    }

    @Override
    public void setX(int x) {
        super.setX(x);
        updateMiddlePoint();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
        updateMiddlePoint();
    }
}