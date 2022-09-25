import processing.core.PApplet;
import processing.core.PVector;

public class BouncingBallPVector {
    PApplet sketch;
    PVector location;
    PVector velocity;

    BouncingBallPVector(PApplet sketch) {
        this.sketch = sketch;
    }


    void onSetup() {
        location = new PVector(100, 100);
        velocity = new PVector(2.5f, 5);
    }

    void onDraw() {
        sketch.background(255);
        location.add(velocity);
        if((location.x > sketch.width ) || (location.x < 0)) {
            velocity.x = velocity.x * -1;
        }
        if((location.y > sketch.height) || (location.y < 0)) {
            velocity.y = velocity.y * -1;
        }
        sketch.stroke(0);
        sketch.fill(175);
        sketch.ellipse(location.x, location.y, 16, 16);
    }

}
