import processing.core.PApplet;
import processing.core.PImage;

public class Enemy {
    private float x;
    private float y;
    private PApplet canvas;
    private PImage image;
    public Enemy(PApplet c, float xPos){
        canvas = c; //chatgpt
        x = xPos;
        y = 0;
        image = canvas.loadImage("sukhoi.png");
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void moveDownScreen(){
        y+=5;
    }
    public void display(){
        canvas.image(image, x, y);
    }
}
