package TheWall;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    private GameBoard board;
    private Walls walls;
    private Render render;
    private Timer renderListener;
    public Game(){
        board = new GameBoard();
        walls = new Walls();
        render = new Render();
        renderListener = new Timer(50,new RenderListener());
        renderListener.start();
    }
    public GameBoard getGameBoard(){
        return board;
    }
    public Wall[] getWalls()
    {
        return walls.getWalls();
    }

    public Render getRender() {
        return render;
    }

    private class RenderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            render.update();
        }
    }
}
