package TheWall;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/*
Creator: Erdem Ege Marasli and Ayca Begum Tascioglu
 */
public class MainFrame extends JFrame
{
    private SimplePanel currentPanel;
    private Timer updateTimer;
    public MainFrame()
    {
        this.setSize(1200,600);
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
                    removeComp(currentPanel);
                    currentPanel = new CreditsScreen();
                    addComp(currentPanel);
                    setVis(true);
                }
                else if(currentPanel.getSelection() == 3)
                {
                    removeComp(currentPanel);
                    currentPanel = new Settings();
                    addComp(currentPanel);
                    setVis(true);
                }
                else if(currentPanel.getSelection() == 4)
                {
                    removeComp(currentPanel);
                    currentPanel = new HowToPlayScreen();
                    addComp(currentPanel);
                    setVis(true);
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
                else if(currentPanel.getSelection() == 2)
                {
                    removeComp(currentPanel);
                    currentPanel = new LoginScreen();
                    addComp(currentPanel);
                    setVis(true);

                }
                if(currentPanel.getSelection() == 3)
                {
                    removeComp(currentPanel);
                    Game game = new Game(0, 2, 1); // bura değişicek theme e göre
                    currentPanel = new GameViewer(game);
                    game.getRender().addView((GameViewer)currentPanel);
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
            else if(currentPanel.getType().equals("credits") || currentPanel.getType().equals("settings")
            || currentPanel.getType().equals("howToPlay"))
            {

                if(currentPanel.getSelection() == 0)
                {
                    removeComp(currentPanel);
                    currentPanel = new MainMenu();
                    addComp(currentPanel);
                    setVis(true);
                }

            }
            else if(currentPanel.getType().equals("classic"))
            {
                
                if(currentPanel.getSelection() == 0 ){
                    removeComp(currentPanel);
                    currentPanel = new LevelSelectionPanel();
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
                    Game game = new Game(level, 0, 1); // bura değişicek theme e göre
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
            //MEANINGLESS
            /*
            else if(currentPanel.getSelection() == 0 ){
                removeComp(currentPanel);
                currentPanel = new LevelSelectionPanel();
                addComp(currentPanel);
                setVis(true);
            }
            */

            else if(currentPanel.getType().equals("loginScreen"))
            {
                //login
                if(currentPanel.getSelection() == 1)
                {
                    removeComp(currentPanel);
                    currentPanel = new DeveloperMode();
                    addComp(currentPanel);
                    setVis(true);
                    /*
                    removeComp(currentPanel);
                    Game game = new Game(1, 1, 1); // bura değişicek theme e göre
                    currentPanel = new GameViewer(game);
                    game.getRender().addView((GameViewer)currentPanel);
                    addComp(currentPanel);
                    setVis(true);
                    */

                }
                else if(currentPanel.getSelection() == 2)
                {
                    removeComp(currentPanel);
                    currentPanel = new SignUpScreen();
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
            else if(currentPanel.getType().equals("signUpScreen"))
            {
                //signup
                if(currentPanel.getSelection() == 1) {


                }
                else if(currentPanel.getSelection() == 0)
                {
                    removeComp(currentPanel);
                    currentPanel = new PlayScreen();
                    addComp(currentPanel);
                    setVis(true);
                }
            }
            else if(currentPanel.getType().equals("developerMode"))
            {
                if(currentPanel.getSelection() == 2) {
                    removeComp(currentPanel);
                    System.out.println("create");
                    Game game = new Game(1, 1, 1); // bura değişicek theme e göre
                    currentPanel = new GameViewer(game);
                    game.getRender().addView((GameViewer)currentPanel);
                    addComp(currentPanel);
                    setVis(true);

                }
                else if(currentPanel.getSelection() == 1) {
                    removeComp(currentPanel);
                    currentPanel = new DesignedMapSelection();
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
            else if(currentPanel.getType().equals("developer"))
            {

                if(currentPanel.getSelection() == 0 ){
                    removeComp(currentPanel);
                    currentPanel = new DeveloperMode();
                    addComp(currentPanel);
                    setVis(true);
                }
            }
            else if(currentPanel.getType().equals("designedMapSelection"))
            {

                if(currentPanel.getSelection() == 0 ){
                    removeComp(currentPanel);
                    currentPanel = new DeveloperMode();
                    addComp(currentPanel);
                    setVis(true);
                }
                if(currentPanel.getSelection() == 1 ){
                    /*FOR

                    TRY

                     */
                    removeComp(currentPanel);
                    Game game = new Game(0, 2, 1); // bura değişicek theme e göre
                    currentPanel = new GameViewer(game);
                    game.getRender().addView((GameViewer)currentPanel);
                    addComp(currentPanel);
                    setVis(true);
                }
            }
            else if(currentPanel.getType().equals("challenge"))
            {

                if(currentPanel.getSelection() == 0 ){
                    removeComp(currentPanel);
                    currentPanel = new PlayScreen();
                    addComp(currentPanel);
                    setVis(true);
                }
            }

        }
    }

}
