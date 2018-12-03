package TheWall;

import java.util.ArrayList;

public class Render {
    private Viewer view;
    public Render(){

    }
    public void update(){
        view.update();
    }
    public void addView (Viewer v)
    {
        view = v;
    }
}
