import processing.core.PApplet;

import java.util.ArrayList;

public class Main extends PApplet{

    Walker w;
    PerlinCircles pc;
    PerlinNoiseWalker pnw;
    BouncingBallPVector bbpv;
    Rotate r;
    DNA[] population = new DNA[100];
    ProcessingAbstractClass pac;

    public void settings() {
        size(600,600);
    }

    public void setup() {

        pac = new GeneticAlgorithm(this);
        pac.onSetup();
//        w = new Walker(this);
//        pc = new PerlinCircles(this);
        background(255);
        fill(0);
//        pc.onSetup();

//        pnw = new PerlinNoiseWalker(this);
//        bbpv = new BouncingBallPVector(this);
//        r = new Rotate(this);
//        r.onSetup();

//        for (int i = 0; i < population.length; i++) {
//            population[i] = new DNA(this);
//        }
    }

    public void draw() {
        pac.onDraw();
//        w.step();
//        w.display();
//        pnw.onDraw();
//        r.onDraw();
//        ArrayList<DNA> matingPool = new ArrayList<DNA>();
//        for (int i = 0; i < population.length; i++) {
//            population[i].fitness();
//            int n = (int) (population[i].fitness * 100);
//            matingPool.add(population[i]);
//        }
//        int a = (int) this.random(matingPool.size());
//        int b = (int) this.random(matingPool.size());
//        DNA parentA = matingPool.get(a);
//        DNA parentB = matingPool.get(b);
    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        Main mySketch = new Main();
        PApplet.runSketch(processingArgs, mySketch);
//        PApplet.main("Main");
    }
}
