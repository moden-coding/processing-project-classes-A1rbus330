import processing.core.*;

public class Bullet {
    Player hero;
    float x;
    float y;
    boolean up;
    public Bullet(int xpos, int ypos) {
        x = xpos + 25;
        y = ypos;
    }
    public void moveUpScreen(){
        y-=5;
    }

}
