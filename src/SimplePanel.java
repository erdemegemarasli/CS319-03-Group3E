package TheWall;

import javax.swing.*;

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
