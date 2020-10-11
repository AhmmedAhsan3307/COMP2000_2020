import java.awt.*;
import java.util.ArrayList;

/*public class Lion implements Actor {
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
}*/

public class Lion extends Actor {

    public Lion(Cell loc, float redness) {
        this.setLocation(loc);
        this.redness = redness;
        this.colour = Color.RED;
        this.turns = 1;
        this.moves = 1;
        this.animationBeat = AnimationBeat.getInstance();
    }

    public void setPoly() {
        this.display = new ArrayList<Polygon>();
        Polygon mane = new Polygon();
        mane.addPoint(loc.x + 6, loc.y + 6);
        mane.addPoint(loc.x + 29, loc.y + 6);
        mane.addPoint(loc.x + 29, loc.y + 29);
        mane.addPoint(loc.x + 6, loc.y + 29);
        Polygon face = new Polygon();
        face.addPoint(loc.x + 11, loc.y + 11);
        face.addPoint(loc.x + 24, loc.y + 11);
        face.addPoint(loc.x + 24, loc.y + 24);
        face.addPoint(loc.x + 11, loc.y + 24);
        this.display.add(mane);
        this.display.add(face);
    }
}
