import processing.core.PApplet;

import java.sql.Array;
import java.util.ArrayList;


public class EmittingCircle extends PApplet {

    public void settings() {
        size(700,700);
    }
    float rx;
    float ry;
    float radlimit = 900;
    float radspeedmin = 0.1f;
    float radspeedmax = 10f;
    float thetaspeedmin = -0.1f;
    float thetaspeedmax = 0.1f;
    float lineMin = 10;
    float lineMax = 100;
    ArrayList<emittingPoint> p;
    ArrayList<emittingLine> l;
    ArrayList<emittingBezier> b;


    public void setup() {
        rx = width/2f;
        ry = height/2f;
        background(0);
        p = new ArrayList<>();
        l = new ArrayList<>();
        b = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            p.add(getNewEmittingPoint());
        }
        for (int i = 0; i < 120; i++) {
            l.add(getNewEmittingLine());
        }
        for (int i = 0; i < 120; i++) {
            b.add(getNewEmittingBezier());
        }
        noFill();
    }

    public void draw() {
        background(0);
        float rx = width/2f;
        float ry = height/2f;
        emittingPoint pt;
        for (int i = 0; i < p.size(); i++) {
            pt = p.get(i);
            pt.updatePoint();
            ellipse(pt.x, pt.y, 5, 5);
            if (pt.radius > radlimit) {
                p.set(i, getNewEmittingPoint());
            }
        }
        emittingLine ln;
        for (int i = 0; i < l.size(); i++) {
            ln = l.get(i);
            ln.updateLine();
            stroke(255);
            line(ln.x1, ln.y1, ln.x2, ln.y2);
            if (ln.radius - ln.lineLength > radlimit) {
                l.set(i, getNewEmittingLine());
            }
        }
        emittingBezier bz;
        for (int i = 0; i < b.size(); i++) {
            bz = b.get(i);
            bz.updateBezier();
            bezier(
                    bz.xys[0][0], bz.xys[0][1],
                    bz.xys[1][0], bz.xys[1][1],
                    bz.xys[2][0], bz.xys[2][1],
                    bz.xys[3][0], bz.xys[3][1]);
            boolean anyInRadius = false;
            for (int u = 0; u < 4; u++) {
                if (bz.radii[u] < radlimit) {
                    anyInRadius = true;
                }
            }
            if (!anyInRadius) {
//                b.set(i, getNewEmittingBezier());
            }
        }
    }

    public emittingPoint getNewEmittingPoint() {
        return new emittingPoint(
                rx, ry,
                random(radspeedmin, radspeedmax),
                random(0, TWO_PI),
                random(thetaspeedmin, thetaspeedmax)
        );
    }

    public emittingLine getNewEmittingLine() {
        return new emittingLine(
                rx, ry,
                random(lineMin, lineMax),
                random(0, TWO_PI),
                random(radspeedmin, radspeedmax),
                0
        );
    }

    public emittingBezier getNewEmittingBezier() {
        float[] thetas = new float[4];
        float[] radspeeds = new float[4];
        float[] thetaspeeds = new float[4];
        for (int i = 0; i < 4; i++) {
            thetas[i] = random(0, TWO_PI);
            radspeeds[i] = random(radspeedmin, radspeedmax);
            thetaspeeds[i] = random(thetaspeedmin, thetaspeedmax);
        }
        return new emittingBezier(
                rx, ry, thetas, radspeeds, thetaspeeds
        );
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        EmittingCircle mySketch = new EmittingCircle();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
