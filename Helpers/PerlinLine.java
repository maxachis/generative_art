package Helpers;

import processing.core.PApplet;

public class PerlinLine extends PApplet{
    //Single action
    CommonGeometry cg = new CommonGeometry();

    public void perlinLine(PApplet app, float x1, float y1, float x2, float y2, float steps, float jit)  {
        float[] xy;
        float[] lastXY = null;
        for (float s = steps; s > 0; s--) {
            float b = random(0, 255);
            float r = random(0, b-1);
            float g = random(0, b-1);
            app.fill(r, g, b);

            float pct = s/steps;
            xy = cg.pctOfLine(x1, y1, x2, y2, pct);
            if (lastXY == null) {
                lastXY = new float[] {x1, y1};
            }
            app.bezier(lastXY[0], lastXY[1], jitter(lastXY[0], jit), jitter(lastXY[1], jit), jitter(xy[0], jit), jitter(xy[1], jit), xy[0], xy[1]);
            lastXY = new float[] {xy[0], xy[1]};
        }
    }

    public float jitter(float val, float jitter) {return val + random(-jitter, jitter);}
}
