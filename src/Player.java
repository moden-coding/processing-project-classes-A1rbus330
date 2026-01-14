import processing.core.*;

public class Player{
    private int health;
    private PImage image;
    private int x;
    private int y;
    private boolean left;
    private boolean right;
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
        left = true;
    }
    public void moveRight(){
        right = true;
    }
    public void stopLeft(){
        left = false;
    }
    public void stopRight(){
        right = false;
    }
    public void move(){
        if (right == true){
            x+= 3;
        }
        if (left == true){
            x-=3;
        }
    }
    // public void isTouchingLeft(){
    //     if (x - 24 < 0){
    //         x = 0;
    //     }
    // }
    // public void isTouchingRight(){
    //     if (x + 24 > 500){
    //         x = 500;
    //     }
    // }
}