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
    Image img = Toolkit.getDefaultToolkit().createImage("src/images/Background.jpg");
    Image newi = img.getScaledInstance(1200,600,Image.SCALE_SMOOTH);
    public SimplePanel()
    {
        selection = -1;
        type = "";
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
        g.setColor(Color.pink);
        if (img != null) {
            g.drawImage(newi,0, 0, null);
            //System.out.println("oluyo");
        }
    }

    public void update(){
        repaint();
    }

    public void setBackgroundofPanel(Color color){
        this.setBackground(color);
    }

}
