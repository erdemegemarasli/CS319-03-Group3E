package TheWall;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
/*
Creator: Erdem Ege Marasli
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

    ImageIcon harry = new ImageIcon("src/TheWall/images/harry.jpg");
    ImageIcon voldemort = new ImageIcon("src/TheWall/images/voldemort.jpg");
    ImageIcon hermione = new ImageIcon("src/TheWall/images/hermione.jpg");
    ImageIcon ron = new ImageIcon("src/TheWall/images/ron.jpg");
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
    boolean storyIsShown;

    int remainingTime;
    private JButton returnPrev;
    public Game(int level, int mode, int theme){
        this.level = level;
        this.mode = mode;
        this.theme = theme;
        levelPassed = false;
        storyIsShown = false;
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

        /*
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

        /*
        CHALLENGE MODE : 2
         */
        if(mode == 2){
            returnPrev = new JButton("Back");
            remainingTime = 150;
            walls = new Walls();
            levels = new Levels();
            int random = (int )(Math.random() * 5+ 1);
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

        /*
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


    public Render getRender() {
        return render;
    }
    public boolean checkWinCondition(){
        return getGameBoard().isGameFinished();
    }

    public void showStory()throws IOException {
        if (level == 4) {
            //ImageIcon harry = new ImageIcon("src/TheWall/images/harry.jpg");
            BufferedReader br = new BufferedReader(new FileReader("src/TheWall/stories/story.txt"));
            String aLineFromFile = null;
            if ((aLineFromFile = br.readLine()) != null) {
                JOptionPane.showMessageDialog(null, aLineFromFile, "Story:", JOptionPane.INFORMATION_MESSAGE, voldemort);
                JOptionPane.showMessageDialog(null, "Never!", "Story:", JOptionPane.INFORMATION_MESSAGE, harry);
            }
            br.close();
        }
        if (level == 5) {
            JOptionPane.showMessageDialog(null, "You ağ a wizağd hağğy!!", "Story:", JOptionPane.INFORMATION_MESSAGE, ron);
            JOptionPane.showMessageDialog(null, "That's true #lit", "Story:", JOptionPane.INFORMATION_MESSAGE, harry);
            JOptionPane.showMessageDialog(null, "You're a fool, Harry Potter, and you will lose everything.", "Story:", JOptionPane.INFORMATION_MESSAGE, voldemort);
        }
        if (level == 6) {
            JOptionPane.showMessageDialog(null, "Greatness inspires envy, envy engenders spite, spite spawns lies, Harry", "Story:", JOptionPane.INFORMATION_MESSAGE, voldemort);
        }
        if (level == 7) {
            JOptionPane.showMessageDialog(null, "How lies have fed your legend, Harry!"
                    , "Story:", JOptionPane.INFORMATION_MESSAGE, voldemort);
            JOptionPane.showMessageDialog(null, "Do you want to know what really happened thirteen years ago? ", "Story:", JOptionPane.INFORMATION_MESSAGE, voldemort);
            JOptionPane.showMessageDialog(null, "Shall I divulge how I truly lost my powers? It was love"
                    , "Story:", JOptionPane.INFORMATION_MESSAGE, voldemort);
            JOptionPane.showMessageDialog(null, " when dear sweet Lily Potter gave her life for her only son, it provided him with the ultimate protection"
                    , "Story:", JOptionPane.INFORMATION_MESSAGE, voldemort);
            JOptionPane.showMessageDialog(null, "But no matter, no matter, things have changed. I CAN TOUCH YOU… NOW!, ","Story:", JOptionPane.INFORMATION_MESSAGE, voldemort);
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
            if(!storyIsShown && mode == 3 && theme == 1){

                try{
                    showStory();
                }
                catch(IOException e){
                    System.out.println("story is not found");
                }
                storyIsShown = true;
            }

        }
    }

    private class TimerListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
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

    public int getRemainingTime() {
        return remainingTime;
    }
}
