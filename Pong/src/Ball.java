import java.awt.*;
import java.util.Random;

public class Ball {
    public double x, y, dx, dy;
    public double speed = 3;
    public int width, height;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 15;
        this.height = 15;

        dx = new Random().nextGaussian();
        dy = new Random().nextGaussian();
    }
    public void tick() {
        x += dx*speed;
        y += dy*speed;
    }
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)x, (int)y, width, height);
    }
}
