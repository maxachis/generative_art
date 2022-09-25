import processing.core.PApplet;

import java.awt.*;

public class IslamicGeometryPolygon extends PApplet {

    public void settings() {size(900, 900);};

    Recorder rec;

    public void setup() {
        background(255);
        translate(width*0.5f, height*0.5f);

        int n = 8;
        for(float radius = 300; radius > 0; radius-=100) {
            float dist = radius * 0.25f;
            float x, y;
            //Polygon
            fill(Color.decode("#3956cc").getRGB());
            polygon(0, 0, radius + dist * sqrt(2) * 1.25f, n, 0);




            for (int i = 0; i < n; i++) {
                y = radius;
                float x1 = dist * (sqrt(2)/2);
                float x2 = -dist * (sqrt(2)/2);
                float y1 = y + dist * (sqrt(2)/2);
                float y2 = y - dist * (sqrt(2)/2);
//            line(0, 0, 0, y);
//            line (x1, y, x2, y);
//            line(x1, y, 0, y1);

                //Triangles
                fill(Color.decode("#780f27").getRGB());
                beginShape();
                vertex(x2, y);
                vertex(x1, y + dist * sqrt(2));
                vertex(x1, y - dist * sqrt(2));
                endShape(CLOSE);
                beginShape();
                vertex(x1, y);
                vertex(x2, y + dist * sqrt(2));
                vertex(x2, y - dist * sqrt(2));
                endShape(CLOSE);
                //Square
                fill(Color.decode("#8efadd").getRGB());
                beginShape();
                vertex(0, y1);
                vertex(x1, y);
                vertex(0, y2);
                vertex(x2, y);
                endShape(CLOSE);
                rotate(TWO_PI/n);
            }
            //Inner Square
            fill(Color.decode("#064f06").getRGB());
            polygon(0f, 0f, radius - dist * sqrt(2)/2, 4, 0);
            rotate(TWO_PI/n);
            fill(Color.decode("#299444").getRGB());
            polygon(0f, 0f, radius - dist * sqrt(2)/2, 4, 0);
        }

        float radius = 100;



//        for (float theta = 0; theta <= TWO_PI; theta += PI/4) {
//            x = radius * sin(theta);
//            y = radius * cos(theta);
//            ellipse(x, y, 25, 25);
//            line(x, y, 0, 0);
//        }
    }

//    public float[][] getPerpendicularPoints(float x1, float y1, float x2, float y2, float dist) {
//        float m = (y1- y2)/(x1 - x2);
//        float mp = -pow(m, -1);
//    }

    public void draw() {
        translate(width*0.5f, height*0.5f);


//        rec.record();
    }

    public void rotatingPolygons() {
        float offsetBase = frameCount / (TWO_PI * pow(2, 4));
        translate(width*0.5f, height*0.5f);
        float baseRadius = 40;
        float x = 0;
        float y = 0;
        float offset;
        for (int i = 10; i >= 1; i--) {
            if (i % 2 == 1) {
                offset = offsetBase * -1;
            } else {
                offset = offsetBase * 1;
            }

            float pRadius = baseRadius * (i);
            float cRadius = baseRadius * i * 2;
//            fill((map(i, 1, 10, 255, 0) + frameCount) % 255 );
            fill(125 + 125 * sin((TWO_PI*i)/10+ offset));
            ellipse(x, y, cRadius, cRadius);
            fill(125 + 125 * cos((TWO_PI*i)/10+ offset));
            polygon(x, y, pRadius, i + 2, offset);
        }
    }

    public void mouseClicked() {

    }

    void polygon(float x, float y, float radius, int npoints, float offset) {
        float angle = TWO_PI / npoints;
        beginShape();
        for (float a = 0 + offset; a < TWO_PI + offset; a += angle) {
            float sx = x + cos(a) * radius;
            float sy = y + sin(a) * radius;
            vertex(sx, sy);
        }
        endShape(CLOSE);
    }

    void star(float x, float y, float radius1, float radius2, int npoints, float offset) {
        float angle = TWO_PI / npoints;
        float halfAngle = angle/2.0f;
        beginShape();
        for (float a = 0 + offset; a < TWO_PI + offset; a += angle) {
            float sx = x + cos(a) * radius2;
            float sy = y + sin(a) * radius2;
            vertex(sx, sy);
            sx = x + cos(a+halfAngle) * radius1;
            sy = y + sin(a+halfAngle) * radius1;
            vertex(sx, sy);
        }
        endShape(CLOSE);
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        IslamicGeometryPolygon mySketch = new IslamicGeometryPolygon();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
