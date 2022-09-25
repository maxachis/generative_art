package Helpers;

import processing.core.PApplet;

public class CommonGeometry extends PApplet
{

    public float[] pctOfLine(float x1, float y1, float x2, float y2, float pct) {
        float x = x1 + (x2 - x1) * pct;
        float y = y1 + (y2 - y1) * pct;
        return new float[] {x, y};
    }

    public float[] calculateCoordinatesOnCircle(float cx, float cy, float theta, float radius) {
        float sx = cx + cos(theta) * radius;
        float sy = cy + sin(theta) * radius;
        return new float[] {sx, sy};
    }
}
