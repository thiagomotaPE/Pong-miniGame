import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable, KeyListener {

    public static int WIDTH = 240;
    public static int HEIGHT = 120;
    public static int SCALE = 4;

    public BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    public Player player;

    public Game() {
        this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        this.addKeyListener(this);

        player = new Player(0, 160);
    }
    public static void main(String[] args) {
        Game game = new Game();
        JFrame frame = new JFrame("Pong");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        new Thread(game).start();

    }

    public void tick() {
        player.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = layer.getGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g = bs.getDrawGraphics();
        g.drawImage(layer, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);

        player.render(g);

        bs.show();
    }

    @Override
    public void run() {
        while(true) {
            tick();
            render();
            try {
                Thread.sleep(1000/60);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            player.top = true;
        }else if(e.getKeyCode() == KeyEvent.VK_S) {
            player.bottom = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W) {
            player.top = false;
        }else if(e.getKeyCode() == KeyEvent.VK_S) {
            player.bottom = false;
        }
    }
}