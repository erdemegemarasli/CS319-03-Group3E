package TheWall;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
Creator: Erdem Ege Marasli
 */
public class MouseListener extends MouseAdapter {
    private Wall [] walls;
    private int rotateCount;
    private boolean moving;
    private int wallIndex;
    private Map playerMap;
    private GameBoard gameBoard;
    public MouseListener(Wall[] walls, GameBoard gameBoard, Map playerMap){
        this.walls = walls;
        this.gameBoard = gameBoard;
        this.playerMap = playerMap;
        moving = false;
        wallIndex = -1;
    }
    public void mousePressed(MouseEvent e)
    {

        if(SwingUtilities.isLeftMouseButton(e)){
            if(!moving){
                for(int i = 0; i < walls.length; i++){
                    if(walls[i].isContainMouse(e.getX(),e.getY())){
                        wallIndex = i;
                        moving = true;
                        walls[i].setMoving(true);
                        if(walls[i].isPlaced()){
                            gameBoard.detachWall(walls[i]);
                        }
                        break;
                    }
                }
            }
            else if(moving){
                walls[wallIndex].setMoving(false);
                moving = false;
                if(gameBoard.isValidMove(walls[wallIndex])){
                    System.out.println("Valid");
                    walls[wallIndex].makeGreen(false);
                    gameBoard.makeMove(walls[wallIndex]);
                }
                else{
                    int temp = rotateCount % 4;
                    temp = Math.abs(temp - 4);
                    if(temp != 4){
                        for(int i = 0; i < temp; i++){
                            walls[wallIndex].rotate();
                        }
                    }
                    walls[wallIndex].setFixed();
                    walls[wallIndex].setFixedInitial();
                    walls[wallIndex].setFixedMidpoint();
                    rotateCount = 0;
                }
                wallIndex = -1;
            }
        }
        else if(SwingUtilities.isRightMouseButton(e) && moving && wallIndex > -1){
            walls[wallIndex].rotate();
            rotateCount++;
        }



    }
    public void mouseMoved(MouseEvent e){
        if(moving){
            walls[wallIndex].setX(e.getX());
            walls[wallIndex].setY(e.getY());
            if(gameBoard.isValidMove(walls[wallIndex])){
                walls[wallIndex].makeGreen(true);
            }
            else{
                walls[wallIndex].makeGreen(false);
            }
        }


    }

}
