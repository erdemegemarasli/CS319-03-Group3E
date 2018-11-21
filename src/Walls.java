package TheWall;

import java.awt.*;

public class Walls implements Drawable {
    Wall walls[] = new Wall[4];

    int x = 800;
    int y = 10;
    final int radius = 20;
    //lengths for vertical rectangle
    final int horizontalWidth = 60;
    final int horizontalHeight = 20;
    //length for horizontal rectangle
    final int verticalWidth = 20;
    final int verticalHeight = 60;

    public Walls() {
        //create wall number 1
        WallEdge wallEdges0[] = new WallEdge[1];
        wallEdges0[0] = new WallEdge(x, y, radius,true);

        //wallEdges0[1] = new WallEdge(x+radius+ horizontalWidth , y, radius,false);
        WallLine wallLines0[] = new WallLine[3];
        wallLines0[0] = new WallLine(x, y+(radius/2) , horizontalWidth+radius , horizontalHeight);
        wallLines0[1] = new WallLine(x , y+(radius/2), verticalWidth, verticalHeight+(radius/2));
        wallLines0[2] = new WallLine(x+ verticalHeight+radius, y+(radius/2), verticalWidth, verticalHeight+(radius/2));


        //create second wall
        y += 100;
        WallLine wallLines1[] = new WallLine[6];
        wallLines1[0] = new WallLine(x, y, verticalWidth, verticalHeight+radius);
        wallLines1[1] = new WallLine(x , y, horizontalWidth+radius, horizontalHeight);
        wallLines1[2] = new WallLine(x + horizontalWidth+ radius, y, verticalWidth, verticalHeight+radius);
        wallLines1[3] = new WallLine(x + horizontalWidth+ radius, y +verticalHeight+radius, horizontalWidth+radius, horizontalHeight);
        wallLines1[4] = new WallLine(x + 2*radius + 2*horizontalWidth, y+radius, verticalWidth, verticalHeight+radius);
        wallLines1[5] = new WallLine(x + 2*horizontalWidth+2*radius, y, horizontalWidth+radius, horizontalHeight);

        //create third wall
        y+=120;
        WallEdge wallEdges2[] = new WallEdge[2];
        wallEdges2[0] = new WallEdge(x+horizontalWidth, y, radius, true);
        wallEdges2[1] = new WallEdge(x+radius+2*horizontalWidth, y+radius+verticalHeight,radius,true);

        WallLine wallLines2[] = new WallLine[4];
        wallLines2[0] = new WallLine(x, y, horizontalWidth+ (radius/2), horizontalHeight);
        wallLines2[1] = new WallLine(x+horizontalWidth, y+radius, verticalWidth, verticalHeight+radius);
        wallLines2[2] = new WallLine(x+horizontalWidth+radius,y+ radius+verticalHeight, horizontalWidth + (radius/2), horizontalHeight);
        wallLines2[3] = new WallLine(x+radius+2*horizontalWidth, y +verticalHeight+2*radius, verticalWidth, verticalHeight);

        //create fourth wall
        y+=140;
        WallEdge wallEdges3[] = new WallEdge[4];
        wallEdges3[0] = new WallEdge(x+horizontalWidth+radius, y,radius,true);

        WallLine wallLines3[] = new WallLine[5];
        wallLines3[0] = new WallLine(x, y, verticalWidth, verticalHeight+radius);
        wallLines3[1] = new WallLine(x+radius, y, horizontalWidth+(radius/2), horizontalHeight);
        wallLines3[2] = new WallLine(x+horizontalWidth+radius,y+ radius, verticalWidth, verticalHeight+radius);
        wallLines3[3] = new WallLine(x+horizontalWidth+2*radius, y +verticalHeight+radius, horizontalWidth+radius, horizontalHeight);
        wallLines3[4] = new WallLine(x+2*horizontalWidth+2*radius, y+radius*2+verticalHeight, verticalWidth, verticalHeight);


        walls[0] = new Wall(wallEdges0, wallLines0);
        walls[1] = new Wall(null, wallLines1);
        walls[2] = new Wall(wallEdges2, wallLines2);
        walls[3] = new Wall(wallEdges3, wallLines3);

    }

    @Override
    public void draw(Graphics g) {
        int i;

        //draw first wall (number 1)
        for(i = 0; i< 3; i++)
            walls[0].wallLines[i].draw(g);
        for(i = 0; i< 1; i++)
            walls[0].wallEdges[i].draw(g);

        //draw second wall
        for(i = 0; i< 6; i++)
            walls[1].wallLines[i].draw(g);


        //draw third wall
        for(i = 0; i< 4; i++)
            walls[2].wallLines[i].draw(g);
        for(i = 0; i< 2; i++)
            walls[2].wallEdges[i].draw(g);


        //draw fourth wall
        for(i = 0; i< 5; i++)
            walls[3].wallLines[i].draw(g);
        for(i = 0; i< 1; i++)
            walls[3].wallEdges[i].draw(g);
    }
}
