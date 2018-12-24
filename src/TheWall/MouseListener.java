package TheWall;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/*
Creator: Erdem Ege Marasli
 */
public class MouseListener extends MouseAdapter {
    private Wall [] walls;
    private boolean movingWall;
    private int wallIndex;
    private GameBoard gameBoard;
    private boolean movingUnit;
    private GameUnit [] fixedUnits;
    private GameUnit [] castle1;
    private GameUnit [] castle2;
    public MouseListener(Wall[] walls, GameBoard gameBoard){
        this.walls = walls;
        this.gameBoard = gameBoard;
        movingWall = false;
        wallIndex = -1;
        movingUnit = false;
        if(gameBoard.getMode() == 1){
            fixedUnits = gameBoard.getFixedUnits();
            castle1 = gameBoard.getCastle1Dev();
            castle2 = gameBoard.getCastle2Dev();
        }
    }
    public void mousePressed(MouseEvent e)
    {

        if(SwingUtilities.isLeftMouseButton(e)){
            if(!movingWall){
                for(int i = 0; i < walls.length; i++){
                    if(walls[i].isContainMouse(e.getX(),e.getY())){
                        wallIndex = i;
                        movingWall = true;
                        walls[i].setMoving(true);
                        if(walls[i].isPlaced()){
                            gameBoard.detachWall(walls[i]);
                        }
                        break;
                    }
                }
            }
            else if(movingWall){
                walls[wallIndex].setMoving(false);

                if(gameBoard.isValidMove(walls[wallIndex])){
                    //System.out.println("Valid");
                    walls[wallIndex].makeGreen(false);
                    gameBoard.makeMove(walls[wallIndex]);
                }
                else{
                    int temp = walls[wallIndex].getRotateCount() % 4;
                    temp = Math.abs(temp - 4);
                    if(temp != 4){
                        for(int i = 0; i < temp; i++){
                            walls[wallIndex].rotate();
                        }
                    }
                    walls[wallIndex].setFixed();
                    walls[wallIndex].setFixedInitial();
                    walls[wallIndex].setFixedMidpoint();
                    walls[wallIndex].setRotateCount(0);
                }
                wallIndex = -1;
                movingWall = false;
            }
            if(gameBoard.getMode() == 1){
                if(!movingUnit){
                    if(fixedUnits[0].isContainMouse(e.getX(),e.getY())){

                    }
                    else if(castle1[0].isContainMouse(e.getX(),e.getY()) || castle1[1].isContainMouse(e.getX(),e.getY())){

                    }
                }
            }
        }
        else if(SwingUtilities.isRightMouseButton(e) && movingWall && wallIndex > -1){
            walls[wallIndex].rotate();
            int tmp = walls[wallIndex].getRotateCount() + 1;
            walls[wallIndex].setRotateCount(tmp);
        }



    }
    public void mouseMoved(MouseEvent e){
        if(movingWall){
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
