public class Enemy {
    private float x;
    private float y;
    public Enemy(float xPos){
        x = xPos;
        y = 0;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void moveDownScreen(){
        y++;
    }
}
