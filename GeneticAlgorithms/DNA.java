package GeneticAlgorithms;

import processing.core.PApplet;

public class DNA {
    float[] genes;
    float fitness;
    PApplet sketch;
    Phenotype phenotype;

    DNA(PApplet sketch, int segmentLength, Phenotype phenotype) {
        this.sketch = sketch;
        this.phenotype = phenotype;
        this.genes = new float[segmentLength];
        for (int i = 0; i < genes.length; i++) {
            genes[i] = sketch.random(1);
        }
    }

    void fitness(float[] target) {
        int score = 0;
        for (int i = 0; i < genes.length; i++) {
            score += Math.abs(genes[i] - target[i]);
        }
        fitness = (float) score / (float) target.length;
    }

    DNA crossover(DNA partner) {
        DNA child = new DNA(this.sketch, genes.length, this.phenotype);
        int midpoint = (int) sketch.random(genes.length);
        for (int i = 0; i < genes.length; i++) {
            if (i > midpoint) child.genes[i] = genes[i];
            else child.genes[i] = partner.genes[i];
        }
        return child;
    }

    void mutate(float mutationRate) {
        for (int i = 0; i < genes.length; i++) {
            if (sketch.random(1) < mutationRate) {
                genes[i] = sketch.random(1);
            }
        }
    }

    void express() {
        phenotype.express(sketch, genes);
    }
}
