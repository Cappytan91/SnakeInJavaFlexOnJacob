import java.awt.*;

public class Blob {

    private int x, y;
    private Graphics g;
    String direction;

    public Blob(int x, int y, Graphics g){
        this.x = x;
        this.y = y;
        this.g = g;
        this.direction = "r";
    }

    public void update(){
        if(direction.equals("u")){
            y -= 20;
        }else if(direction.equals("d")){
            y += 20;
        }else if(direction.equals("l")){
            x -= 20;
        }else if(direction.equals("r")){
            x += 20;
        }

        draw();
    }

    public void draw(){
        g.drawOval(x, y, 20, 20);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

}
