package TheWall;

import java.awt.*;

public class GameBoard implements Drawable
{
    final int edgeHeight = 20;
    final int edgeWidth = 20;
    final int squareHeight = 60;
    final int squareWidth = 60;
    final int rectangleHeight = 20;
    final int rectangleWidth = 60;
    final int mostLeftX = 100;
    final int mostUpY = 100;
    Edge edges[] = new Edge[26];
    Square squares[] = new Square[16];
    Rectangle horizontalRectangles[] = new Rectangle[21];
    Rectangle verticalRectangles[] = new Rectangle[20];
    public GameBoard()
    {
        createEmptyGameBoard();
    }
    public void draw(Graphics g)
    {
        for(int i = 0; i < 26; i++)
            edges[i].draw(g);
        for(int i = 0; i < 21; i++)
            horizontalRectangles[i].draw(g);
        for(int i = 0; i < 20; i++)
            verticalRectangles[i].draw(g);
        for(int i = 0; i < 16; i++)
            squares[i].draw(g);
    }
    public void createEmptyGameBoard()
    {
        createEdges();
        createHorizontalRectangles();
        createVerticalRectangles();
        createSquares();;
    }
    public void createEdges()
    {
        int tempX = mostLeftX + edgeHeight + rectangleWidth;
        for(int i = 0; i < 4; i++)
        {
            edges[i] = new Edge(tempX, mostUpY, edgeWidth,edgeHeight);
            tempX += edgeHeight + rectangleWidth;
        }
        tempX = mostLeftX;
        int tempY = mostUpY +edgeHeight + rectangleWidth;
        int tempCount = 0;
        for(int i = 4; i <22; i++)
        {
            edges[i] = new Edge(tempX,tempY,edgeWidth,edgeHeight);
            tempX += edgeHeight + rectangleWidth;
            tempCount++;
            if(tempCount > 5)
            {
                tempCount = 0;
                tempX = mostLeftX;
                tempY += edgeHeight + rectangleWidth;
            }
        }
        tempX = mostLeftX + edgeHeight + rectangleWidth;
        for(int i = 22; i < 26; i++)
        {
            edges[i] = new Edge(tempX,tempY,edgeWidth,edgeHeight);
            tempX += edgeHeight + rectangleWidth;
        }
    }
    public void createHorizontalRectangles()
    {
        int tempX = mostLeftX + edgeWidth + edgeWidth + rectangleWidth;
        int tempY = mostUpY;
        int tempCount = 0;
        for(int i = 0; i < 3; i++)
        {
            horizontalRectangles[i] = new Rectangle(tempX,tempY,rectangleWidth,rectangleHeight);
            tempX += edgeWidth + rectangleWidth;
        }
        tempX = mostLeftX + edgeWidth;
        tempY += edgeHeight + rectangleWidth;
        for(int i = 3; i < 18; i++)
        {
            horizontalRectangles[i] = new Rectangle(tempX,tempY,rectangleWidth,rectangleHeight);
            tempX += edgeHeight + rectangleWidth;
            tempCount++;
            if(tempCount > 4)
            {
                tempCount = 0;
                tempX = mostLeftX + edgeWidth;
                tempY += edgeHeight + rectangleWidth;
            }
        }
        tempX = mostLeftX + edgeWidth + edgeWidth + rectangleWidth;
        for(int i = 18; i < 21; i++)
        {
            horizontalRectangles[i] = new Rectangle(tempX, tempY, rectangleWidth, rectangleHeight);
            tempX += edgeHeight + rectangleWidth;
        }
    }
    public void createVerticalRectangles()
    {
        int tempX = mostLeftX + edgeHeight + rectangleWidth;
        int tempY = mostUpY + edgeHeight;
        int tempCount = 0;
        for(int i = 0; i < 4; i++)
        {
            verticalRectangles[i] = new Rectangle(tempX,tempY,rectangleHeight,rectangleWidth);
            tempX += rectangleHeight + squareWidth;
        }
        tempX = mostLeftX;
        tempY += edgeHeight + rectangleWidth;
        for(int i = 4; i < 16; i++)
        {
            verticalRectangles[i] = new Rectangle(tempX,tempY,rectangleHeight,rectangleWidth);
            tempX += rectangleHeight + squareWidth;
            tempCount++;
            if(tempCount > 5)
            {
                tempCount = 0;
                tempX = mostLeftX;
                tempY += edgeHeight + rectangleWidth;
            }
        }
        tempX = mostLeftX + edgeHeight + rectangleWidth;
        for(int i = 16; i < 20; i++)
        {
            verticalRectangles[i] = new Rectangle(tempX,tempY,rectangleHeight,rectangleWidth);
            tempX += rectangleHeight + squareWidth;
        }
    }
    public void createSquares()
    {
        int tempX = mostLeftX + edgeHeight + rectangleWidth + rectangleHeight;
        int tempY = mostUpY + edgeHeight;
        int tempCount = 0;
        for(int i = 0; i < 3; i++)
        {
            squares[i] = new Square(tempX,tempY,squareWidth,squareHeight);
            tempX += rectangleHeight + squareWidth;
        }
        tempX = mostLeftX + rectangleHeight;
        tempY += edgeHeight + rectangleWidth;
        for(int i = 3; i < 13; i++)
        {
            squares[i] = new Square(tempX,tempY,squareWidth,squareHeight);
            tempX += rectangleHeight + squareWidth;
            tempCount++;
            if(tempCount > 4)
            {
                tempCount = 0;
                tempX = mostLeftX + rectangleHeight;
                tempY += edgeHeight + rectangleWidth;
            }
        }
        tempX = mostLeftX + edgeHeight + rectangleWidth + rectangleHeight;
        for(int i = 13; i < 16; i++)
        {
            squares[i] = new Square(tempX ,tempY,squareWidth,squareHeight);
            tempX += rectangleHeight + squareWidth;
        }
    }
}
