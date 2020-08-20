import java.awt.*;

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

    public Lion(Cell loc) {
        this.loc = loc;
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

        polygon.add(mane);
        polygon.add(face);

    }

}
