import processing.core.PApplet;

import java.util.ArrayList;

public class GeneticAlgorithm extends ProcessingAbstractClass {
    int totalPopulation = 150;
    DNA[] population;
    ArrayList<DNA> matingPool;
    String target;
    float mutationRate;

    GeneticAlgorithm(PApplet sketch) {
        super(sketch);
    }

    void onSetup() {
        target = "to be or not to be";
        mutationRate = 0.01f;
        population = new DNA[totalPopulation];
        for (int i = 0; i < population.length; i++) {
            population[i] = new DNA(sketch);
        }
    }

    void onDraw() {
        for (int i = 0; i < population.length; i++) {
            population[i].fitness();
        }
        ArrayList<DNA> matingPool = new ArrayList<DNA>();
        for (int i = 0; i < population.length; i++) {
            int n = (int) (population[i].fitness * 100);
            for (int j = 0; j < n; j++) {
                matingPool.add(population[i]);
            }
        }
        for (int i = 0; i < population.length; i++) {
            int a = (int) sketch.random(matingPool.size());
            int b = (int) sketch.random(matingPool.size());
            DNA partnerA = matingPool.get(a);
            DNA partnerB = matingPool.get(b);
            DNA child = partnerA.crossover(partnerB);
            child.mutate(mutationRate);
            population[i] = child;
        }
        display();
    }

    void display() {
        sketch.background(255);
        sketch.fill(0);
        sketch.text(population[0].getPhrase(), 40, 120);
    }
}
