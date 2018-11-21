package TheWall;

import java.awt.*;

public class WallLine  extends GameObject {
    int height, width;
    public static final Color BROWN = new Color(153,102,0);

    public WallLine(int x, int y, int height, int width) {
        super(x, y);
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw(Graphics g){
        g.setColor(BROWN);
        g.draw3DRect(this.getX(),this.getY(),height,width,false);
        g.setColor(Color.WHITE);
        g.fillRect(this.getX(),this.getY(),height,width);
        g.setPaintMode();

        //g.draw3DRect(this.getX(),this.getY(),height,width,true);
        //g.fillRoundRect(this.getX(),this.getY(),height,width,height-10,width-10);
        //g.drawRoundRect(this.getX(),this.getY(),height,width,height-10,width-10);
    }
}
