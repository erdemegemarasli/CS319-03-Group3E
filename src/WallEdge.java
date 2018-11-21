package TheWall;

import java.awt.*;

public class WallEdge extends GameObject {
    int radius;
    boolean isCastle;
    public static final Color BROWN = new Color(153,102,0);
    public static final Color light_yellow = new Color(255,255,204);
    public static final Color golden_yellow = new Color(255,204, 51);
    public WallEdge(int x, int y,int radius, boolean isCastle){
        super(x, y);
        this.radius = radius;
        this.isCastle = isCastle;
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
            g.setColor(BROWN);
            //g.fillOval(this.getX(), this.getY(), radius, radius);
            g.fillRoundRect(this.getX(), this.getY(), radius, radius,radius,radius);
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
    }
}
