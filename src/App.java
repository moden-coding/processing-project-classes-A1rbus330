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
        if (hero.left == true) {
            hero.x -= 3;
        }
        if (hero.right == true) {
            hero.x += 3;
        }
        background(29, 162, 216);
        for (Bullet b : bullets) { // chatgpt fixed this
            if ((b.up)) {
                b.moveUpScreen();
                circle(b.x, b.y, 10);
            }
            for (int i = Integer.valueOf(b.y); i < 0; i--){

        }
        }
        image(image, hero.getX(), hero.getY());
    }

    public void keyPressed() {
        if (keyCode == LEFT) {
            hero.left = true;

        }
        if (keyCode == RIGHT) {
            hero.right = true;
        }
        if (keyCode == ' ') {
            Bullet bullet = new Bullet(hero.x, hero.y);
            bullets.add(bullet);
            circle((bullet.x + 25), bullet.y, 10);
            bullet.up = true;
        }
    }

    public void keyReleased() {
        if (keyCode == LEFT) {
            hero.left = false;
        }
        if (keyCode == RIGHT) {
            hero.right = false;
        }
    }
}
