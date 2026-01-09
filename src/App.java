import java.util.ArrayList;
import java.util.*;
import processing.core.*;

public class App extends PApplet {
    Player hero = new Player(100, 0);
    PImage image;
    ArrayList<Bullet> bullets = new ArrayList<>();

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        image = loadImage("player.png");
    }

    public void settings() {
        size(500, 1000);
    }

    public void draw() {
        hero.move();
        background(29, 162, 216);
        for (Bullet b : bullets) { // chatgpt fixed this
            b.display();
            b.startMoving();
            b.moveUpScreen();
        }
        image(image, hero.getX(), hero.getY());
    }

    public void keyPressed() {
        if (keyCode == LEFT) {
            hero.moveLeft();
            if (hero.getX() < width - image.width) { // chatgpt suggestion
                hero.stopLeft();
            }

        }
        if (keyCode == RIGHT) {
            hero.moveRight();
            if (hero.getX() > width - image.width) { // chatgpt suggestion
                hero.stopRight();
            }
        }
        if (keyCode == ' ') {
            Bullet bullet = new Bullet(this, hero.getX() + 24, hero.getY());
            bullets.add(bullet);
        }
    }

    public void keyReleased() {
        if (keyCode == LEFT) {
            hero.stopLeft();
        }
        if (keyCode == RIGHT) {
            hero.stopRight();
        }
    }
}
