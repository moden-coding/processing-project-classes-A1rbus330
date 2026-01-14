import java.util.ArrayList;
import java.util.*;
import processing.core.*;

public class App extends PApplet {
    Player hero = new Player(100, 0);
    PImage image;
    PImage bullet;
    PImage badGuy;
    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    int score;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        badGuy = loadImage("sukhoi.png");
        image = loadImage("player.png");

    }

    public void settings() {
        size(500, 1000);
    }

    public void draw() {
        hero.move();
        background(29, 162, 216); // chatgpt told me to put background before i make the enemy.
        for (int i = 0; i < bullets.size(); i++) {
            Bullet b = bullets.get(i);
            b.display();
            b.startMoving();
            b.moveUpScreen();
            b.destroy();
            for (int x = 0; i < enemies.size(); i++){
                Enemy e = enemies.get(i);
            if (collision(b.getX(), b.getY(), e.getX(), e.getY()))
                System.out.println("collided");
                    bullets.remove(b);
            }

        }
        if (frameCount % 90 == 0) {
            Enemy enemy = new Enemy(this, random(450));
            enemies.add(enemy);
        }

        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i); // chatgpt helped me get my enemy to move down the screen
            e.display();
            e.moveDownScreen();
        }
        image(image, hero.getX(), hero.getY());
        fill(255);
        text("score: " + score, 0, 0);
    }

    public void keyPressed() {
        if (keyCode == LEFT) {
            hero.moveLeft();

        }
        if (keyCode == RIGHT) {
            hero.moveRight();
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

    public boolean collision(float w, float x, float y, float z) {
        if (dist(w, x, y, z) < (50 / 2 + 50 / 2)) {
            return true;
        } else {
            return false;
        }

    }
}
