import processing.core.PApplet;

public class InterlockingOrbit  extends PApplet {



    public void settings() {size(900, 900);};

    public void setup() {
        smooth();
        background(255);
        fill(0);
//        colorMode(HSB);
    }

    public void draw() {
//        float t = frameCount * .05f;
//        float x=(255 + frameCount) * cos(t)*sqrt(pow(cos(t),2)); // 255 = width
//        float y=(255 + frameCount) * cos(t)*sin(t);              // 255 = height
//        fill (frameCount&255,255,255);
//        ellipse(x+(width/2), y+(height/2), 32, 32);
//        t = frameCount * .05f + PI;
//        x=(255 + frameCount) * cos(t)*sqrt(pow(cos(t),2)); // 255 = width
//        y=(255 + frameCount) * cos(t)*sin(t);              // 255 = height
//        fill (255,255,frameCount&255);
//        ellipse(x+(width/2), y+(height/2), 32, 32);
        float t = frameCount * 0.05f;
        for (float a = 100; a <= 250; a += 25) {
            float[] xy = lemniscateOfBernoulli(a, t);
            ellipse(xy[0] + width/2, xy[1] + height/2, 10, 10);
        }

    }

    public float[] lemniscateOfBernoulli(float a, float t) {
        float x = (a * cos(t)) / (1 + pow(sin(t), 2));
        float y = (a * sin(t) * cos(t)) / (1 + pow(sin(t), 2));
        return new float[] {x, y};

    }


    public void updateInterlockingOrbit() {
        //Rotates in 2 phases for each circle

        //Proximal -- approaching point where radii of two circle meet
            //When next step would move point further away from other circle, switch to other circle, distal mode
        //Distal -- moving away from meeting point
            //When at farthest point away from meeting point, switch to proximal
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        InterlockingOrbit mySketch = new InterlockingOrbit();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
