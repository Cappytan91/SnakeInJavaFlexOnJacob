import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Start {

    private JFrame frame;
    private boolean run;
    private Player player;

    public static void main(String[] args) throws InterruptedException {
        new Start();
    }

    public Start() throws InterruptedException {
        createWindow();
        this.run = true;
        this.player = new Player(100, 100, frame.getGraphics());
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(e.getKeyCode());
                if (e.getKeyCode() == 38 && !player.direction.equals("d")){
                    //up
                    player.setDirection("u");
                }else if(e.getKeyCode() == 37 && !player.direction.equals("r")){
                    //left
                    player.setDirection("l");
                }else if(e.getKeyCode() == 40 && !player.direction.equals("u")){
                    //down
                    player.setDirection("d");
                }else if(e.getKeyCode() == 39 && !player.direction.equals("l")){
                    //right
                    player.setDirection("r");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        while (run){
            Thread.sleep(300);


            frame.repaint();
        }
    }

    public void createWindow(){
        frame = new JFrame(){
            @Override
            public void paint(Graphics g) {
                //super.paint(g);
                g.clearRect(0, 0, 400, 400);
                Start.this.update();
            }
        };
        frame.setSize(400, 400);  // Set the size of the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
        frame.setTitle("Snake"); // Set the title of the frame
        frame.setVisible(true); // Show the frame
    }

    private void update(){
        player.update();
    }
}
