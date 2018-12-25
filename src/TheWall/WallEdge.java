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

    /**
     * some additional colors to color the walls
     */
    public static final Color BROWN = new Color(153,102,0);
    public static final Color light_yellow = new Color(255,255,204);
    public static final Color golden_yellow = new Color(255,204, 51);
    public static final Color GREEN = Color.GREEN;
    Color currentColor;

    /**
     * wall edge class constructor to construct a wall edge which is an instance of a gameobject
     * @param x : int - the x coordinate of a wall edge
     * @param y : int y - the y coordinate of a wall edge
     * @param radius : int - the radius of an wall edge
     * @param isCastle : boolean - a boolean flag to determine is the edge contains a castle or not
     * @param fixedX : int - the initial position's x coordinate of the wall edge
     * @param fixedY : int - the initial position's y coordinate of the wall edge
     */
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

    /**
     * isCastle method to determine if the edge contains a castle or nor
     * @return isCastle: a boolean flag
     */
    public boolean isCastle() {
        return isCastle;
    }


    /**
     * getRadius method to get the radius of the wall edge
     * @return radius : int the radius of the wall edge
     */
    public int getRadius() {
        return radius;
    }

    /**
     * setRadius method to set the radius of the wall edge
     * @param radius : int -the desired value of the radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
        updateMiddlePoint();
    }

    /**
     * getMiddleX method to get the middle point's x coordinate of a wall edge
     * @return middleX : int -the middle point's x coordinate of a wall edge
     */
    public int getMiddleX() {
        return middleX;
    }

    /**
     * getMiddleY method to get the middle point's y coordinate of a wall edge
     * @return middleY : int -the middle point's y coordinate of a wall edge
     */
    public int getMiddleY() {
        return middleY;
    }


    /**
     * updateMiddlePoint method to update the middle point coordinates of the wall edge
     */
    public void updateMiddlePoint(){
        middleX = getX() + radius / 2;
        middleY = getY() + radius / 2;
    }

    /**
     * makeGreen method to color green when a wall edge is placed in a proper place
     * @param b : boolean
     *          b is true if the wall placed in a appropriate place otherwise
     *          b is false
     */
    public void makeGreen(boolean b){
        if(b == true)
            currentColor = GREEN;
        else{
            currentColor = golden_yellow;
        }
    }

    @Override
    /**
     * getY method to get y coordinate of a wall edge
     * @return super.get() - as the y coordinate of the game object- the wall edge
     */
    public int getY() {
        return super.getY();
    }

    @Override
    /**
     * getX method to get x coordinate of a wall edge
     * @return super.get() - as the x coordinate of the game object- the wall edge
     */
    public int getX() {
        return super.getX();
    }

    /**
     * getIndexNo method to take the index no of a wall edge
     * @return indexNo: int as the index of a wall edge
     * this method is for placing a wall
     */
    public int getIndexNo() {
        return indexNo;
    }

    /**
     * setIndexNo method to set the index of a wall edge
     * @param indexNo: int - the index which will be set as the walledge's index
     */
    public void setIndexNo(int indexNo) {
        this.indexNo = indexNo;
    }

    /**
     * setFixedY method to set the fixedY which is the initial y coordinate of the wall
     * @param fixedY: int -the coordinate which will be set as the initial y coordinate
     */
    public void setFixedY(int fixedY) {
        this.fixedY = fixedY;
    }

    /**
     * setFixedX method to set the fixedX which is the initial x coordinate of the wall
     * @param fixedX: int -the coordinate which will be set as the initial x coordinate
     */
    public void setFixedX(int fixedX) {
        this.fixedX = fixedX;
    }

    /**
     * getFixedY method to take the initial y coordinate of a wall edge
     * @return fixedY: int the initial y coordinate of the wall edge
     */
    public int getFixedY() {
        return fixedY;
    }

    /**
     * getFixedX method to take the initial x coordinate of a wall edge
     * @return fixedX: int the initial x coordinate of the wall edge
     */
    public int getFixedX() {
        return fixedX;
    }

    @Override
    /**
     * setX method to set wall edge's x coordinate updates the middle point of the wall edge according to it
     * @param: x : int the desired coordinate of the x
     */
    public void setX(int x) {
        super.setX(x);
        updateMiddlePoint();
    }

    @Override
    /**
     * setY method to set wall edge's y coordinate updates the middle point of the wall edge according to it
     * @param: y : int the desired coordinate of the y
     */
    public void setY(int y) {
        super.setY(y);
        updateMiddlePoint();
    }
}