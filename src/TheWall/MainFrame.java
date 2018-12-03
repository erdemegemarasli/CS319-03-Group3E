package TheWall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame
{
    private SimplePanel currentPanel;
    private Timer updateTimer;
    public MainFrame()
    {
        this.setSize(1200,600);
        this.add(new JLabel(new ImageIcon("BackGround.jpg")));
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();

        int x = (dim.width / 2) - (this.getWidth() / 2);
        int y = (dim.height / 2) - (this.getHeight() / 2);

        this.setLocation(x,y);
        this.setResizable(false);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        //mainPanel
        currentPanel = new MainMenu();
        this.add(currentPanel);
        this.setVisible(true);
        updateTimer = new Timer(100,new UpdateListener());
        updateTimer.start();
    }
    public void addComp(Component c){
        this.add(c);
    }
    public void removeComp(Component c){
        this.remove(c);
    }
    public void setVis(boolean b)
    {
        this.setVisible(b);
    }
    private class UpdateListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(currentPanel.getType().equals("mainScreen"))
            {
                if(currentPanel.getSelection() == 1)
                {
                    removeComp(currentPanel);
                    currentPanel = new PlayScreen();
                    addComp(currentPanel);
                    setVis(true);
                }
                else if(currentPanel.getSelection() == 2)
                {

                }
            }
            else if(currentPanel.getType().equals("playScreen"))
            {

                if(currentPanel.getSelection() == 1)
                {
                    removeComp(currentPanel);
                    currentPanel = new LevelSelectionPanel();
                    addComp(currentPanel);
                    setVis(true);
                }
                else if(currentPanel.getSelection() == 0)
                {
                    removeComp(currentPanel);
                    currentPanel = new MainMenu();
                    addComp(currentPanel);
                    setVis(true);
                }

            }
            else if(currentPanel.getType().equals("levelSelection"))
            {
                if(currentPanel.getSelection() > 0)
                {
                    int level = currentPanel.getSelection() -1;
                    removeComp(currentPanel);
                    Game game = new Game(level);
                    currentPanel = new GameViewer(game);
                    game.getRender().addView((GameViewer)currentPanel);
                    addComp(currentPanel);
                    setVis(true);



                }
                else if(currentPanel.getSelection() == 0)
                {
                    removeComp(currentPanel);
                    currentPanel = new PlayScreen();
                    addComp(currentPanel);
                    setVis(true);
                }
            }
            else if(currentPanel.getSelection() == 0 ){
                removeComp(currentPanel);
                currentPanel = new LevelSelectionPanel();
                addComp(currentPanel);
                setVis(true);
            }
        }
    }


}
