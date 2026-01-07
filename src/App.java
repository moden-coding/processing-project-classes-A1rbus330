import processing.core.*;

public class App extends PApplet{
           Player hero = new Player(100, 0);
           PImage image;
               public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        image = loadImage("player.png");
    }

    public void settings(){
        size(500, 1000);
    }

    public void draw(){
        background(29, 162, 216);
        image(image, hero.getX(), hero.getY());
    }
    public void keyPressed(){
        if (keyCode == LEFT){
            hero.moveLeft();
        }
        if (keyCode == RIGHT){
            hero.moveRight();
        }
    }
}
