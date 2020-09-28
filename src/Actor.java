import java.awt.*;
import java.util.ArrayList;

public abstract class Actor {
    ArrayList<Polygon> polygon = new ArrayList<Polygon>();

    Cell loc;
    ArrayList<Polygon> display;
    MoveStrategy strat;
    float redness;
    int turns;
    int moves;
    Color colour;
    AnimationBeat animationBeat;

    public void paint(Graphics g) {

        for (Polygon p : display) {
            char animationBeatInst = animationBeat.inPhase();
            if (animationBeatInst == 'a') {
                g.setColor(Color.PINK);
            } else if (animationBeatInst == 'b') {
                g.setColor(Color.MAGENTA);
            } else {
                g.setColor(new Color(redness, 0f, 1f - redness));
            }
            // g.setColor(new Color(redness, 0f, 1f - redness));
            g.fillPolygon(p);
            g.setColor(Color.GRAY);
            g.drawPolygon(p);
        }
    }

    public abstract void setPoly();

    public boolean isTeamRed() {
        return redness >= 0.5;
    }

    public void setLocation(Cell loc) {
        this.loc = loc;
        if (this.loc.row % 2 == 0) {
            this.strat = new RandomMove();
        } else {
            this.strat = new LeftMostMove();
        }
        setPoly();
    }
}
