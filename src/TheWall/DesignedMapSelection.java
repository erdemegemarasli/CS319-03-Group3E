package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesignedMapSelection extends SimplePanel {
    Map[] list = new Map[4];
    JComboBox maps = new JComboBox(list);
    JButton returnPrev = new JButton("Back");

    public DesignedMapSelection()
    {
        super();
        type = "designedMapSelection";
        JLabel title = new JLabel("Choose a Map to Play!");
        title.setForeground(Color.RED);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        this.add(title);

        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        ButtonListener buttonListen = new ButtonListener();

        this.add(maps);
        returnPrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        returnPrev.addActionListener(buttonListen);
        this.add(returnPrev);

    }
    public int getSelection(){
        return selection;
    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == returnPrev) {
                selection = 0;
            }
        }
    }

}
