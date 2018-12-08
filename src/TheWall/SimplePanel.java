package TheWall;

import javax.swing.*;
/*
Creator: Erdem Ege Marasli and Ayca Begum Tascioglu
 */
abstract class SimplePanel extends JPanel
{
    int selection;
    String type;
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
}
