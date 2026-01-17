import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.io.IOException;
import processing.core.*;
import processing.sound.*;


public class App extends PApplet {
    Player hero = new Player(this, 100, 0);
    PImage image;
    PImage bullet;
    PImage badGuy;
    int highscore;
    int scene = 0;
    int occurence = 90;
    // SoundFile music;
    ArrayList<Bullet> bullets = new ArrayList<>();
    ArrayList<Enemy> enemies = new ArrayList<>();
    int score;

    public static void main(String[] args) {
        PApplet.main("App");
    }

    public void setup() {
        // music = new SoundFile(this, "bgm.mp3");
        image = loadImage("player.png"); // brings in player image
        // music.loop();
    try (Scanner scanner = new Scanner(Paths.get("highscore.txt"))){ // reads text file to see high score
        highscore = Integer.valueOf(scanner.nextLine());
    }
    catch(Exception e){
        System.out.println("error: " + e.getMessage());
    }
    }

    public void settings() { // defines window size
        size(500, 1000);
    }

    public void draw() {
        if (scene == 0){ // if it shows the opening screen - display opening text
            background(255);
            fill(1);
            textSize(40);
            text("Welcome to ---", 150, 300);
            text("Top Gun - the game!", 100, 450);
            text("Press space to start", 100, 600);
            for (int i = 0; i < enemies.size(); i++){
                enemies.remove(i);
            }
            if (keyCode == ' '){
                scene = 1;
            }
        }
        if (scene == 1){ // has the game happen
        hero.move();
        hero.checkLeft(); // checks to see if the player hits the wall
        hero.checkRight();
        background(29, 162, 216); // chatgpt told me to put background before i make the enemy.
        fill(1);
        text("score: " + score, 50, 100);
        for (int i = 0; i < bullets.size(); i++) { // calls the bullets to be displayed and moved up screen
            Bullet b = bullets.get(i);
            b.display();
            b.startMoving();
            b.moveUpScreen();
            b.destroy(); //checks to see if it should be destroyed
            if (b.destroy()) {
                bullets.remove(i);
                continue;
            }
            for (int x = 0; x < enemies.size(); x++) { //chatgpt reminded me to put brackets
                Enemy e = enemies.get(x); //calls the enemies to be displayed
                if (collision(b.getX(), b.getY(), e.getX(), e.getY())){ // checks collisions between enemies and bullets
                    System.out.println("collided");
                    bullets.remove(i);
                    enemies.remove(x);
                    score++; // adds to score
                }
            }
            

        }
        if (frameCount % occurence == 0) { // every x frames a new enemy comes on screen
            Enemy enemy = new Enemy(this, random(-15, 420));
            enemies.add(enemy);
        }

        for (int i = 0; i < enemies.size(); i++) {
            Enemy e = enemies.get(i); // chatgpt helped me get my enemy to move down the screen
            e.display();
            e.moveDownScreen(); //moves enemy down screen
                if (gameOver(hero.getX(), hero.getY(), e.getX(), e.getY())){ // checks to see if it collides with player
                    scene = 2; // end screen
                }
    }
        image(image, hero.getX(), hero.getY()); // displays player (would have made a display method for the player, but even when I did the exact same thing as the others, the window wouldnt even open.)
        addspeed(); // adds how often enemies come
}
        if (scene == 2){  // display end screen
        background(255);
        fill(1);
        textSize(30);
        text("Game over", 50, 50);
        if (score > highscore){ // chatgpt told me to put it outside of the try loop and before it
            highscore = score;
        }
        text("score: " + score, 100, 150);
        text("high score: " + highscore, 100, 200);
        text("Press r to restart! ", 100, 400);
        try (PrintWriter writer = new PrintWriter("highscore.txt")){ // writes highscore to file
            writer.println(highscore);
            writer.close();
            System.out.println("file writed sucessfully");
        }
            
        catch (IOException e){
            System.out.println("error: " + e.getMessage());
        }
        if (key == 'r'){ // restarts game
            score = 0;
            scene = 0;
            occurence = 90;
        }
     }
}
    public void keyPressed() {
        if (keyCode == LEFT) { // moves the player left
            hero.moveLeft();

        }
        if (keyCode == RIGHT) { // moves the player right
            hero.moveRight();
        }
        if (keyCode == ' ') { // launches a bullet
            Bullet bullet = new Bullet(this, hero.getX() + 24, hero.getY());
            bullets.add(bullet);
        }
    }

    public void keyReleased() { // if i let go of the key
        if (keyCode == LEFT) {
            hero.stopLeft();
        }
        if (keyCode == RIGHT) {
            hero.stopRight();
        }
    }

    public boolean collision(float x1, float y1, float x2, float y2) { // if a bullet collidedd with an enemy
        if (dist(x1 + hero.getCenterX(), y1 + hero.getCenterY(), x2, y2) < (50)) {
            return true;
        } else {
            return false;
        }

    }
    public boolean gameOver(float x1, float y1, float x2, float y2) { // if an enemy collieded with the player
        if (dist(x1, y1, x2, y2) < (50)) {
            return true;
        } else {
            return false;
        }

    }
    public void addspeed(){ // adds score as score increases, but stops at a point where it cant get harder.
        // did this not in a loop because I wanted it to add not the same amount each time, or a proportional amount.
        if (score >= 10 && score  <= 15){
            occurence = 80;
        }
        if (score >= 15 && score  <= 20){
            occurence = 70;
        }
        if (score >= 20 && score  <= 25){
            occurence = 60;
        }
        if (score >= 25 && score  <= 30){
            occurence = 56;
        }
        if (score >= 30 && score  <= 50){
            occurence = 46;
        }
        if (score >= 50 && score <= 75){
            occurence = 30;
        }
        if (score >= 75){
            occurence = 15;
        }
    }
}
