package GeneticAlgorithms;

import ProcessingJava.ProcessingAbstractClass;
import processing.core.PApplet;


import java.util.ArrayList;

public class Main extends PApplet{


    DNA[] population = new DNA[100];
    ProcessingAbstractClass pac;

    public void settings() {
        size(600,600);
    }

    public void setup() {
        GeneticAlgorithm ga = new GeneticAlgorithm();
        background(255);
        fill(0);
        ga.run(this);
        //pac.onSetup();
    }

    public void draw() {
//        pac.onDraw();

    }

    public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        Main mySketch = new Main();
        PApplet.runSketch(processingArgs, mySketch);
//        PApplet.main("Main");
    }
}
