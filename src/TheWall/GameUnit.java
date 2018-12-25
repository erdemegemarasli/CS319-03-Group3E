package TheWall;


import java.awt.*;
/**
Creator: Ayca Begum Tascioglu
 */

/**
 * Game unit class as an instance of the GameUnits
 * This class was design for additional units at the beginning, however we did not included them and used this class
 * for regular units as well.
 */
public class GameUnit extends GameUnits{

    /**
     * GameUnit constructor to construct a game unit such as knights and castle
     * @param x : int - the x coordinate of a game unit
     * @param y : int - the y coordinate of a game unit
     * @param radius : int the radius of a game unit
     * @param isEnemy : boolean a flag to understand if the knight is an enemy knight(red knight) or not(blue knight)
     * @param theme : int an ID to decide if the theme (HarryPotter or GameOfThrones) character will be presented on the game units or not(default)
     */
    public GameUnit(int x, int y,int radius,boolean isEnemy, int theme){
        super(x,y,radius,isEnemy, theme);
        //new class knight renamed
    }

}

