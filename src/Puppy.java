import java.awt.*;

/*public class Puppy implements Actor {
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
}*/

public class Puppy extends Actor {

    public Puppy(Cell loc) {
        this.loc = loc;
        Polygon ear1 = new Polygon();
        ear1.addPoint(loc.x + 5, loc.y + 5);
        ear1.addPoint(loc.x + 15, loc.y + 5);
        ear1.addPoint(loc.x + 5, loc.y + 15);
        Polygon ear2 = new Polygon();
        ear2.addPoint(loc.x + 20, loc.y + 5);
        ear2.addPoint(loc.x + 30, loc.y + 5);
        ear2.addPoint(loc.x + 30, loc.y + 15);
        Polygon face = new Polygon();
        face.addPoint(loc.x + 8, loc.y + 7);
        face.addPoint(loc.x + 27, loc.y + 7);
        face.addPoint(loc.x + 27, loc.y + 25);
        face.addPoint(loc.x + 8, loc.y + 25);

        polygon.add(ear1);
        polygon.add(ear2);
        polygon.add(face);
    }

}
