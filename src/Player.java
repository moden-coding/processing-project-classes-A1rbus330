import processing.core.*;

public class Player{
    int health;
    PImage image;
    int x;
    int y;
    public Player(int h, int xpos){
        health = h;
        x = xpos;
        y = 600;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void moveLeft(){
        x--;
    }
    public void moveRight(){
        x++;
    }
}