package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreditsScreen extends SimplePanel{
    JButton returnPrev = new JButton("Back");
    public CreditsScreen() {
        super();
        type = "credits";
        JLabel title = new JLabel("Credits");
        this.add(title);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        ButtonListener buttonListen = new ButtonListener();
        JLabel dev1 = new JLabel("Ayça Begum Tascioglu");
        JLabel dev2 = new JLabel("Erdem Ege Marasli");
        JLabel dev3 = new JLabel("Ensar Kaya");
        JLabel dev4 = new JLabel("Hammad Malik");
        JLabel dev5 = new JLabel("Alperen Koca");
        returnPrev.addActionListener(buttonListen);
        this.add(dev1);
        this.add(dev2);
        this.add(dev3);
        this.add(dev4);
        this.add(dev5);
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
