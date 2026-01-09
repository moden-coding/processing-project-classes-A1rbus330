import processing.core.*;

public class Bullet {
    private PApplet canvas;
    private Player hero;
    private float x;
    private float y;
    private boolean up;
    public Bullet(PApplet c, float xpos, float ypos) { // chatgpt helped me with PApplet stuff
        canvas = c;
        x = xpos + 25;
        y = ypos;
    }
    public void startMoving(){
        up = true;
    }
    public void moveUpScreen(){
        if (up == true){
        y-=5;
        }
    }
    public void display(){
        canvas.circle(x, y, 10);
    }

}
