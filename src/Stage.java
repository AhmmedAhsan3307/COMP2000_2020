import java.awt.*;

public class Stage {
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
}