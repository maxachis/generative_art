package algorithms;

import processing.core.PApplet;

public class Floyds extends PApplet {
    final static int INF = 99999;

    public void settings() {size(900,900);}

    int graph[][] = { { 0, 5, INF, 10 },
            { INF, 0, 3, INF },
            { INF, INF, 0, 1 },
            { INF, INF, INF, 0 } };

    public void setup() {
        //Draw graph
        float n = graph.length;
        float offset = (1.0f/n) * width /2;
        float w, h;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                w =  (1.0f/n) * width * i;
                h = (1.0f/n) * height * j;
                fill(255);
                circle(w +offset ,h + offset, 25f);
                fill(0);
                text(graph[i][j], w+offset, h+offset);
            }
        }

        floydWarshall(graph);
        //Divide window by matrix
    }

    void floydWarshall(int graph[][]) {
        int V = graph.length;
        int dist[][] = new int[V][V];
        int i, j, k;
        float x1, x2, x3, y1, y2, y3;
        float offset = (1.0f/V) * width /2;

        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                    x1 = (1.0f/V) * width * i;
                    y1 = (1.0f/V) * height * j;
                    x2 = (1.0f/V) * width * i;
                    y2 = (1.0f/V) * height * k;
                    x3 = (1.0f/V) * width * k;
                    y3 = (1.0f/V) * height * j;
                    stroke(0, 0, 0, 10);
                    line(x1 + offset, y1 + offset, x2 + offset, y2 + offset);
                    line(x1 + offset, y1 + offset, x3 + offset, y3 + offset);

                }
            }
        }
    }



        public static void main(String[] args) {
        String[] processingArgs = {"MySketch"};
        Floyds mySketch = new Floyds();
        PApplet.runSketch(processingArgs, mySketch);
    }
}
