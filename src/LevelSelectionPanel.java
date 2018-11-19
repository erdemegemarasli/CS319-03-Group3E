package TheWall;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;

public class LevelSelectionPanel extends SimplePanel
{
    JButton buttons[] = new JButton[80];
    JButton returnPrev = new JButton("RETURN MAIN MENU");
    public LevelSelectionPanel()
    {
        super();
        type = "levelSelection";
        this.setLayout(new GridLayout(10,8));
        ButtonListener listener = new ButtonListener();
        for (int i = 0; i < 80; i++){
            int tmp = i+1;
            String str = "Level "+ tmp;
            buttons[i] = new JButton(str);
            buttons[i].addActionListener(listener);
            this.add(buttons[i]);
        }
        this.add(returnPrev, BorderLayout.PAGE_END);

    }
    private class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent event)
        {
            for ( int i = 0; i < 80; i++) {
                if (event.getSource() == buttons[i]) {
                    selection = i + 1;
                }
            }
            if (event.getSource() == returnPrev){
                selection = 0;
            }
        }
    }
}