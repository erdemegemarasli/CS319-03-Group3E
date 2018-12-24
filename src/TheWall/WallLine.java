package TheWall;

import java.awt.*;
/**
 Creator: Ayca Begum Tascioglu
 This class contains the attributes of the line of wall. Wall is created from WallEdges and WallLines
 */

public class WallLine  extends GameObject {
    int height, width;
    int middleX;
    int middleY;
    int fixedX;
    int fixedY;
    int indexNo;
    public static final Color BROWN = new Color(153,102,0);
    public static final Color golden_yellow = new Color(255,204, 51);
    public static final Color GREEN = Color.GREEN;
    Color currentColor;

    public WallLine(int x, int y, int width, int height, int fixedX, int fixedY) {
        super(x, y);
        currentColor = golden_yellow;
        this.height = height;
        this.width = width;
        this.fixedX = fixedX;
        this.fixedY = fixedY;
        this.indexNo = -1;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void makeGreen(boolean b){
        if(b == true)
            currentColor = GREEN;
        else{
            currentColor = golden_yellow;
        }
    }

    public void setHeight(int height) {
        this.height = height;
        updateMiddlePoint();
        updateMiddlePoint();
    }

    public void setWidth(int width) {
        this.width = width;
        updateMiddlePoint();
    }

    @Override
    public void setY(int y) {
        super.setY(y);
        updateMiddlePoint();
    }

    @Override
    public void setX(int x) {
        super.setX(x);
        updateMiddlePoint();
    }

    public void setFixedX(int fixedX) {
        this.fixedX = fixedX;
    }

    public void setFixedY(int fixedY) {
        this.fixedY = fixedY;
    }

    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    public int getIndexNo() {
        return indexNo;
    }

    public int getFixedX() {
        return fixedX;
    }

    public int getFixedY() {
        return fixedY;
    }

    public int getMiddleY() {
        return middleY;
    }

    public int getMiddleX() {
        return middleX;
    }

    public void updateMiddlePoint(){
        middleX = getX() + width / 2;
        middleY = getY() + height / 2;
    }
    @Override
    public void draw(Graphics g){
        g.setColor(currentColor);
        //g.draw3DRect(this.getX(),this.getY(),height,width,false);
        //g.setColor(Color.WHITE);
        g.fillRect(this.getX(),this.getY(),width,height);
        g.setPaintMode();

        //g.draw3DRect(this.getX(),this.getY(),height,width,true);
        //g.fillRoundRect(this.getX(),this.getY(),height,width,height-10,width-10);
        //g.drawRoundRect(this.getX(),this.getY(),height,width,height-10,width-10);
    }

    public boolean isVertical(){
        if (this.width < this.height){
            return true;
        }
        return false;
    }
}