import processing.core.PApplet;
import java.util.Random;

public class Walker extends PApplet {
    double x;
    double y;
    float t = 0.0f;
    float tInc = 0.01f;
    Random rand = new Random();
    private PApplet sketch;


    Walker(PApplet sketch) {
        this.sketch = sketch;
        x = (double) this.sketch.width/2;
        y = (double) this.sketch.height/2;
    }

    void display() {
//        this.sketch.stroke(0);
        int R = (int) this.sketch.map(this.sketch.noise(1f, t), 0.0f, 1.0f, 0f, 255f);
        int G = (int) this.sketch.map(this.sketch.noise(2f, t), 0.0f, 1.0f, 0f, 255f);
        int B = (int) this.sketch.map(this.sketch.noise(3f, t), 0.0f, 1.0f, 0f, 255f);
        this.sketch.stroke(R,G,B);
        this.sketch.point((int) x, (int) y);
    }

    void step() {
//        double stepx = rand.nextGaussian();
//        double stepy = rand.nextGaussian();
        double stepx = rand.nextInt(3) - 1;
        double stepy = rand.nextInt(3) - 1;

        x += stepx;
        y += stepy;

        t += tInc;

    }

    float montecarlo() {
        while(true) {
            float r1 = rand.nextFloat(1);
            float probability = r1;
            float r2 = rand.nextFloat(1);
            if (r2 < probability) {
                return r1;
            }
        }
    }
}
