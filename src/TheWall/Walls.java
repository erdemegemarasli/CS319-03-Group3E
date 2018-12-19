package TheWall;

import java.awt.*;
/*
Creator: Ayca Begum Tascioglu
 */
public class Walls{
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
        //create first wall
        WallEdge wallEdges0[] = new WallEdge[4];
        wallEdges0[0] = new WallEdge(x, y, radius,true, x ,y);
        wallEdges0[1] = new WallEdge(x+radius+ horizontalWidth , y, radius,false,
                                x+radius+ horizontalWidth,y);
        wallEdges0[2] = new WallEdge(x, y+radius+verticalHeight, radius,false, x, y+radius+verticalHeight);
        wallEdges0[3] = new WallEdge(x+ horizontalWidth+radius , y+radius+verticalHeight, radius,false,x+ horizontalWidth+radius , y+radius+verticalHeight);

        WallLine wallLines0[] = new WallLine[3];
        wallLines0[0] = new WallLine(x+radius, y , horizontalWidth , horizontalHeight, x+radius, y);
        wallLines0[1] = new WallLine(x , y+radius, verticalWidth, verticalHeight,x , y+radius);
        wallLines0[2] = new WallLine(x+ verticalHeight+radius, y+radius, verticalWidth, verticalHeight,x+ verticalHeight+radius, y+radius);

        //create second wall
        y += 120;
        WallEdge wallEdges1[] = new WallEdge[7];
        wallEdges1[0] = new WallEdge(x, y, radius,false,x, y);
        wallEdges1[1] = new WallEdge(x + radius+horizontalWidth, y, radius,false,x + radius+horizontalWidth, y);
        wallEdges1[2] = new WallEdge(x + radius+horizontalWidth, y + verticalHeight+radius, radius,false,x + radius+horizontalWidth, y + verticalHeight+radius);
        wallEdges1[3] = new WallEdge(x + 2*radius + 2*horizontalWidth, y , radius,false,x + 2*radius + 2*horizontalWidth, y);
        wallEdges1[4] = new WallEdge(x + 2*horizontalWidth+2*radius, y +verticalHeight+radius, radius,false,x + 2*horizontalWidth+2*radius, y +verticalHeight+radius);
        wallEdges1[5] = new WallEdge(x, y+radius+verticalHeight, radius,false,x, y+radius+verticalHeight);
        wallEdges1[6] = new WallEdge(x + 3*horizontalWidth+3*radius, y, radius,false,x + 3*horizontalWidth+3*radius, y);


        WallLine wallLines1[] = new WallLine[6];
        wallLines1[0] = new WallLine(x, y, verticalWidth, verticalHeight+radius,x,y);
        wallLines1[1] = new WallLine(x + radius, y, horizontalWidth, horizontalHeight,x + radius, y);
        wallLines1[2] = new WallLine(x + horizontalWidth+ radius, y+radius, verticalWidth, verticalHeight,x + horizontalWidth+ radius, y+radius);
        wallLines1[3] = new WallLine(x + horizontalWidth+ 2*radius, y +verticalHeight+radius, horizontalWidth, horizontalHeight,x + horizontalWidth+ 2*radius, y +verticalHeight+radius);
        wallLines1[4] = new WallLine(x + 2*radius + 2*horizontalWidth, y+radius, verticalWidth, verticalHeight,x + 2*radius + 2*horizontalWidth, y+radius);
        wallLines1[5] = new WallLine(x + 2*horizontalWidth+3*radius, y, horizontalWidth, horizontalHeight,x + 2*horizontalWidth+3*radius, y);

        //create third wall
        y+=120;
        WallEdge wallEdges2[] = new WallEdge[5];
        wallEdges2[0] = new WallEdge(x+radius+horizontalWidth, y, radius, true,x+radius+horizontalWidth, y);
        wallEdges2[1] = new WallEdge(x+horizontalWidth+radius, y+radius+verticalHeight,radius,false,x+horizontalWidth+radius, y+radius+verticalHeight);
        wallEdges2[2] = new WallEdge(x+2*radius+2*horizontalWidth, y+radius+verticalHeight,radius,true,x+2*radius+2*horizontalWidth, y+radius+verticalHeight);
        wallEdges2[3] = new WallEdge(x, y, radius, false,x, y);
        wallEdges2[4] = new WallEdge(x+2*radius+2*horizontalWidth, y+2*radius+2*verticalHeight, radius, false,x+2*radius+2*horizontalWidth, y+2*radius+2*verticalHeight);

        WallLine wallLines2[] = new WallLine[4];
        wallLines2[0] = new WallLine(x+radius, y, horizontalWidth+(radius/2), horizontalHeight,x+radius, y);
        wallLines2[1] = new WallLine(x+horizontalWidth+radius, y+radius, verticalWidth, verticalHeight,x+horizontalWidth+radius, y+radius);
        wallLines2[2] = new WallLine(x+horizontalWidth+2*radius,y+ radius+verticalHeight, horizontalWidth+(radius/2), horizontalHeight,x+horizontalWidth+2*radius,y+ radius+verticalHeight);
        wallLines2[3] = new WallLine(x+2*radius+2*horizontalWidth, y +verticalHeight+2*radius, verticalWidth, verticalHeight,x+2*radius+2*horizontalWidth, y +verticalHeight+2*radius);

        //create fourth wall
        y+=140;
        WallEdge wallEdges3[] = new WallEdge[6];
        wallEdges3[0] = new WallEdge(x+horizontalWidth+radius, y,radius,true,x+horizontalWidth+radius, y);
        wallEdges3[1] = new WallEdge(x, y, radius, false,x, y);
        wallEdges3[2] = new WallEdge(x+horizontalWidth+radius, y+radius+verticalHeight,radius,false,x+horizontalWidth+radius, y+radius+verticalHeight);
        wallEdges3[3] = new WallEdge(x+2*horizontalWidth+2*radius, y+radius+verticalHeight,radius,false,x+2*horizontalWidth+2*radius, y+radius+verticalHeight);
        wallEdges3[4] = new WallEdge(x, y+radius+verticalHeight, radius, false,x, y+radius+verticalHeight);
        wallEdges3[5] = new WallEdge(x+2*horizontalWidth+2*radius, y+2*radius+2*verticalHeight, radius, false,x+2*horizontalWidth+2*radius, y+2*radius+2*verticalHeight);

        WallLine wallLines3[] = new WallLine[5];
        wallLines3[0] = new WallLine(x, y+radius, verticalWidth, verticalHeight,x, y+radius);
        wallLines3[1] = new WallLine(x+radius, y, horizontalWidth+(radius/2), horizontalHeight,x+radius, y);
        wallLines3[2] = new WallLine(x+horizontalWidth+radius,y+ radius, verticalWidth, verticalHeight,x+horizontalWidth+radius,y+ radius);
        wallLines3[3] = new WallLine(x+horizontalWidth+2*radius, y +verticalHeight+radius, horizontalWidth, horizontalHeight,x+horizontalWidth+2*radius, y +verticalHeight+radius);
        wallLines3[4] = new WallLine(x+2*horizontalWidth+2*radius, y+radius*2+verticalHeight, verticalWidth, verticalHeight,x+2*horizontalWidth+2*radius, y+radius*2+verticalHeight);


        walls[0] = new Wall(wallEdges0, wallLines0, 1);
        walls[0].setFixedInitialPositionX(wallEdges0[0].getX());
        walls[0].setFixedInitialPositionY(wallEdges0[0].getY());
        walls[0].setInitialPositionX(wallEdges0[0].getX());
        walls[0].setInitialPositionY(wallEdges0[0].getY());
        walls[0].setMidPointX(wallEdges0[0].getX());
        walls[0].setMidPointY(wallEdges0[0].getY());

        walls[1] = new Wall(wallEdges1, wallLines1, 2);
        walls[1].setFixedInitialPositionX(wallEdges1[2].getX());
        walls[1].setFixedInitialPositionY(wallEdges1[2].getY());
        walls[1].setInitialPositionX(wallEdges1[2].getX());
        walls[1].setInitialPositionY(wallEdges1[2].getY());
        walls[1].setMidPointX(wallEdges1[2].getX());
        walls[1].setMidPointY(wallEdges1[2].getY());


        walls[2] = new Wall(wallEdges2, wallLines2, 3);
        walls[2].setFixedInitialPositionX(wallEdges2[1].getX());
        walls[2].setFixedInitialPositionY(wallEdges2[1].getY());
        walls[2].setInitialPositionX(wallEdges2[1].getX());
        walls[2].setInitialPositionY(wallEdges2[1].getY());
        walls[2].setMidPointX(wallEdges2[1].getX());
        walls[2].setMidPointY(wallEdges2[1].getY());

        walls[3] = new Wall(wallEdges3, wallLines3, 4);
        walls[3].setFixedInitialPositionX(wallEdges3[2].getX());
        walls[3].setFixedInitialPositionY(wallEdges3[2].getY());
        walls[3].setInitialPositionX(wallEdges3[2].getX());
        walls[3].setInitialPositionY(wallEdges3[2].getY());
        walls[3].setMidPointX(wallEdges3[2].getX());
        walls[3].setMidPointY(wallEdges3[2].getY());

    }

    public Wall[] getWalls() {
        return walls;
    }
/*
    @Override
    public void draw(Graphics g) {
        int i;
        for(i = 0; i < walls.length; i++)
            walls[i].draw(g);
        /*
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
    }*/
}
