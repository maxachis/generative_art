package GeneticAlgorithms;

import processing.core.PApplet;

import java.util.ArrayList;

public class GeneticAlgorithm {


    /* Phenotypes
    * Line positions (Y)    [2]
    * Line angle            [1]
    * Line thickness        [1]
    * Line color (RGB)      [3]
    * */

    //TODO: Modify this so the lines are bezier curves.

    //Test with only line
    void run(PApplet sketch) {

        ArrayList<ArrayList<DNA>> chromosome = new ArrayList<>();

        for (int i = 0; i < sketch.width; i+=5) {
            ArrayList<DNA> sequence = new ArrayList<>();
            int finalI = i;
            DNA linePos = new DNA(sketch, 2, ((sketch1, genes) ->
                    sketch1.line(finalI,
                            sketch1.map(genes[0], 0, 1, 0, sketch1.height),
                            finalI,
                            sketch1.map(genes[1], 0, 1, 0, sketch1.height))));
            sequence.add(linePos);
            chromosome.add(sequence);
        }

        for (int i = 0; i < chromosome.size(); i++) {
            for (int u = 0; u < chromosome.get(i).size(); u++) {
                chromosome.get(i).get(u).express();
            }

        }
    }
}
