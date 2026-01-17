import processing.core.PApplet;
import processing.core.PImage;
import processing.core.*;

public class Enemy {
    private float x;
    private float y;
    private PApplet canvas;
    private PImage image;
    public Enemy(PApplet c, float xPos){
        canvas = c; //chatgpt
        x = xPos;
        y = 0;
        image = canvas.loadImage("image.png");
    }
    public float getX(){ //returns x value
        return x;
    }
    public float getY(){ // returns y value
        return y;
    }
    public void moveDownScreen(){ // moves it down the screen
        y+=5;
    }
    public void display(){ //displays it on the screen
        canvas.image(image, x, y);
    }
}
