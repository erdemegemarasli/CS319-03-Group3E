package TheWall;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
Creator: Erdem Ege Marasli and Ayca Begum Tascioglu
 This class controls all the panels and also this is the mainframe of the game.
 */
public class MainFrame extends JFrame
{
    private SimplePanel currentPanel;
    private Timer updateTimer;
    int theme;
    private int levelforCampaign;
    public MainFrame()
    {
        this.setSize(1200,600);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();
        theme = 0;

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
    public int increaseLevel(int level){
        level++;
        System.out.println("level increased"+level);
        return level;
    }

    public void setLevelforCampaign(int levelforCampaign) {
        this.levelforCampaign = levelforCampaign;
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
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }
                else if(currentPanel.getSelection() == 2)
                {
                    removeComp(currentPanel);
                    currentPanel = new CreditsScreen();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }
                else if(currentPanel.getSelection() == 3)
                {
                    removeComp(currentPanel);
                    currentPanel = new Settings();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }
                else if(currentPanel.getSelection() == 4)
                {
                    removeComp(currentPanel);
                    currentPanel = new HowToPlayScreen();
                    currentPanel.setTheme(theme);
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
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }
                else if(currentPanel.getSelection() == 2)
                {
                    removeComp(currentPanel);
                    currentPanel = new DeveloperMode();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);

                }
                else if(currentPanel.getSelection() == 3)
                {
                    removeComp(currentPanel);
                    Game game = new Game(0, 2, theme);
                    currentPanel = new GameViewer(game);
                    currentPanel.setTheme(theme);
                    game.getRender().addView((GameViewer)currentPanel);
                    addComp(currentPanel);
                    setVis(true);
                }
                else if(currentPanel.getSelection() == 4)
                {
                    removeComp(currentPanel);
                    currentPanel = new campaignSelectionPanel();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }
                else if(currentPanel.getSelection() == 0)
                {
                    removeComp(currentPanel);
                    currentPanel = new MainMenu();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }

            }
            else if(currentPanel.getType().equals("credits") || currentPanel.getType().equals("settings")
            || currentPanel.getType().equals("howToPlay"))
            {

                if(currentPanel.getSelection() == 0)
                {
                    theme = currentPanel.getTheme();
                    removeComp(currentPanel);
                    currentPanel = new MainMenu();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }

            }
            else if(currentPanel.getType().equals("classic"))
            {
                
                if(currentPanel.getSelection() == 0 ){
                    removeComp(currentPanel);
                    currentPanel = new LevelSelectionPanel();
                    currentPanel.setTheme(theme);
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
                    Game game = new Game(level, 0, theme);
                    currentPanel = new GameViewer(game);
                    currentPanel.setTheme(theme);
                    game.getRender().addView((GameViewer)currentPanel);
                    addComp(currentPanel);
                    setVis(true);


                }
                else if(currentPanel.getSelection() == 0)
                {
                    removeComp(currentPanel);
                    currentPanel = new PlayScreen();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }

            }
            else if(currentPanel.getType().equals("developerMode"))
            {
                if(currentPanel.getSelection() == 2) {
                    removeComp(currentPanel);
                    System.out.println("create");
                    Game game = new Game(1, 1, theme);
                    currentPanel = new GameViewer(game);
                    currentPanel.setTheme(theme);
                    game.getRender().addView((GameViewer)currentPanel);
                    addComp(currentPanel);
                    setVis(true);

                }
                else if(currentPanel.getSelection() == 1) {
                    //burası
                    String mapCode = JOptionPane.showInputDialog(
                            null,
                            "Enter the Generated Map Code to Play",
                            "Generated Map Code Needed",
                            JOptionPane.WARNING_MESSAGE
                    );
                    if(mapCode != null){
                        int [] squaresLocations = new int[16];
                        int [] edgeLocations = new int[26];
                        int [] horizontalLineLocations = new int[21];
                        int [] verticalLineLocations = new int[20];
                        int count = 0;
                        for(int i = 0; i < squaresLocations.length; i++){
                            squaresLocations[i] = Character.getNumericValue(mapCode.charAt(count));
                            count++;
                        }
                        for(int i = 0; i < edgeLocations.length; i++){
                            edgeLocations[i] = Character.getNumericValue(mapCode.charAt(count));
                            count++;
                        }
                        for(int i = 0; i < horizontalLineLocations.length; i++){
                            horizontalLineLocations[i] = Character.getNumericValue(mapCode.charAt(count));
                            count++;
                        }
                        for(int i = 0; i < verticalLineLocations.length; i++){
                            verticalLineLocations[i] = Character.getNumericValue(mapCode.charAt(count));
                            count++;
                        }
                        Map map = new Map(squaresLocations,edgeLocations,horizontalLineLocations,verticalLineLocations);
                        for(int i = 0; i <map.getSquareLocations().length;i++){
                            System.out.print(map.getSquareLocations()[i]);
                        }
                        removeComp(currentPanel);
                        Game game = new Game(map, 4, theme);
                        currentPanel = new GameViewer(game);
                        currentPanel.setTheme(theme);
                        game.getRender().addView((GameViewer)currentPanel);
                        addComp(currentPanel);
                        setVis(true);
                    }


                }
                else if(currentPanel.getSelection() == 0)
                {
                    removeComp(currentPanel);
                    currentPanel = new PlayScreen();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }
            }
            else if(currentPanel.getType().equals("developer"))
            {

                if(currentPanel.getSelection() == 0 ){
                    removeComp(currentPanel);
                    currentPanel = new DeveloperMode();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }
            }
            else if(currentPanel.getType().equals("challenge"))
            {

                if(currentPanel.getSelection() == 0 ){
                    removeComp(currentPanel);
                    currentPanel = new PlayScreen();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }
            }
            else if(currentPanel.getType().equals("campaignSelectionPanel"))
            {

                if(currentPanel.getSelection() == 0 ){
                    removeComp(currentPanel);
                    currentPanel = new PlayScreen();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }
                else if (currentPanel.getSelection() == 1){
                    levelforCampaign = 4;
                    removeComp(currentPanel);
                    int tmp = theme;
                    theme = 1;
                    Game game = new Game(levelforCampaign, 3, 1);
                    currentPanel = new GameViewer(game);
                    currentPanel.setTheme(theme);
                    game.getRender().addView((GameViewer)currentPanel);
                    addComp(currentPanel);
                    setVis(true);
                    theme = tmp;
                }
                else if (currentPanel.getSelection() == 2){
                    levelforCampaign = 4;
                    removeComp(currentPanel);
                    removeComp(currentPanel);
                    int tmp = theme;
                    theme = 2;
                    Game game = new Game(levelforCampaign, 3, 2);
                    currentPanel = new GameViewer(game);
                    currentPanel.setTheme(theme);
                    game.getRender().addView((GameViewer)currentPanel);
                    addComp(currentPanel);
                    setVis(true);
                    theme = tmp;
                }
            }
            else if(currentPanel.getType().equals("campaign"))
            {

                if(currentPanel.getSelection() == 0 ){
                    removeComp(currentPanel);
                    currentPanel = new campaignSelectionPanel();
                    currentPanel.setTheme(theme);
                    addComp(currentPanel);
                    setVis(true);
                }
                else if(currentPanel.getSelection() == 19 && currentPanel.theme ==1){
                    int newLevel = increaseLevel(levelforCampaign);
                    setLevelforCampaign(newLevel);
                    removeComp(currentPanel);
                    int tmp = theme;
                    theme = 1;
                    Game game = new Game(newLevel, 3, 1);
                    currentPanel = new GameViewer(game);
                    currentPanel.setTheme(theme);
                    game.getRender().addView((GameViewer)currentPanel);
                    addComp(currentPanel);
                    setVis(true);
                    theme = tmp;
                }
                else if(currentPanel.getSelection() == 19 && currentPanel.theme ==2){
                    int newLevel = increaseLevel(levelforCampaign);
                    setLevelforCampaign(newLevel);
                    removeComp(currentPanel);
                    int tmp = theme;
                    theme = 2;
                    Game game = new Game(newLevel, 3, 2);
                    currentPanel = new GameViewer(game);
                    currentPanel.setTheme(theme);
                    game.getRender().addView((GameViewer)currentPanel);
                    addComp(currentPanel);
                    setVis(true);
                    theme = tmp;
                }
            }


        }
    }

}
