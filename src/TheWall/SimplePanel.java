package TheWall;

import javax.swing.*;
import java.awt.*;

/*
Creator: Erdem Ege Marasli and Ayca Begum Tascioglu
 */
abstract class SimplePanel extends JPanel
{
    int selection;
    String type;
    int theme;
    ImageIcon img;
    public SimplePanel()
    {
        selection = -1;
        type = "";
    }

    public void setTheme(int theme) {
        this.theme = theme;
    }

    public int getTheme() {
        return theme;
    }

    public int getSelection()
    {
        return selection;
    }
    public String getType()
    {
        return type;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor(Color.pink);
        /*
        pinkfloyd
         */
        if (theme == 0) {
            img = new ImageIcon("src/TheWall/images/wallBackground.jpg");
            img.paintIcon(null, g, 0, 0);
        }
        /*
        harrypotter
         */
        else if (theme == 1) {
            img = new ImageIcon("src/TheWall/images/hpBackground.jpg");
            img.paintIcon(null, g, 0, 0);
        }
        /*
        gameofthrones
         */
        else if (theme == 2) {
            img = new ImageIcon("src/TheWall/images/got.jpg");
            img.paintIcon(null, g, 0, 0);
        }
        /*
        mountains
         */
        else if (theme == 3) {
            img = new ImageIcon("src/TheWall/images/Background.jpg");
            img.paintIcon(null, g, 0, 0);
        }
        /*
        brick
         */
        else if (theme == 4) {
            img = new ImageIcon("src/TheWall/images/Background2.jpg");
            img.paintIcon(null, g, 0, 0);
        }
    }

    public void update(){
        repaint();
    }


}
