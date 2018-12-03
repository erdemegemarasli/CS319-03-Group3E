package TheWall;

import java.awt.*;
/*
Creator: Ayca Begum Tascioglu
 */

public class WallLine  extends GameObject {
    int height, width;
    public static final Color BROWN = new Color(153,102,0);
    public static final Color golden_yellow = new Color(255,204, 51);

    public WallLine(int x, int y, int width, int height) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setY(int y) {
        super.setY(y);
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public void draw(Graphics g){
        g.setColor(golden_yellow);
        //g.draw3DRect(this.getX(),this.getY(),height,width,false);
        //g.setColor(Color.WHITE);
        g.fillRect(this.getX(),this.getY(),width,height);
        g.setPaintMode();

        //g.draw3DRect(this.getX(),this.getY(),height,width,true);
        //g.fillRoundRect(this.getX(),this.getY(),height,width,height-10,width-10);
        //g.drawRoundRect(this.getX(),this.getY(),height,width,height-10,width-10);
    }
}
