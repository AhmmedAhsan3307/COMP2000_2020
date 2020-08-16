import java.awt.*;

public class Puppy implements Actor {
    int x;
    int y;

    public Puppy(Cell cell) {
        this.x = cell.x;
        this.y = cell.y;
    }

    public void paint(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(x, y, Cell.size, Cell.size);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, Cell.size, Cell.size);
    }

}