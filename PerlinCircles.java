import processing.core.PApplet;
import java.util.Random;


public class PerlinCircles extends PApplet {

    PApplet sketch;
    float t = 0.0f;
    float tInc = 0.01f;

    float minCircSize = 12;
    float maxCircSize = 75;

    PerlinCircles(PApplet sketch) {
        this.sketch = sketch;
    }

    void onSetup() {
//        int y = this.sketch.height/2;
        int R,G,B, circSize;
        for (int y = 0; y < this.sketch.height; y+=25) {
            for (int x = 0; x < this.sketch.width + maxCircSize; x+=5) {
                R = (int) this.sketch.map(this.sketch.noise(1f, t), 0.0f, 1.0f, 0f, 255f);
                G = (int) this.sketch.map(this.sketch.noise(2f, t), 0.0f, 1.0f, 0f, 255f);
                B = (int) this.sketch.map(this.sketch.noise(3f, t), 0.0f, 1.0f, 0f, 255f);
                circSize = (int) this.sketch.map(this.sketch.noise(t), 0.0f, 1.0f, minCircSize, maxCircSize);
//                this.sketch.fill(R,G,B);
                this.sketch.noFill();
                this.sketch.stroke(R,G,B);
                this.sketch.ellipse(x, y, circSize, circSize);
                t += tInc;
            }
        }
    }
}
