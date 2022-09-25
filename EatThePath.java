import processing.core.PApplet;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class EatThePath extends PApplet {
    int x, y;
    Mode mode = Mode.SEARCHING;

    Map<Integer, Integer[]> directionalMap = Map.of(
            0, new Integer[] {-1, -1},  //NW
            1, new Integer[] {0, -1},       //N
            2, new Integer[] {1, -1},       //NE
            3, new Integer[] {1, 0},        //E
            4, new Integer[] {1, 1},        //SE
            5, new Integer[] {0, 1},        //S
            6, new Integer[] {-1, 1},       //SW
            7, new Integer[] {-1, 0}        //W
    );

    int mat_width;
    int mat_height;
    int block_size = 2;
    boolean[][] occupied;

    int white = 255;
    int black = 0;

    public boolean try_direction(Map<Integer, Integer[]> directionalMap, int dval) {
        Integer[] direction = directionalMap.get(dval);
        Integer[] l_offset = directionalMap.get(dval - 1);
        Integer[] r_offset = directionalMap.get((dval + 1) % 8);
        if (!(is_occupied(direction) || is_occupied(l_offset) || is_occupied(r_offset))) {
            move_and_mark(direction);
            return true;
        }
        return false;
    }

    public void move_and_mark(Integer[] dir) {
        x = (x + dir[0] + mat_width) % mat_width;
        y = (y + dir[1] + mat_height) % mat_height;
        set_block(x,y);
    }

    public boolean is_occupied(Integer[] xy) {
        return occupied[(x + xy[0] + mat_width) % mat_width][(y + xy[1] + mat_height) % mat_height];
    }

    public void try_all_cardinal_directions() {
        ArrayList<Integer> sequence = new ArrayList<>(Arrays.asList(1, 3, 5, 7));
        while(sequence.size() > 0) {
            if(try_direction(directionalMap, sequence.remove((int) random(0, sequence.size())))) {
                return;
            }
        }
        mode = Mode.SEARCHING;
    }

    public void generate_matrix() {
        mat_width = width/2;
        mat_height = height/2;
        occupied = new boolean[mat_width][mat_height];
    }

    public void settings() {size(200,200);}

    public void setup() {
        background(white);
        generate_matrix();
        fill(black);
    }

    public enum Mode {SEARCHING, FOUND}

    public void set_block(int bx, int by) {
        occupied[bx][by] = true;
        rect(bx*block_size, by*block_size, block_size, block_size);
    }

    public Boolean get_block(int bx, int by) {
        if (bx < 0 || bx >= mat_width) {
            return false;
        } else if (by < 0 || by >= mat_height) {
            return false;
        }
        return occupied[bx][by];
    }

    public void draw() {
        if (mode == Mode.SEARCHING) {
            x = (int) random(0, mat_width);
            y = (int) random(0, mat_height);
            mode = Mode.FOUND;
            try_all_cardinal_directions();
        } else {
            try_all_cardinal_directions();
        }
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        EatThePath mySketch = new EatThePath();
        PApplet.runSketch(processingArgs, mySketch);
    }
}

