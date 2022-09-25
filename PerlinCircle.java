import Helpers.PerlinOrbit;
import processing.core.PApplet;
import processing.core.PGraphics;

import java.util.ArrayList;

public class PerlinCircle extends PApplet {

    float radius = 100;
    float radius2 = 400;
    float theta = 0;
    float thetaInc = 0.01f;
    float rx, ry;
    float t = 0;
    float tInc = 0.1f;
    float x1, x2, y1, y2;
    ArrayList<PerlinOrbit> pos = new ArrayList<>();
    ArrayList<PerlinOrbit> pos2 = new ArrayList<>();
    float rInc = 0.1f;
    PGraphics layer1, layer2;

    public void settings() {size(900,900);}

    public void setup() {
        layer1 =  createGraphics(900, 900);
        layer1.beginDraw();
        layer1.background(0, 0);
        layer1.endDraw();
        layer2 = createGraphics(900, 900);
        layer2.beginDraw();
        layer2.background(0, 0);
        layer2.endDraw();

        float rx = width/2;
        float ry = height/2;
        ellipse(rx, ry, 50, 50);
        background(255, 0);
        radius2 = map(noise(t), 0, 1, 390, 410);
        x2 = rx + radius2 * cos(theta);
        y2 = ry + radius2 * sin(theta);
        x1 = rx + radius2 * cos(theta);
        y1 = ry + radius2 * sin(theta);
        for (float theta = 0; theta <= TWO_PI; theta += PI/1) {
            for (float r = 650f; r >=600f; r-= 25f) {
                pos2.add(
                        new PerlinOrbit(this, r, r*0.05f, rx, ry, theta, 0.1f, this.layer2)
                );
                pos.add(
                        new PerlinOrbit(this, r, r*0.05f, rx, ry, theta, 0.05f, this.layer1)
                );
            }
        }

    }

    public void setupMultipleOrbits() {
        for (float r = 0; r < radius2; r += 25f) {
            pos.add(
                    new PerlinOrbit(this, r, r*0.05f, rx, ry, 0, 0.05f, this.layer1)
            );
        }
    }

    public void drawPerlinSpiral(PerlinOrbit p, PGraphics layer) {
        layer.beginDraw();
        while (p.radiusBase >= 0) {
            p.step();
            if (p.radiusBase < 5f) {
                p.radiusBase -= 0.01f;
            } else {
                p.radiusBase *= 0.9993f;
                p.radiusVar = p.radiusBase * 0.05f;
            }

        }
        p.reset();
//        p.grayscale = random(0, 50);

        layer.endDraw();
        image(layer, 0, 0);
    }

    public void draw() {
//        t += tInc;
//        theta += thetaInc;
//        float rx = width/2;
//        float ry = height/2;
//        float x = rx + radius * cos(theta);
//        float y = ry + radius * sin(theta);
//
//        Helpers.PerlinOrbit p;
//        for (int i = 0; i < pos.size(); i++) {
//            p = pos.get(i);
//            p.step();
//            p.radiusBase -= rInc;
//            p.radiusVar = p.radiusBase * 0.05f;
//            if (p.radiusBase <= 0) {
//                p.radiusBase = 450;
//                p.radiusVar = p.radiusBase * 0.05f;
//                p.reset();
//            }
//        }

    }

    public void mouseClicked() {
        for (int i = 0; i < pos2.size(); i++) {
            layer2.stroke(random(25, 50), 0, 0);
            drawPerlinSpiral(pos2.get(i), layer2);
        }
        for (int i = 0; i < pos.size(); i++) {
            layer1.stroke(random(0, 25));
            drawPerlinSpiral(pos.get(i), layer1);
        }
    }

    public float jitter(float val) {
        return val + random(-1, 1);
    }


    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        PerlinCircle mySketch = new PerlinCircle();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
