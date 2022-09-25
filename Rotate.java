import processing.core.PApplet;
import processing.core.PVector;

public class Rotate {

    PApplet sketch;
    float angle = 0; //Location
    float aVelocity = 0.1f; //Velocity
    float aAcceleration = 0; //Acceleration

    Rotate(PApplet sketch) {
        this.sketch = sketch;
    }

    void onSetup() {
    }

    void onDraw() {
        sketch.background(255);
        sketch.fill(175);
        sketch.stroke(0);
        sketch.rectMode(sketch.CENTER);
        sketch.translate(sketch.width/2, sketch.height/2);
        sketch.rotate(angle);
        sketch.line(-50, 0, 50, 0);
        sketch.ellipse(50, 0, 8, 8);
        sketch.ellipse(-50, 0, 8, 8);
        aVelocity += aAcceleration;
        angle += aVelocity;
    }
}
