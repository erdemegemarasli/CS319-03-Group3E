package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Container;

public class LoginScreen extends SimplePanel{
    JButton returnPrev = new JButton("Back");
    public LoginScreen() {
        super();
        type = "loginScreen";
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        JLabel title = new JLabel("Sign In");
        title.setMinimumSize(new Dimension(50,50));
        title.setPreferredSize(new Dimension(50,50));
        title.setMaximumSize(new Dimension(50,50));
        title.setForeground(Color.RED);
        this.add(title);
        String[] labels = {"UserName: ", "Password: "};
        ButtonListener buttonListen = new ButtonListener();
        returnPrev.addActionListener(buttonListen);
        //Create and populate the panel.

        for (int i = 0; i < 2; i++) {
            JLabel l = new JLabel(labels[i], JLabel.TRAILING);
            this.add(l);
            JTextField textField = new JTextField(5);
            l.setLabelFor(textField);
            this.add(textField);
        }

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
