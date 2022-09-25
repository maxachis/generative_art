import processing.core.PApplet;
import processing.core.PGraphics;

public class LayerPractice  extends PApplet {

    PGraphics pg;

    public void settings() {size(200,200);}

    public void setup() {
        ellipse(width/2f, height/2f, 50, 50);
        pg = createGraphics(200, 200);
    }

    public void draw() {

        pg.beginDraw();
        pg.background(102, 0);
        pg.stroke(255);
        pg.line(pg.width*0.5f, pg.height*0.5f, mouseX, mouseY);
        pg.endDraw();
        image(pg, 0, 0);

    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        LayerPractice mySketch = new LayerPractice();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
