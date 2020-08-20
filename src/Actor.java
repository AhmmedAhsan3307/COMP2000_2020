import java.awt.*;
import java.util.ArrayList;

/*public interface Actor {
    void paint(Graphics g);
}*/

public abstract class Actor {
    ArrayList<Polygon> polygon = new ArrayList<Polygon>();

    Cell loc;

    public void paint(Graphics g) {
        g.setColor(Color.black);
        for (Polygon p : polygon) {
            g.drawPolygon(p);

        }
    }
}
