import processing.core.*;

public class Bullet {
    private PImage image;
    private PApplet canvas;
    private Player hero;
    private float x;
    private float y;
    private boolean up;
    public Bullet(PApplet c, float xpos, float ypos) { // chatgpt helped me with PApplet stuff
        canvas = c;
        x = xpos + 25;
        y = ypos;
        image = canvas.loadImage("bullet.png");
        image.resize(8, 8);

    }
    public void startMoving(){ // starts moving
        up = true;
    }
    public void moveUpScreen(){ // moves it up the screen
        if (up == true){
        y-=5;
        }
    }
    public void display(){ // displays it on the screen
        canvas.image(image, x - 4, y);
    }
    public float getX(){ // returns the x value
        return x;
    }
    public float getY(){ // returns the y value
        return y;
    }
    public boolean destroy(){ // gets rid of the bullets when not needed
        if (y ==0){
            return true;
        }
        else{
            return false;
        }
    }

}
