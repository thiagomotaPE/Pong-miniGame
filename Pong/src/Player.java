import java.awt.*;

public class Player {

    public boolean top, bottom;
    public int x, y, width, height;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 30;
        this.height = 140;
    }
    public void tick() {
        if(top) {
            y--;
        }else if(bottom) {
            y++;
        }
        if(y + height < Game.HEIGHT - 120) {
            y = Game.HEIGHT + height + 220;
        }else if(y + height > Game.HEIGHT + 500) {
            y = Game.HEIGHT + height - 400;
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(x, y, width, height);
    }
}
