package TheWall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
Creator: Erdem Ege Marasli and Ayca Begum Tascioglu
 */
public class LevelSelectionPanel extends SimplePanel
{
    JButton buttons [];
    JButton returnPrev;
    public LevelSelectionPanel()
    {
        super();
        type = "levelSelection";
        this.setLayout(new GridLayout(10,10));
        buttons= new JButton[64];
        ButtonListener buttonListen = new ButtonListener();
        for(int i = 0; i < 64; i++)
        {
            String str = "Level "+(i + 1);
            buttons[i] = new JButton(str);
            buttons[i].addActionListener(buttonListen);
            this.add(buttons[i]);
        }
        returnPrev= new JButton("GO BACK");
        returnPrev.addActionListener(buttonListen);
        this.add(returnPrev);


    }
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            for(int i = 0; i < 64; i++)
            {
                if(event.getSource() == buttons[i])
                {
                    selection = i+1;
                }
            }
            if(event.getSource() == returnPrev){
                selection = 0;
            }
        }
    }
}
