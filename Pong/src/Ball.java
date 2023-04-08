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
        if(y + (dy*speed) + height >= Game.HEIGHT) {
            dy*= 1;
        }else if(y + (dy*speed) < 0) {
            dy*= -1;
        }

        if(x >= Game.WIDTH) {
            //ponto do inimigo
        }else if(x < 0) {
            //ponto do jogador
        }

        Rectangle bounds = new Rectangle((int)(x + (dx*speed)), (int)(y + (dy*speed)), width, height);
        Rectangle boundsPlayer = new Rectangle(Game.player.x, Game.player.y, Game.player.width, Game.player.height);
        Rectangle boundsEnemy = new Rectangle((int)Game.enemy.x, (int)Game.enemy.y, Game.enemy.width, Game.enemy.height);

        if(bounds.intersects(boundsPlayer)) {
            dx*= -1;
        }else if(bounds.intersects(boundsEnemy)) {
            dx*= -1;
        }



        x += dx*speed;
        y += dy*speed;
    }
    public void render(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval((int)x, (int)y, width, height);
    }
}
