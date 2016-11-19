/**
 * Created by Sathianporn Khamdee on 8/11/2559.
 */
import ucigame.*;
import java.util.*;

public class BattleCITY_main extends Ucigame{
    int x,y;
    Sprite tank;
    public void setup()
    {
        window.size(800, 800);
        window.title("BattleCITY");
        window.showFPS();
        canvas.background(0, 0, 0);

        tank = makeSprite(getImage("images/tank.png"));
        x = canvas.width() / 2;
        y = canvas.height() / 2;
        tank.position(x, y);

        framerate(30);

    }
    public void draw()
    {
        canvas.clear();

        tank.draw();
    }
}
