package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HowToPlayScreen extends SimplePanel {
    JButton returnPrev = new JButton("Back");
    public HowToPlayScreen() {
        super();
        type = "howToPlay";
        JLabel title = new JLabel("HowToPlay");
        title.setForeground(Color.RED);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        this.add(title);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        ButtonListener buttonListen = new ButtonListener();
        JLabel info = new JLabel("Choose a challenge. ");
        JLabel info1 = new JLabel("Choose a wall with left click of mouse");
        JLabel info2 = new JLabel( "Rotate the choosen wall with left click of mouse");
        JLabel info3 = new JLabel(" and place the wall with right click");
        JLabel info4 = new JLabel( "The red knights needed to kept outside, the blue ");
        JLabel info41 = new JLabel("knights and high towers needed to remain within the walls.");
        JLabel info5 = new JLabel("There is only one solution per challenge.");

        JLabel texts[] = {info, info1,info2,info3, info4,info41};
        for ( int i = 0; i < texts.length; i++){
            texts[i].setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
            this.add(texts[i]);
        }
        info5.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        this.add(info5);
        returnPrev.addActionListener(buttonListen);
        returnPrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 24));


        this.add(returnPrev);
    }

    public int getSelection(){
        return selection;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

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
