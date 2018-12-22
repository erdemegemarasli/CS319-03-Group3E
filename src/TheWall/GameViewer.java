package TheWall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Creator: Erdem Ege Marasli
 */
//
//0 -255- 51
public class GameViewer extends SimplePanel implements Viewer {
    public static final Color FOSFORLU_YESIL = new Color(0,255,51);
    private Game game;
    private GameBoard board;
    private Wall[] walls;
    private Map playerMap;
    private JButton backButton = new JButton("Go Back");
    private JLabel timerLabel;

    Render render;
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
        for(int i = 0; i < 4; i++) {
            if (walls[i].isMoving())
                walls[i].draw(g);
        }
        if ( game.getMode() == 2 ) {
            g.setColor(FOSFORLU_YESIL);
            g.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
            g.drawString("Time: " + game.getRemainingTime(), 500, 30);
        }

    }
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == backButton)
                selection = 0;
        }
    }
    //update method to call repaint
    public void update()
    {
        repaint();
    }

}
