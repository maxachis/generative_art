import processing.core.PApplet;

import java.util.Map;

import static processing.core.PApplet.map;
import static processing.core.PApplet.print;

public class TransientRandomWalker {

    float x, y, tx, ty;
    float initialSize;
    float size;
    int maxSteps;
    int steps;
    PApplet sketch;
    float incSize;
    float val;
    float originalDirection;

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

    public TransientRandomWalker(PApplet sketch , float x, float y, float initialSize, int steps, float incSize) {
        this.sketch = sketch;
        this.initialSize = initialSize;
        this.maxSteps = steps;
        this.steps = steps;
        this.x = x;
        this.y = y;
        this.tx = sketch.random(0, 10000);
        this.ty = tx + 10000 + sketch.random(0, 10000);
        this.incSize = incSize;
        this.originalDirection = sketch.random(0f, 8f);
    }

    void step() {
        this.steps--;
        x = x + sketch.map(sketch.noise(tx), 0, 1, -1, 1);
        y = y + sketch.map(sketch.noise(ty), 0, 1, -1, 1);
        tx += incSize;
        ty += incSize;
        size = sketch.map(steps, maxSteps, 0, initialSize, 1);
//        float alpha = sketch.map(steps, maxSteps, 0, 0, 255);
//        System.out.println(alpha);
//        sketch.fill(0, alpha);
//        sketch.stroke(0, alpha);
        sketch.ellipse(x, y, size, size);
    }

    void step2() {
        float gaussianCenter;
        try {
            this.steps--;
            gaussianCenter = originalDirection + sketch.map(sketch.noise(tx, ty), 0, 1, 0, 8);
            val = (2 * sketch.randomGaussian() + gaussianCenter + 16) % 8;
            Integer[] xy = directionalMap.get((int) val);
            x += xy[0];
            y += xy[1];

            size = sketch.map(steps, maxSteps, 0, initialSize, 1);
            tx += incSize;
            ty += incSize;
            sketch.ellipse(x, y, size, size);
        } catch (NullPointerException e) {
            print("Whoopsy");
        }


    }
}
