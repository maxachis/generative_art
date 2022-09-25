import processing.core.PApplet;

public class DNA {
    String phrase;
    String target = "to be or not to be";
    char[] genes;
    PApplet sketch;
    float fitness;

    DNA(PApplet sketch) {
        this.sketch = sketch;
        genes = new char[target.length()];
        for (int i = 0; i < genes.length; i++) {
            genes[i] = (char) sketch.random(32, 128); //Pick randomly from range of characters.
        }
    }

    void fitness() {
        int score = 0;
        for (int i = 0; i < genes.length; i++) {
            if (genes[i] == target.charAt(i)) {
                score++;
            }
        }
        fitness = (float) score / (float) target.length();
    }

    DNA crossover(DNA partner) {
        DNA child = new DNA(this.sketch);
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
                genes[i] = (char) sketch.random(32,128);
            }
        }
    }

    String getPhrase() {
        return new String(genes);
    }
}
