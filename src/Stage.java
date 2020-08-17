import java.awt.*;

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
    Actor puppy;
    Actor lion;
    Actor rabbit;

    public Stage() {
        grid = new Grid();
        puppy = new Puppy(grid.cellAtColRow(0, 0));
        lion = new Lion(grid.cellAtColRow(0, 18));
        rabbit = new Rabbit(grid.cellAtColRow(14, 3));

    }

    public void paint(Graphics g, Point mouseLoc) {
        grid.paint(g, mouseLoc);
        puppy.paint(g);
        lion.paint(g);
        rabbit.paint(g);
    }
}
