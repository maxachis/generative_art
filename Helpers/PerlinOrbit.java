package Helpers;

import processing.core.PApplet;
import processing.core.PGraphics;

public class PerlinOrbit extends PApplet {
    float x1, x2, y1, y2;
    float rx, ry;
    float radius;
    public float radiusVar;
    public float radiusBase;
    float radiusOrig;
    float thetaOrig;
    float theta = 0;
    float thetaInc = 0.01f;
    float t = random(0, 10000);
    float tInc = 0.1f;
    float radiusVarFactor;
    float alpha = 100;
    float grayscale = 0;
    PGraphics layer;
    PApplet sketch;

    public PerlinOrbit(PApplet sketch, float radius, float radiusVar, float rx, float ry, float thetaOrig, float radiusVarFactor, PGraphics layer) {
        this.thetaOrig = thetaOrig;
        this.sketch = sketch;
        this.radiusVar = radiusVar;
        this.radiusBase = radius;
        this.radiusOrig = radius;
        this.radiusVarFactor = radiusVarFactor;
        this.rx = rx;
        this.ry = ry;
        this.layer = layer;
        reset();
    }

    public void reset() {
        theta = thetaOrig;
        radiusBase = radiusOrig;
        radiusVar = radiusBase * radiusVarFactor;
        radius = map(noise(t), 0, 1, radiusBase - radiusVar, radiusBase + radiusVar);
        x2 = rx + radius * cos(theta);
        y2 = ry + radius * sin(theta);
        x1 = rx + radius * cos(theta);
        y1 = ry + radius * sin(theta);
        layer.bezier(x1, y1, jitter(x1), jitter(y1), jitter(x2), jitter(y2), x2, y2);
    }

    public void step() {
        t += tInc;
        theta += thetaInc;
        radiusVar = radiusBase * radiusVarFactor;
        radius = map(noise(t), 0, 1, radiusBase - radiusVar, radiusBase + radiusVar);
        x2 = x1;
        y2 = y1;
        x1 = rx + radius * cos(theta);
        y1 = ry + radius * sin(theta);
        layer.bezier(x1, y1, jitter(x1), jitter(y1), jitter(x2), jitter(y2), x2, y2);
    }

    public float jitter(float val) {
        return val + random(-1, 1);
    }

}
