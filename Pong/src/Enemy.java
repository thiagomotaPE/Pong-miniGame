import java.awt.*;

public class Enemy {
    public double x, y;
    public int width, height;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 30;
        this.height = 140;
    }
    public void tick() {
        y += (Game.ball.y - y - 6) * 0.07;

    }
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect((int)x, (int)y, width, height);
    }
}
