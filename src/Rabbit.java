
import java.awt.*;

/*public class Rabbit implements Actor {
    // Cell cell;
    int x;
    int y;

    public Rabbit(Cell cell) {
        this.x = cell.x;
        this.y = cell.y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(x, y, Cell.size, Cell.size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, Cell.size, Cell.size);
        
    }

} */

public class Rabbit extends Actor {

    public Rabbit(Cell loc) {
        this.loc = loc;
        this.colour = Color.WHITE;
    }

}
