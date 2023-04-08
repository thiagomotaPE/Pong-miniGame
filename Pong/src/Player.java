import java.awt.*;

public class Player {

    public boolean top, bottom;
    public double speed = 2.5;
    public int x, y, width, height;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 30;
        this.height = 140;
    }
    public void tick() {
        if(top) {
            y -= speed;
        }else if(bottom) {
            y+= speed;
        }
        if(y + height < Game.HEIGHT - 120) {
            y = Game.HEIGHT + height + 90;
        }else if(y + height > Game.HEIGHT + 380) {
            y = Game.HEIGHT + height - 400;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);
    }
}
