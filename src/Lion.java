import java.awt.*;

public class Lion implements Actor {
    int x;
    int y;

    public Lion(Cell cell) {
        this.x = cell.x;
        this.y = cell.y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(x, y, Cell.size, Cell.size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, Cell.size, Cell.size);
    }
}
/*
 * public class Lion extends Actor {
 * 
 * public Lion(Cell loc) { this.loc = loc; this.colour = Color.RED; }
 * 
 * }
 */