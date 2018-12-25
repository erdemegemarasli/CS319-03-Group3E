package TheWall;


import java.awt.*;
/**
Creator: Ayca Begum Tascioglu
 */

/**
 * Game unit class as an instance of the GameUnits
 */
public class GameUnit extends GameUnits{

    /**
     * GameUnit constructor to construct a game unit such as knights and castle
     * @param x : int - the x coordinate of a game unit
     * @param y
     * @param radius
     * @param isEnemy
     * @param theme
     */
    public GameUnit(int x, int y,int radius,boolean isEnemy, int theme){
        super(x,y,radius,isEnemy, theme);
        //new class knight renamed
    }

}

