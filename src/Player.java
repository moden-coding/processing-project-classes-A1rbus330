import processing.core.*;
public class Player{
    private int x;
    private int y;
    private boolean left;
    private boolean right;
    private PApplet canvas;
    public Player(PApplet c, int h, int xpos){
        x = xpos;
        y = 600;
        canvas = c;
    }
    public float getX(){ // returns the x value
        return x;
    }
    public float getY(){// returns the y value
        return y;
    }
    public void moveLeft(){// moves the player to the left
        left = true;
    }
    public void moveRight(){// moves the player to the right
        right = true;
    }
    public void stopLeft(){//stops the player
        left = false;
    }
    public void stopRight(){//stops the player
        right = false;
    }
    public void move(){ // lets them move
        if (right == true){
            x+= 3;
        }
        if (left == true){
            x-=3;
        }
    }
    public float getCenterX(){ // returns the middle
        return -50;
    }
    public float getCenterY(){
        return -10;
    }
    public void checkLeft(){ // sees if it is at the left wall
        if (x < -15){
            x = -15;
        }
    }
    public void checkRight(){// sees if it is at the right wall
        if (x > 425){
            x = 425;
        }
    }
}