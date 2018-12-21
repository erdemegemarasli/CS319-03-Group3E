package TheWall;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpScreen extends SimplePanel {
    public static final Color VERY_LIGHT_BLUE = new Color(51,204,255);
    public static final Color MY_GREEN = new Color(89,180,100);
    JButton returnPrev = new JButton("Back");
    JButton signUpButton = new JButton("Sign Up");
    public SignUpScreen() {
        super();
        type = "signUpScreen";
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setBorder(new EmptyBorder(new Insets(300,400,300,400)));
        JLabel title = new JLabel("SignUp");
        //title.setMinimumSize(new Dimension(50,50));
        //title.setPreferredSize(new Dimension(50,50));
        //title.setMaximumSize(new Dimension(50,50));
        title.setForeground(Color.RED);
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        this.add(title);
        String[] labels = {"UserName: ", "Password: "};
        ButtonListener buttonListen = new ButtonListener();
        returnPrev.addActionListener(buttonListen);
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(VERY_LIGHT_BLUE);
        usernameLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(usernameLabel);
        JTextField textField1 = new JTextField();


        //SERVER CONNECTION USERNAME INPUT: usernameInput
        String usernameInput = textField1.getText();

        usernameLabel.setLabelFor(textField1);
        this.add(textField1);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(VERY_LIGHT_BLUE);
        passwordLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(passwordLabel);
        JTextField textField2 = new JTextField();

        //SERVER CONNECTION PASSWORD INPUT: passwordInput
        String passwordInput = textField2.getText();

        passwordLabel.setLabelFor(textField2);
        this.add(textField2);


        signUpButton.addActionListener(buttonListen);
        signUpButton.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(signUpButton);


        returnPrev.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        this.add(returnPrev);
    }
    public int getSelection(){
        return selection;
    }
    private class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == signUpButton) {
                selection = 1;
            }
            if(event.getSource() == returnPrev) {
                selection = 0;
            }
        }
    }
}
