package TheWall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Creator: Erdem Ege Marasli
 */

public class GameViewer extends SimplePanel implements Viewer {
    private Game game;
    private GameBoard board;
    private Wall[] walls;
    private Map playerMap;
    private JButton backButton = new JButton("Go Back");
    private JLabel timerLabel;
    private Timer timer = new Timer(50,new TimerListener());
    public GameViewer(Game game){
        super();
        if(game.getMode() == 0){
            type = "classic";
            selection = 1;
            this.setLayout(null);
            this.setBackground(Color.GRAY);
            backButton.setLocation(1100,500);
            backButton.setSize(100,100);
            this.add(backButton);
            backButton.addActionListener(new ButtonListener());

            this.game = game;
            board = game.getGameBoard();
            walls = game.getWalls();
            playerMap = game.getPlayerMap();
            MouseListener mouseListen = new MouseListener(walls, board, playerMap);
            this.addMouseListener(mouseListen);
            this.addMouseMotionListener(mouseListen);
            this.setFocusable(true);
            //repaint();
        }
        if(game.getMode() == 1){
            type = "developer";
            selection = 1;
            this.setLayout(null);
            this.setBackground(Color.GRAY);
            backButton.setLocation(1100,500);
            backButton.setSize(100,100);
            this.add(backButton);
            backButton.addActionListener(new ButtonListener());

            this.game = game;
            board = game.getGameBoard();
            walls = game.getWalls();
            playerMap = game.getPlayerMap();
            MouseListener mouseListen = new MouseListener(walls, board, playerMap);
            this.addMouseListener(mouseListen);
            this.addMouseMotionListener(mouseListen);
            this.setFocusable(true);
            //repaint();
        }

        if(game.getMode() == 2){
            type = "challenge";
            selection = 1;

            timerLabel = new JLabel();
            timerLabel.setLocation(500,10);
            timerLabel.setSize(100,100);

            int time = 3600;
            Timer timer = new Timer(time, e->timerLabel.setText("Done"));
            timer.setRepeats(false);
            timer.start();
            /*
            long now = System.currentTimeMillis();
            int remaining = time - (int)now;
            String rem = ""+remaining;

            timerLabel.setText(rem);
            */
            this.add(timerLabel);
            this.setLayout(null);
            this.setBackground(Color.GRAY);
            backButton.setLocation(1100,500);
            backButton.setSize(100,100);
            this.add(backButton);
            backButton.addActionListener(new ButtonListener());

            this.game = game;
            board = game.getGameBoard();
            walls = game.getWalls();
            playerMap = game.getPlayerMap();
            MouseListener mouseListen = new MouseListener(walls, board, playerMap);
            this.addMouseListener(mouseListen);
            this.addMouseMotionListener(mouseListen);
            this.setFocusable(true);
            //repaint();
        }

    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        board.draw(g);
        for(int i = 0; i < 4; i++)
            walls[i].draw(g);
        for(int i = 0; i < 4; i++)
            if(walls[i].isMoving())
                walls[i].draw(g);


    }
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == backButton)
                selection = 0;

        }
    }
    private class TimerListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
    //update method to call repaint
    public void update()
    {
        repaint();
    }

}
