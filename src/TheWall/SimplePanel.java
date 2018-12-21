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
    ImageIcon img = new ImageIcon("src/TheWall/images/Background.jpg");
    //Image newi = img.getScaledInstance(1200,600,Image.SCALE_SMOOTH);
    public SimplePanel()
    {
        selection = -1;
        theme = 0;
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
    void setImageIcon(int imageID){
        if (imageID == 0){
            img  = new ImageIcon("src/TheWall/images/Background.jpg");
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //g.setColor(Color.pink);
        if (img != null) {
            img.paintIcon(null, g, 0, 0);
        }
    }

    public void update(){
        repaint();
    }

    public void setBackgroundofPanel(Color color){
        this.setBackground(color);
    }

}
