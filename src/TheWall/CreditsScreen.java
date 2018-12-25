package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Creator: Ayca Begum Tascioglu
 */
public class CreditsScreen extends SimplePanel{
    JButton returnPrev = new JButton("Back");
    public CreditsScreen() {
        super();
        type = "credits";
        JLabel title = new JLabel("Credits");
        title.setForeground(Color.RED);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        this.add(title);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        ButtonListener buttonListen = new ButtonListener();
        JLabel dev1 = new JLabel("Ayça Begum Tascioglu");
        dev1.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        dev1.setForeground(Color.GREEN);
        JLabel dev2 = new JLabel("Erdem Ege Marasli");
        dev2.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        dev2.setForeground(Color.GREEN);
        JLabel dev3 = new JLabel("Ensar Kaya");
        dev3.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        dev3.setForeground(Color.GREEN);
        JLabel dev4 = new JLabel("Hammad Malik");
        dev4.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        dev4.setForeground(Color.GREEN);
        JLabel dev5 = new JLabel("Alperen Koca");
        dev5.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
        dev5.setForeground(Color.GREEN);
        returnPrev.addActionListener(buttonListen);
        returnPrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));
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
