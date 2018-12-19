package TheWall;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Creator: Erdem Ege Marasli
 */
public class Game {

    private GameBoard board;
    private Walls walls;
    private Render render;
    private Timer renderListener;
    private Levels levels;
    private Map map;
    private Map playerMap;
    public Game(int level){

        walls = new Walls();

        levels = new Levels();
        map = levels.getLevels()[level];
        playerMap = map;
        for(int i = 0; i < playerMap.getHorizontalRectangleLocations().length; i++){
            if(playerMap.getHorizontalRectangleLocations()[i] != 2)
                playerMap.getHorizontalRectangleLocations()[i] = 0;
        }
        for(int i = 0; i < playerMap.getVerticalRectangleLocations().length; i++){
            if(playerMap.getVerticalRectangleLocations()[i] != 2)
                playerMap.getVerticalRectangleLocations()[i] = 0;
        }
        for(int i = 0; i < playerMap.getEdgeLocations().length; i++){
            playerMap.getEdgeLocations()[i] = 0;
        }
        board = new GameBoard(map);

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
    public boolean checkWinCondition(){
        return map.isSame(playerMap);
    }

    private class RenderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            render.update();
            //Check Win Condition
        }
    }

}
