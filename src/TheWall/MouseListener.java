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
    private GameUnit tempUnit;
    public MouseListener(Wall[] walls, GameBoard gameBoard){
        this.walls = walls;
        this.gameBoard = gameBoard;
        movingWall = false;
        wallIndex = -1;
        movingUnit = false;
        tempUnit = null;
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
                        tempUnit = gameBoard.createUnit(fixedUnits[0].getX(),fixedUnits[0].getY(),false);
                        gameBoard.getGameUnits().add(tempUnit);
                        movingUnit = true;
                    }
                    else if(fixedUnits[1].isContainMouse(e.getX(),e.getY())){
                        tempUnit = gameBoard.createUnit(fixedUnits[1].getX(),fixedUnits[1].getY(),true);
                        gameBoard.getGameUnits().add(tempUnit);
                        movingUnit = true;
                    }
                    else if(castle1[0].isContainMouse(e.getX(),e.getY())){

                    }
                }
                else{
                    if(tempUnit.isCastle() == false){
                        gameBoard.getGameUnits().remove(tempUnit);
                        tempUnit = null;
                        movingUnit = false;
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
        else if(movingUnit){
            if(tempUnit != null){
                tempUnit.setX(e.getX() - 30);
                tempUnit.setY(e.getY() - 30);
                //System.out.println(gameBoard.getGameUnits().get(0).getX());
                if(gameBoard.isValidMove(tempUnit)){
                    System.out.println("asda");
                }
            }
        }


    }

}
