package TheWall;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
/**
Creator: Erdem Ege Marasli & Ayca Begum Tascioglu
Description: A simple game class to construct a game acoording to its mode and its theme
 */

/**
For Modes:
0 = classic
1 = developer map create
2 = challange
3 = campaign
4 = developer map play
 Controller of the game.
 */
public class Game {

    /**
    ImageIcons to used in the JOptionPanes
     */
    ImageIcon harry = new ImageIcon("src/TheWall/images/harry.jpg");
    ImageIcon voldemort = new ImageIcon("src/TheWall/images/voldemort.jpg");
    ImageIcon hermione = new ImageIcon("src/TheWall/images/hermione.jpg");
    ImageIcon ron = new ImageIcon("src/TheWall/images/ron.jpg");

    ImageIcon arya = new ImageIcon("src/TheWall/images/arya.jpg");
    ImageIcon cersei = new ImageIcon("src/TheWall/images/cersei.jpg");
    ImageIcon jon = new ImageIcon("src/TheWall/images/jon.jpg");
    ImageIcon khaleesi = new ImageIcon("src/TheWall/images/khaleesi.jpg");
    ImageIcon nk = new ImageIcon("src/TheWall/images/nightking.jpg");
    ImageIcon melis = new ImageIcon("src/TheWall/images/melis.jpg");


    private GameBoard board;
    private Walls walls;
    private Render render;
    private Timer renderListener;
    private Levels levels;
    private Map map;
    private int mode;
    private int theme;
    private Timer timer;
    int level;
    boolean levelPassed;
    /**
    storyIsShownForHp is a boolean flag for campaign mode to show the story according to its theme
    storyIsShownForGoT is a boolean flag for campaign mode to show the story according to its theme
     */
    boolean storyIsShownForHP;
    boolean storyIsShownForGoT;

    int remainingTime; //an integer which presents remaining time for challenge mode
    private JButton returnPrev;

    /**
    Game constructor to construct a game object
    @param level: int (the game's level)
    @param mode: int (mode of the game classical, campaign, challenge or developer)
    @param theme: int (game of thrones theme, harry potter theme)
     */
    public Game(int level, int mode, int theme){
        this.level = level;
        this.mode = mode;
        this.theme = theme;
        levelPassed = false;
        storyIsShownForHP = false;
        storyIsShownForGoT = false;
        /*
        CLASSICAL MODE: 0
        if mode is zero than a classical game will be created
         */
        if(mode == 0){
            walls = new Walls();

            levels = new Levels();
            map = levels.getLevels()[level];
            board = new GameBoard(map,mode, theme);

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

        /**
        DEVELOPER MODE : 1 Create
         */
        if(mode == 1){
            //System.out.println("sdasdada");
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


            board = new GameBoard(map,mode,theme);

            render = new Render();
            renderListener = new Timer(25,new RenderListener());
            renderListener.start();

        }

        /**
        CHALLENGE MODE : 2
         */
        if(mode == 2){
            returnPrev = new JButton("Back");
            remainingTime = 150;
            walls = new Walls();
            levels = new Levels();
            int random = (int )(Math.random() * 30+ 1);
            System.out.println("map no"+random);
            map = levels.getLevels()[random];
            board = new GameBoard(map,mode, theme);
            timer = new Timer(1000, new TimerListener());
            //timer.setRepeats(false);
            timer.start();
            render = new Render();
            renderListener = new Timer(25,new RenderListener());
            renderListener.start();

        }


        /**
        CAMPAIGN MODE : 3
         */
        if(mode == 3){

            walls = new Walls();

            levels = new Levels();
            map = levels.getLevels()[level];
            board = new GameBoard(map,mode, theme);

            render = new Render();
            renderListener = new Timer(25,new RenderListener());
            renderListener.start();
        }
        if(mode == 4){
            String mapCode = JOptionPane.showInputDialog(
                    null,
                    "Enter the Generated Map Code to Play",
                    "Generated Map Code Needed",
                    JOptionPane.WARNING_MESSAGE
            );
            walls = new Walls();

            //dadadada
            board = new GameBoard(map,mode, theme);
            System.out.println("asda");
            board.setUpCreatedMap(mapCode);
            render = new Render();
            renderListener = new Timer(25,new RenderListener());
            renderListener.start();


        }
    }
    public Game(Map map,int mode, int theme){
        this.level = -1;
        this.mode = mode;
        this.theme = theme;
        this.map = map;
        levelPassed = false;
        storyIsShownForHP = false;
        storyIsShownForGoT = false;
        walls = new Walls();
        board = new GameBoard(map,mode, theme);
        render = new Render();
        renderListener = new Timer(25,new RenderListener());
        renderListener.start();
    }

    /**
     *  setMode method to set game's mode
    @param mode: int the desired modes ID
     */
    public void setMode(int mode) {
        this.mode = mode;
    }

    /** getMode method to get game's mode
    @return mode: int the ID of the game's mode
     */
    public int getMode() {
        return mode;
    }

    /**
    getGameBoard method to get game board
    @return board: GameBoard as the game board which the whole game settled in
     */
    public GameBoard getGameBoard(){
        return board;
    }

    /**
    getWalls method to get the walls in the game
    @return a list of walls
     */
    public Wall[] getWalls()
    {
        return walls.getWalls();
    }


    /**
    getRender method to get the render of the game
    @return render: Render
     */
    public Render getRender() {
        return render;
    }

    /**
    checkWinCondition method to check if the given challenge is solved or not
    isGameFinished(): boolean
     @return true if the win condition satisfied, the game is finished
     @return false if the win condition is not datisfied, the game is not finished
     */
    public boolean checkWinCondition(){
        return getGameBoard().isGameFinished();
    }

    /**
     * showStory method to show the desired story for HarryPotter theme, in campaign Mode
     *
     */
    public void showStory()throws IOException {
        if (level == 4) {
            //ImageIcon harry = new ImageIcon("src/TheWall/images/harry.jpg");
            BufferedReader br = new BufferedReader(new FileReader("src/TheWall/stories/story.txt"));
            String aLineFromFile = null;
            if ((aLineFromFile = br.readLine()) != null) {
                JOptionPane.showMessageDialog(null, aLineFromFile, "Voldemort:", JOptionPane.INFORMATION_MESSAGE, voldemort);
                JOptionPane.showMessageDialog(null, "Never!", "Harry Potter:", JOptionPane.INFORMATION_MESSAGE, harry);
            }
            br.close();
        }
        if (level == 5) {
            JOptionPane.showMessageDialog(null, "You ağ a wizağd hağğy!!", "Ron:", JOptionPane.INFORMATION_MESSAGE, ron);
            JOptionPane.showMessageDialog(null, "That's true #lit", "Harry Potter:", JOptionPane.INFORMATION_MESSAGE, harry);
            JOptionPane.showMessageDialog(null, "You're a fool, Harry Potter, and you will lose everything.", "Voldemort:", JOptionPane.INFORMATION_MESSAGE, voldemort);
        }
        if (level == 6) {
            JOptionPane.showMessageDialog(null, "Greatness inspires envy, envy engenders spite, spite spawns lies, Harry", "Voldemort:", JOptionPane.INFORMATION_MESSAGE, voldemort);
        }
        if (level == 7) {
            JOptionPane.showMessageDialog(null, "How lies have fed your legend, Harry!"
                    , "Voldemort:", JOptionPane.INFORMATION_MESSAGE, voldemort);
            JOptionPane.showMessageDialog(null, "Do you want to know what really happened thirteen years ago? ", "Story:", JOptionPane.INFORMATION_MESSAGE, voldemort);
            JOptionPane.showMessageDialog(null, "Shall I divulge how I truly lost my powers? It was love"
                    , "Voldemort continues:", JOptionPane.INFORMATION_MESSAGE, voldemort);
            JOptionPane.showMessageDialog(null, " when dear sweet Lily Potter gave her life for her only son, it provided him with the ultimate protection"
                    , "Voldemort continues more and more:", JOptionPane.INFORMATION_MESSAGE, voldemort);
            JOptionPane.showMessageDialog(null, "But no matter, no matter, things have changed. I CAN TOUCH YOU… NOW!, ","Voldemort again:", JOptionPane.INFORMATION_MESSAGE, voldemort);
        }
    }
    /**
     * showStory method to show the desired story for Game of Thrones theme, in campaign Mode
     *
     */
    public void showStoryforGoT() {
        if (level == 4) {
            //ImageIcon harry = new ImageIcon("src/TheWall/images/harry.jpg");
            JOptionPane.showMessageDialog(null, "asdJUUkk,dI!@", "A Sample White Walker:", JOptionPane.INFORMATION_MESSAGE, nk);
            JOptionPane.showMessageDialog(null, "Winter is coming we should be together!", "Jon Snow:", JOptionPane.INFORMATION_MESSAGE, jon);
        }
        if (level == 5) {
            JOptionPane.showMessageDialog(null, "I will kill all the Starks!!", "Cersei:", JOptionPane.INFORMATION_MESSAGE, cersei);
            JOptionPane.showMessageDialog(null, "I will kill you!", "Arya:", JOptionPane.INFORMATION_MESSAGE, arya);
            }
        if (level == 6) {
            JOptionPane.showMessageDialog(null, "Red Woman Melisandre, you resurrected me!", "Jon Snow:", JOptionPane.INFORMATION_MESSAGE, jon);
            JOptionPane.showMessageDialog(null, "You, my lord; you are the ONE!", "The Red Woman:", JOptionPane.INFORMATION_MESSAGE, melis);
        }
        if (level == 7) {
            JOptionPane.showMessageDialog(null, "Arya! I thought you were dead"
                    , "Jon Snow:", JOptionPane.INFORMATION_MESSAGE, jon);
            JOptionPane.showMessageDialog(null, "Long story bro"
                    , "Arya Stark:", JOptionPane.INFORMATION_MESSAGE, arya);
             }
    }

    private class RenderListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            render.update();
            if(checkWinCondition() == true && (mode == 0 || mode == 4)){
                JOptionPane.showMessageDialog(null, "You Passed The Level " , "You Passed The Level", JOptionPane.INFORMATION_MESSAGE);
                renderListener.stop();
            }
            if(checkWinCondition() == true && mode == 3){
                JOptionPane.showMessageDialog(null, "You Passed The Level " , "You Passed The Level", JOptionPane.INFORMATION_MESSAGE);
                levelPassed = true;
                renderListener.stop();
            }
            if(!storyIsShownForHP && mode == 3 && theme == 1){

                try{
                    showStory();
                }
                catch(IOException e){
                    System.out.println("story is not found");
                }
                storyIsShownForHP = true;
            }
            if(!storyIsShownForGoT && mode == 3 && theme == 2){


                    showStoryforGoT();

                storyIsShownForGoT = true;
            }

        }
    }

    /**
     * TimerListener class to construct an instance of an ActionListener
     * this class is designed for the challenge mode
     * for the timer in it
     */
    private class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            /**
             * if he mode is 2 which represents the game is for challenge mode
             * then it decreases the remaining time
             * if the remaining time is zero and the win condition is not satisfied then a popup will be pushed
             * to tell user s/he failed
             * else a popup will be pushed to show s/he pass the level
             */
            if(mode == 2){
                remainingTime--;
                if(remainingTime ==0){
                    JOptionPane.showMessageDialog(null, "Time is up " , "Time is up", JOptionPane.INFORMATION_MESSAGE);
                    timer.stop();
                }
                if(remainingTime >0 && checkWinCondition()){
                    JOptionPane.showMessageDialog(null, "You Passed The Level " , "You Passed The Level", JOptionPane.INFORMATION_MESSAGE);
                    timer.stop();
                }
            }

        }
    }

    /**
     * a function to get remaining time
     * this function is using in challenge mode to get the time which user should pass the level in it
     * @return remainingTime: int as the remaining time to solve the challenge
     */
    public int getRemainingTime() {
        return remainingTime;
    }
    public void stopTimer(){
        timer.stop();
    }
}
