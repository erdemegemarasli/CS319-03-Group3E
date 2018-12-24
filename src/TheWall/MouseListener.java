package TheWall;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
Creator: Erdem Ege Marasli
This class controls the mouse movement and actions and make changes according to the mouse action
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
    private GameUnit [] tempCastle;
    private GameUnit tempUnit;
    private int count;
    private ArrayList<GameUnit> gameUnits;
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
            this.gameUnits = gameBoard.getGameUnits();
            count = 0;
        }
    }

    /**
     * For every mode when left key of mouse is pressed if cursor on a specific wall
     * that specific wall is selected and start to move with the mouse move.
     *
     * While a specific wall is selected when right key of mouse is pressed selected wall rotates.
     *
     * When selected wall can be placed in the current location of mouse and if user pressed the left key of mouse again
     * that specific wall is placed to the gameboard accordingly.
     *
     * Also user can take a placed wall back by click that wall by left key gameboard setups that accordingly.
     *
     * For Developer Mode Units are work nearly like walls.Only difference is units do not rotate
     *
     *
     */
    public void mousePressed(MouseEvent e)
    {

        if(SwingUtilities.isLeftMouseButton(e)){
            if(!movingWall && movingUnit == false){
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
            else if(movingWall && movingUnit == false){
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
            if(gameBoard.getMode() == 1 && movingWall == false){
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
                    else if(castle1[0].isContainMouse(e.getX(),e.getY()) && count == 0) {
                        tempUnit = castle1[0];
                        tempCastle = castle1;
                        gameBoard.setCastle(castle1);
                        movingUnit = true;
                    }
                    else if(castle2[0].isContainMouse(e.getX(),e.getY()) && count == 0){
                        tempUnit = castle2[0];
                        tempCastle = castle2;
                        gameBoard.setCastle(castle2);
                        movingUnit = true;
                    }
                    else if(tempUnit != null){
                        if(tempUnit.isCastle() == false){
                            for(int i = 0; i < gameUnits.size(); i++){
                                if(gameUnits.get(i).isContainMouse(e.getX(),e.getY())){
                                    tempUnit = gameUnits.get(i);
                                    gameBoard.detachUnit(gameUnits.get(i));
                                    movingUnit = true;
                                    break;
                                }
                            }
                        }
                        else{
                            if(gameBoard.getCastle()[0].isContainMouse(e.getX(),e.getY()) && count == 0) {
                                if(gameBoard.getCastle()[0] == castle1[0]){
                                    tempUnit = castle1[0];
                                    gameBoard.detachCastle();
                                    movingUnit = false;
                                }
                                else{
                                    tempUnit = castle2[0];
                                    gameBoard.detachCastle();
                                    movingUnit = false;
                                }
                            }
                        }

                    }
                }
                else{
                    if(tempUnit.isCastle() == false){
                        if(gameBoard.isValidMove(tempUnit)){
                            gameBoard.makeMove(tempUnit);
                            movingUnit = false;
                            tempUnit = null;
                        }
                        else{
                            gameBoard.getGameUnits().remove(tempUnit);
                            tempUnit = null;
                            movingUnit = false;
                        }

                    }
                    else{
                        if(gameBoard.isValidMoveCastle()){
                            gameBoard.makeMoveCastle();
                            movingUnit = false;
                            tempUnit = null;
                            count++;
                        }
                        else{
                            if(castle1 == gameBoard.getCastle()){
                                castle1 = tempCastle;
                                gameBoard.setCastle(null);
                                movingUnit = false;
                                tempUnit = null;
                            }
                            else{
                                castle2 = tempCastle;
                                gameBoard.setCastle(null);
                                movingUnit = false;
                                tempUnit = null;
                            }
                        }
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
    /**
     * For every mode when a wall is selected, mouse movement update that wall's cordinates. Also make wall green
     * if the current position is a valid position to put wall.
     *
     * For Developer mode it is nearly same as wall but unit do no be green when is valid to put.
     *
     * */
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
                if(tempUnit.isCastle() == false){
                    //System.out.println("hayda");
                    tempUnit.setX(e.getX() - 30);
                    tempUnit.setY(e.getY() - 30);
                }
                else{
                    if(tempUnit == castle1[0]){
                        gameBoard.getCastle()[0].setX(e.getX() - 30);
                        gameBoard.getCastle()[1].setX(e.getX() - 30);
                        gameBoard.getCastle()[0].setY(e.getY()- 30 - gameBoard.getCastle()[0].getRadius() / 2);
                        gameBoard.getCastle()[1].setY(e.getY() + 80 - 30 - gameBoard.getCastle()[0].getRadius() / 2);
                    }
                    else{
                        gameBoard.getCastle()[0].setX(e.getX() - 30 - gameBoard.getCastle()[0].getRadius() / 2);
                        gameBoard.getCastle()[1].setX(e.getX() + 80 - 30 - gameBoard.getCastle()[0].getRadius() / 2);
                        gameBoard.getCastle()[0].setY(e.getY()- 30);
                        gameBoard.getCastle()[1].setY(e.getY()- 30);
                    }
                }
                //System.out.println(gameBoard.getGameUnits().get(0).getX());
            }
        }


    }

}
