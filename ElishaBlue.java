import Helpers.CommonGeometry;
import Helpers.PerlinLine;
import processing.core.PApplet;

public class ElishaBlue extends PApplet {

    CommonGeometry cg = new CommonGeometry();
    Recorder r = new Recorder(0, this);
    PerlinLine pl = new PerlinLine();
    float rx = 0;
    float ry = 0;
    float radius = 100;
    float triThetaVar = PI/64;

    public void settings() {size(1920, 1080);};

    public void setup() {
        background(255);
//        translate(width*0.5f, height*0.5f);
        float[] xy;

        float triR = width * 2;
        //Radiating triangles
//        for (float theta = 0; theta < TWO_PI; theta += triThetaVar) {
//            float[] xy1 = cg.calculateCoordinatesOnCircle(rx, ry, theta, triR/4);
//            pl.perlinLine(this, rx, ry, xy1[0], xy1[1], triR, 15f);
////            float[] xy2 = cg.calculateCoordinatesOnCircle(rx, ry, theta-triThetaVar, triR);
////            triangle(0, 0, xy1[0], xy1[1], xy2[0], xy2[1]);
//        }

        for (float x = 0; x <= width; x+=2) {
            pl.perlinLine(this, x, 0, x, height, height, 15f);
        }
        // Size as factor of radius
        float theta = 0;
        float sz = 500;
//        for (float r = 700; r > 0; r -= 25) {
//            xy = cg.calculateCoordinatesOnCircle(rx, ry, theta, r);
//            ellipse(xy[0], xy[1], r * 0.5f, r * 0.5f);
//            theta += PI/8;
//        }
        // Circles
//        for (float theta = 0; theta < TWO_PI; theta += PI/4) {
//            xy = cg.calculateCoordinatesOnCircle(rx, ry, theta, radius);
//            ellipse(xy[0], xy[1], 25, 25);
//        }
        r.record();


    }

    public void draw() {

    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        ElishaBlue mySketch = new ElishaBlue();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
