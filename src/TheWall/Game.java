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
    private int mode;
    public Game(int level, int mode){
        this.mode = mode;
        if(mode == 0){
            walls = new Walls();

            levels = new Levels();
            map = levels.getLevels()[level];
            playerMap = map;/*
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
        }*/
            board = new GameBoard(map);

            render = new Render();
            renderListener = new Timer(25,new RenderListener());
            renderListener.start();
            for(int i = 0; i < board.getHorizontalRectangles().length; i++){
                System.out.println(board.getHorizontalRectangles()[i].getInfo());
            }
            System.out.println("--------------");
            for(int i = 0; i < map.getHorizontalRectangleLocations().length; i++){
                System.out.println(map.getHorizontalRectangleLocations()[i]);
            }
        }

        /*
        DEVELOPER MODE : 1
         */
        if(mode == 1){
            walls = new Walls();
            int [] squareLocations = {0,0,0,
                    0,0,0,0,0,
                    0,0,0,0,0,
                    0,0,0};
            int [] edgeLocations = {0,0,0,0,
                    0,0,0,0,0,0,
                    0,0,0,0,0,0,
                    0,0,0,0,0,0,
                    0,0,0,0};
            int [] horizontalRectangleLocations = {0,0,0,
                    0,0,0,0,0,
                    0,0,0,0,0,
                    0,0,0,0,0,
                    0,0,0};
            int [] verticalRectangleLocations = {0,0,0,0,
                    0,0,0,0,0,0,
                    0,0,0,0,0,0,
                    0,0,0,0};
            map = new Map(squareLocations,edgeLocations,horizontalRectangleLocations,verticalRectangleLocations);
            playerMap = null;
            board = new GameBoard(map);

            render = new Render();
            renderListener = new Timer(25,new RenderListener());
            renderListener.start();

        }

    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getMode() {
        return mode;
    }

    public GameBoard getGameBoard(){
        return board;
    }
    public Wall[] getWalls()
    {
        return walls.getWalls();
    }

    public Map getPlayerMap() {
        return playerMap;
    }

    public Render getRender() {
        return render;
    }
    public boolean checkWinCondition(){
        return getGameBoard().isGameFinished();
    }

    private class RenderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            render.update();
            if(checkWinCondition() == true && mode == 0){
                JOptionPane.showMessageDialog(null, "You Passed The Level " , "You Passed The Level", JOptionPane.INFORMATION_MESSAGE);
                renderListener.stop();
            }
        }
    }

}
