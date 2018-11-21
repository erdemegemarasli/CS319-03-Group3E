package TheWall;

import javax.swing.*;
import java.awt.*;

public class GameViewer extends SimplePanel implements Viewer {
    private Game game;
    private GameBoard board;
    private Wall[] walls;
    public GameViewer(Game game){
        super();
        this.setFocusable(true);
        this.game = game;
        board = game.getGameBoard();
        walls = game.getWalls();
        //repaint();

    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        board.draw(g);
        for(int i = 0; i < 4; i++)
            walls[i].draw(g);


    }
    //update method to call repaint
    public void update()
    {
        repaint();
    }
}
