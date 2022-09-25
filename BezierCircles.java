import processing.core.PApplet;


import java.sql.Array;
import java.util.ArrayList;

public class BezierCircles extends PApplet {

    float rx = width/2f;
    float ry = height/2f;

    float theta = 0.0f;
    ArrayList<rotatingLine> l;
    ArrayList<rotatingBezier> b;

    float thetaMax = 0.03f;
    float thetaMin = -0.03f;

    int time_remaining = 900;
    float[][] rxy;
    float radiusMax = 500;
    float radiusMin = 100;

    public void settings() {
        size(700,700);
    }

    public void setup() {
        rxy = new float[][]{{width * (1f / 3f), height / 2f}, {width * (2f / 3f), height / 2f}};
        //TODO: Add multiple "blossoms" equidistant from each other. Maybe just 2. Maybe 5. Maybe more.
        strokeWeight(2);
        background(255);
        l = new ArrayList<>();
        b = new ArrayList<>();
        float[] radii = {0, 0, 0};
        float[] thetaSpeeds = {0, 0, 0};
//        for (int i = 0; i < 10; i++) {
//            l.add(new rotatingLine(rx, ry,
//                    random(radiusMin, radiusMax),
//                    random(thetaMin, thetaMax)));
//        }
        iteration2();
    }

    public void iteration1() {
        float[] radii = {0, 0, 0};
        float[] thetaSpeeds = {0, 0, 0};
//        for (int i = 0; i < 10; i++) {
//            l.add(new rotatingLine(rx, ry,
//                    random(radiusMin, radiusMax),
//                    random(thetaMin, thetaMax)));
//        }
        for (int i = 0; i < 20; i++) {
            radii = new float[] {0, 0, 0};
            thetaSpeeds = new float[] {0, 0, 0};
            for (int u = 0; u < 3; u++) {
                radii[u] = random(radiusMin, radiusMax);
                thetaSpeeds[u] = random(thetaMin, thetaMax);
            }
            b.add(new rotatingBezier(rx, ry,
                    radii,
                    thetaSpeeds));
        }
    }

    public void iteration2() {
        float[] radii = {100, 400, 700};
        float[] thetaSpeeds = {0, 0, 0};
        for (int o = 0; o < rxy.length; o++) {
            float x = rxy[o][0];
            float y = rxy[o][1];
            for (int i = 0; i < 80; i++) {
                thetaSpeeds = new float[] {0, 0, 0};
                for (int u = 0; u < 3; u++) {
                    thetaSpeeds[u] = random(thetaMin, thetaMax);
                }
                b.add(new rotatingBezier(x, y,
                        radii,
                        thetaSpeeds));
            }

        }

    }

    public void draw() {
//        translate(width/2,height/2);
        background(0);
//        rx = width/2f;
//        ry = height/2f;
        float x, y;
        float[] xy;
        float[] radii = {0, 0, 0};
        float[] thetas = {0, 0, 0};
        float[][] xys = {{0, 0}, {0, 0}, {0, 0}};
        for (int i = 0; i < b.size(); i++) {
//            l.get(i).updateTheta();
//            xy = getPointsOnCircle(rx, ry, l.get(i).radius, l.get(i).theta);
//            line(rx, ry, xy[0], xy[1]);
            //Bezier Curves
            x = b.get(i).rx;
            y = b.get(i).ry;
            b.get(i).updateTheta();
            radii = b.get(i).radii;
            thetas = b.get(i).theta;
            for (int u = 0; u < 3; u++) {
                xys[u] = getPointsOnCircle(x, y, radii[u], thetas[u]);
            }
            noFill();

            stroke(
                    map(noise(thetas[0]), 0, 1, 0, 255),
                    map(noise(thetas[1]), 0, 1, 0, 255),
                    map(noise(thetas[2]), 0, 1, 0, 255)
            );
            bezier(x, x,
                    xys[0][0], xys[0][1],
                    xys[1][0], xys[1][1],
                    xys[2][0], xys[2][1]);
        }
//        theta += 0.01f;
        saveFrame("output/frame-########.png");
        time_remaining--;
        System.out.println(time_remaining);
        if (time_remaining <= 0) {
            exit();
        }
    }

    public float[] getPointsOnCircle(float rx, float ry, float radius, float theta) {
        float x = rx + radius * cos(theta);
        float y = ry + radius * sin(theta);
        return new float[]{x, y};
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        BezierCircles mySketch = new BezierCircles();
        PApplet.runSketch(processingArgs, mySketch);
    }

}
