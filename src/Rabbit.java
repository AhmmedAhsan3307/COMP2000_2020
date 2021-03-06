
import java.awt.*;
import java.util.ArrayList;

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

    public Rabbit(Cell loc, float redness) {
        this.setLocation(loc);
        this.redness = redness;
        this.colour = Color.WHITE;
        this.turns = 1;
        this.moves = 5;
        this.animationBeat = AnimationBeat.getInstance();
    }

    public void setPoly() {
        this.display = new ArrayList<Polygon>();
        Polygon ear1 = new Polygon();
        ear1.addPoint(loc.x + 11, loc.y + 5);
        ear1.addPoint(loc.x + 11, loc.y + 12);
        ear1.addPoint(loc.x + 16, loc.y + 12);
        ear1.addPoint(loc.x + 16, loc.y + 5);
        Polygon ear2 = new Polygon();
        ear2.addPoint(loc.x + 19, loc.y + 5);
        ear2.addPoint(loc.x + 19, loc.y + 12);
        ear2.addPoint(loc.x + 24, loc.y + 12);
        ear2.addPoint(loc.x + 24, loc.y + 5);
        Polygon face = new Polygon();
        face.addPoint(loc.x + 8, loc.y + 12);
        face.addPoint(loc.x + 27, loc.y + 12);
        face.addPoint(loc.x + 27, loc.y + 25);
        face.addPoint(loc.x + 8, loc.y + 25);
        this.display.add(ear1);
        this.display.add(ear2);
        this.display.add(face);
    }

}
