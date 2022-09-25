package GeneticAlgorithms;

import processing.core.PApplet;

public interface Phenotype {
    void express(PApplet sketch, float[] genes);
}
