import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;
import java.util.*;

/*public class Stage {
    Grid grid = new Grid();
    Actor actors[] = new Actor[3];

    public Stage() {
        actors[0] = new Rabbit(grid.cells[1][2]);
        actors[1] = new Lion(grid.cells[5][4]);
        actors[2] = new Puppy(grid.cells[10][8]);
        
    }

    public void paint(Graphics g) {

        for (int i = 0; i < actors.length; i++) {
            actors[i].paint(g);
        }
    }
}*/

public class Stage {
    Grid grid;
    ArrayList<Actor> actors;
    List<Cell> cellOverlay;
    Optional<Actor> actorInAction;

    enum State {
        ChoosingActor, SelectingNewLocation, CPUMoving
    }

    State currentState = State.ChoosingActor;

    public Stage() {
        grid = new Grid();
        actors = new ArrayList<Actor>();
        cellOverlay = new ArrayList<Cell>();
        currentState = State.ChoosingActor;
    }

    public void paint(Graphics g, Point mouseLoc) {

        // do we have AI moves to make
        if (currentState == State.CPUMoving) {
            for (Actor a : actors) {
                if (!a.isTeamRed()) {
                    List<Cell> possibleLocs = getClearRadius(a.loc, a.moves);
                    int moveCPUChooses = (new Random()).nextInt(possibleLocs.size());
                    a.setLocation(possibleLocs.get(moveCPUChooses));
                }
            }
            currentState = State.ChoosingActor;
            for (Actor a : actors) {
                a.turns = 1;
            }
        }
        grid.paint(g, mouseLoc);
        grid.paintOverlay(g, cellOverlay, new Color(0f, 0f, 1f, 0.5f));

        for (Actor a : actors) {
            a.paint(g);
        }
        // state display
        g.setColor(Color.DARK_GRAY);
        g.drawString(currentState.toString(), 720, 20);

        Optional<Cell> cap = grid.cellAtPoint(mouseLoc);
        if (cap.isPresent()) {
            Cell capc = cap.get();
            g.setColor(Color.DARK_GRAY);
            g.drawString(String.valueOf(capc.col) + String.valueOf(capc.row), 720, 50);
        }
        // agent display
        int yloc = 138;
        for (int i = 0; i < actors.size(); i++) {
            Actor a = actors.get(i);
            g.drawString(a.getClass().toString(), 720, yloc + 50 * i);
            g.drawString("location:", 730, yloc + 13 + 50 * i);
            g.drawString(Character.toString(a.loc.col) + Integer.toString(a.loc.row), 840, yloc + 13 + 50 * i);
            g.drawString("redness:", 730, yloc + 26 + 50 * i);
            g.drawString(Float.toString(a.redness), 840, yloc + 26 + 50 * i);
        }
    }

    public List<Cell> getClearRadius(Cell from, int size) {
        List<Cell> init = grid.getRadius(from, size);
        for (Actor a : actors) {
            init.remove(a.loc);
        }
        return init;
    }

    public void mouseClicked(int x, int y) {
        switch (currentState) {
            case ChoosingActor:
                actorInAction = Optional.empty();
                for (Actor a : actors) {
                    if (a.loc.contains(x, y) && a.isTeamRed() && a.turns > 0) {
                        cellOverlay = grid.getRadius(a.loc, a.moves);
                        actorInAction = Optional.of(a);
                        currentState = State.SelectingNewLocation;
                    }
                }
                break;
            case SelectingNewLocation:
                Optional<Cell> clicked = Optional.empty();
                for (Cell c : cellOverlay) {
                    if (c.contains(x, y)) {
                        clicked = Optional.of(c);
                    }
                }
                cellOverlay = new ArrayList<Cell>();
                if (clicked.isPresent() && actorInAction.isPresent()) {
                    actorInAction.get().setLocation(clicked.get());
                    actorInAction.get().turns--;
                    int redsWithMovesLeft = 0;
                    for (Actor a : actors) {
                        if (a.isTeamRed() && a.turns > 0) {
                            redsWithMovesLeft++;
                            if (a.loc.row % 2 == 1) {
                                a.loc.col = 0;
                            }
                        }
                    }
                    if (redsWithMovesLeft > 0) {
                        currentState = State.ChoosingActor;
                    } else {
                        currentState = State.CPUMoving;
                    }
                }
                break;
            default:
                System.out.println(currentState);
                break;
        }

    }
}
