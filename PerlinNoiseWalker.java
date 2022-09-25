import processing.core.PApplet;
import java.util.Random;

public class PerlinNoiseWalker {

    PApplet sketch;
    float x, y, g, tx, ty, tg;


    PerlinNoiseWalker(PApplet sketch) {
        this.sketch = sketch;
        tx = 0;
        ty = 10000;
        tg = -10000;
    }

    void step() {
        x = sketch.map(sketch.noise(tx), 0, 1, 0, sketch.width);
        y = sketch.map(sketch.noise(ty), 0, 1, 0, sketch.height);
        g = sketch.map(sketch.noise(tg), 0, 1, 0, 255);
        sketch.ellipse(x, y, 16, 16);
        sketch.fill(g);
        tx += 0.01;
        ty += 0.01;
        tg += 0.05;
    }

    void onDraw() {
        this.step();
    }
}
