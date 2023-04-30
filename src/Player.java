import java.awt.*;
import java.util.ArrayList;

public class Player {

    private int x, y;
    private Graphics g;
    String direction;
    private ArrayList<Blob> blobs;

    public Player(int x, int y, Graphics g){
        this.x = x;
        this.y = y;
        this.g = g;
        this.blobs = new ArrayList<Blob>();
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
        grow();
        for (Blob b: blobs) {
            b.update();
        }

        draw();
    }

    public void grow(){
        blobs.add(new Blob(x - 20, y, g));
        blobs.get(blobs.size() - 1).direction = direction;
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
