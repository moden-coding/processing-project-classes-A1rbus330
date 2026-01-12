import java.util.ArrayList;
import java.util.*;
import processing.core.*;

public class App extends PApplet {
    Player hero = new Player(100, 0);
    PImage image;
    PImage bullet;
    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    int score;

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
        Enemy enemy = new Enemy(random(450));
        enemies.add(enemy);
        enemy.moveDownScreen();
        circle(enemy.getX(), enemy.getY(), 50);
        hero.move();
        background(29, 162, 216);
        for (Bullet b : bullets) { // chatgpt fixed this
            b.display();
            b.startMoving();
            b.moveUpScreen();
            if
        }
        image(image, hero.getX(), hero.getY());
        fill(255);
        text("score: " + score, 0, 0);
    }

    public void keyPressed() {
        if (keyCode == LEFT) {
            hero.moveLeft();
            hero.isTouchingLeft();

        }
        if (keyCode == RIGHT) {
            hero.moveRight();
            hero.isTouchingRight();
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
