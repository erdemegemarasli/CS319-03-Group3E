package TheWall;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    private Wall [] walls;
    private boolean moving;
    private int wallIndex;
    public MouseListener(Wall[] walls){
        this.walls = walls;
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
                        break;
                    }
                }
            }
            else if(moving){
                moving = false;
                wallIndex = -1;
            }
        }
        else if(SwingUtilities.isRightMouseButton(e)){
            walls[0].rotate();
            System.out.println("Right");
        }



    }
    public void mouseMoved(MouseEvent e){
        if(moving){
            walls[wallIndex].setX(e.getX());
            walls[wallIndex].setY(e.getY());
        }


    }
    public void mouseReleased(MouseEvent e){

    }

}
