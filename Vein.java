import processing.core.PApplet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import org.apache.commons.io.FileUtils;

public class Vein extends PApplet {

    Queue<TransientRandomWalker> veins = new ArrayDeque<>();

    float incSize = 0.0001f;
    float maxSteps = 1000;
    float steps = 0;

    float divisionProbability = 0.005f;

    public void settings() {size(900,900);}

    public void setup() {
        steps = maxSteps;
        background(255);
        fill(0);
        for (int i = 0; i < 10; i++) {
            float x = random(0, width);
            float y = random(0, height);
            veins.add(new TransientRandomWalker(this, x, y, 10, 1000, incSize));
        }

        File file = new File("output");
        try {
            FileUtils.cleanDirectory(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void draw() {
        if (steps > 0) {
            float alpha = map(steps, maxSteps, 0, 0, 10);
            System.out.println(alpha);
            fill(0, alpha);
            stroke(0, alpha);
            int veins_remaining = veins.size();
            while (veins_remaining > 0) {
                TransientRandomWalker vein = veins.poll();
                vein.step2();
                if (random(0,1) < divisionProbability) {
                    TransientRandomWalker newVein = new TransientRandomWalker(
                            this, vein.x, vein.y, vein.size, vein.steps, incSize
                    );
                    veins.add(newVein);
                }

                if (vein.steps > 0) {
                    veins.add(vein);
                }
                veins_remaining -= 1;
            }
//        saveFrame("output/frame-########.png");
            steps--;
        } else {
            saveFrame("output/frame-########.png");
            exit();
        }

    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        Vein mySketch = new Vein();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
