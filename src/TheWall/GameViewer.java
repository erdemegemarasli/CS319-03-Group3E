package TheWall;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
    private JButton backButton = new JButton("Go Back");
    private JLabel timerLabel;
    private JButton saveTheMap = new JButton("Save the Map");

    JLabel mapName = new JLabel("mapName:");

    JButton nextLevel = new JButton("next");
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
            MouseListener mouseListen = new MouseListener(walls, board);
            this.addMouseListener(mouseListen);
            this.addMouseMotionListener(mouseListen);
            this.setFocusable(true);
            //repaint();
        }
        else if(game.getMode() == 1){
            type = "developer";
            selection = 1;
            this.setLayout(null);
            this.setBackground(Color.GRAY);

            saveTheMap.addActionListener(new ButtonListener());
            saveTheMap.setLocation(200, 500);
            saveTheMap.setSize(100,20);
            this.add(saveTheMap);

            mapName.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            mapName.setLocation(50, 500);
            this.add(mapName);

            JTextField textField1 = new JTextField();
            textField1.setToolTipText("Map name");
            textField1.setSize(130,20);
            textField1.setLocation(70, 500);

            //SERVER CONNECTION USERNAME INPUT: usernameInput
            String mapnameInput = textField1.getText();

            mapName.setLabelFor(textField1);
            this.add(textField1);

            backButton.setLocation(1100,500);
            backButton.setSize(100,100);
            this.add(backButton);
            backButton.addActionListener(new ButtonListener());



            this.game = game;
            board = game.getGameBoard();
            walls = game.getWalls();
            MouseListener mouseListen = new MouseListener(walls, board);
            this.addMouseListener(mouseListen);
            this.addMouseMotionListener(mouseListen);
            this.setFocusable(true);
            //repaint();
        }

        else if(game.getMode() == 2){
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
            MouseListener mouseListen = new MouseListener(walls, board);
            this.addMouseListener(mouseListen);
            this.addMouseMotionListener(mouseListen);
            this.setFocusable(true);
            //repaint();
        }

        if(game.getMode() == 3){
            type = "campaign";
            selection = 1;
            this.setLayout(null);
            this.setBackground(Color.GRAY);
            nextLevel.setLocation(1100,300);
            nextLevel.setSize(100,100);
            this.add(nextLevel);
            backButton.setLocation(1100,500);
            backButton.setSize(100,100);
            this.add(backButton);
            backButton.addActionListener(new ButtonListener());

            this.game = game;
            board = game.getGameBoard();
            walls = game.getWalls();
            MouseListener mouseListen = new MouseListener(walls, board);
            this.addMouseListener(mouseListen);
            this.addMouseMotionListener(mouseListen);
            this.setFocusable(true);
            //repaint();
        }
        if(game.getMode() == 4){
            type = "devPlay";
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
            MouseListener mouseListen = new MouseListener(walls, board);
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
            else if(event.getSource() == saveTheMap){
                String mapData = game.getGameBoard().returnCreatedMap();
                JOptionPane.showMessageDialog(null, "Map Code Generate Succesful and copied to the clipboard. Just paste the copied code to the play screen in order to play. You can even send the code to your friends to challange them","Map Code Generate Succesful", JOptionPane.INFORMATION_MESSAGE);
                StringSelection selection = new StringSelection(mapData);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(selection, selection);

                System.out.println(mapData);

            }
            if(event.getSource() == nextLevel)
                selection = 1;
        }
    }
    //update method to call repaint
    public void update()
    {
        repaint();
    }

}
